from nakadi import NakadiClient, NakadiException, NakadiStream
import logging
logger = logging.getLogger("nakadi-python")

subscription_id = '<subscription id>'
batch_limit = 10 # Maximum number of events per batch

def get_subscription_stream(
    token: str,
    host: str,
    subscription_id: str,
    batch_limit: int
) -> NakadiStream:
    """Fetches a subscription event stream."""
    try:
        client = NakadiClient(token, host)
        # stream_limit=batch_limit means the stream will close after emitting
        # one batch of up to batch_limit events. For continuous streaming,
        # you would typically omit stream_limit or set it much higher.
        # This example gets one batch at a time.
        return client.get_subscription_events_stream(
            subscription_id,
            batch_limit=batch_limit,
            stream_limit=batch_limit
        )
    except NakadiException as ex:
        logger.exception(
            f'NakadiException while getting stream: {ex.msg}',
            exc_info=ex
        )
        raise ex
    except Exception as ex:
        logger.exception(
            'Unexpected Exception while getting stream from Nakadi', exc_info=ex)
        raise ex


def process_batch(batch_data: dict):
    """Processes a single batch of events."""
    cursor = batch_data.get('cursor')
    events = batch_data.get('events')

    if not events:
        logger.info("Received empty batch.")
        return cursor, [] # Return cursor even if no events,
        # allows committing empty batch if needed

    logger.info(
        f"Received batch with {len(events)} events from "
        f"partition {cursor.get('partition')} at offset {cursor.get('offset')}"
    )

    processed_events = []
    for event in events:
        try:
            # --- YOUR EVENT PROCESSING LOGIC GOES HERE ---
            logger.debug(
                f"Processing event: {event.get('metadata', {}).get('eid')}"
            )
            # Example:
            # if event.get('data', {}).get('status') == 'completed':
            #    process_completion(event)
            # ---------------------------------------------
            # Optionally keep track of processed events
            processed_events.append(event)

        except Exception as event_ex:
            logger.error(
                f"Error processing event {event.get('metadata', {}).get('eid')}"
                f": {event_ex}", exc_info=event_ex)
            # Depending on your error handling strategy, you might skip this
            # event or stop processing the batch.

    return cursor, processed_events


def commit_cursors(
    token: str,
    host: str,
    subscription_id: str,
    stream_id: str,
    cursors: list
):
    """Commits cursors for a subscription."""
    if not cursors:
        logger.info("No cursors to commit.")
        return
    try:
        client = NakadiClient(token, host)
        client.commit_subscription_cursors(subscription_id, stream_id, cursors)
        logger.info(f"Successfully committed {len(cursors)} cursors for stream {stream_id}")
    except NakadiException as ex:
        logger.exception(f'NakadiException while committing cursors: {ex.msg}', exc_info=ex)
        # Depending on the error code (e.g., 409 Conflict), you might need
        # different retry logic.
        raise ex
    except Exception as ex:
        logger.exception(
            'Unexpected Exception while committing Nakadi cursors', exc_info=ex)
        raise ex


# --- Example usage flow ---
try:
    subscription_stream = get_subscription_stream(token, host, subscription_id, batch_limit)

    # The stream yields one batch (a dictionary) at a time until stream_limit
    # is reached or stream is closed
    batch = next(subscription_stream)
    # Get the stream ID from the stream object
    stream_id = subscription_stream.stream_id

    cursor, processed_events = process_batch(batch)

    # After processing the events in the batch, commit the cursor
    if cursor: # Ensure a cursor was received
        commit_cursors(token, host, subscription_id, stream_id, [cursor])

except StopIteration:
    logger.info("Stream closed or no more batches available.")
except Exception as ex:
    logger.exception(
        'Exception during Nakadi event consumption process', exc_info=ex)
    # Decide on retry/error handling logic based on the exception

finally:
    # Ensure the stream connection is closed
    if 'subscription_stream' in locals() and not subscription_stream.closed():
         subscription_stream.close()
         logger.info("Subscription stream closed.")