#!/usr/bin/env python3
"""
Nakadi Event Listener

This script connects to Zalando's Nakadi event broker using nakadi-python,
subscribes to a specified event type, and listens for events.

Usage:
    python main.py --event-name <event_name> [--nakadi-url <nakadi_url>] [--subscription-id <subscription_id>]
"""

import argparse
import json
import logging
import sys
from typing import Dict, Any, List

try:
    from nakadi_client import NakadiClient
except ImportError:
    print("Error: nakadi-python package is not installed.")
    print("Please install it using: pip install nakadi-python")
    sys.exit(1)

# Configure logging
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s'
)
logger = logging.getLogger(__name__)

def parse_arguments() -> argparse.Namespace:
    """Parse command line arguments."""
    parser = argparse.ArgumentParser(description='Nakadi Event Listener')
    parser.add_argument(
        '--event-name',
        required=True,
        help='Name of the event type to subscribe to'
    )
    parser.add_argument(
        '--nakadi-url',
        default='https://nakadi.example.com',
        help='URL of the Nakadi server (default: https://nakadi.example.com)'
    )
    parser.add_argument(
        '--subscription-id',
        help='Existing subscription ID (if not provided, a new subscription will be created)'
    )
    parser.add_argument(
        '--token',
        help='OAuth token for authentication'
    )
    return parser.parse_args()

def process_events(events: List[Dict[str, Any]]) -> None:
    """Process received events.

    Args:
        events: List of event dictionaries
    """
    for event in events:
        logger.info(f"Received event: {json.dumps(event, indent=2)}")

def create_subscription(client: NakadiClient, event_name: str) -> str:
    """Create a new subscription for the specified event type.

    Args:
        client: NakadiClient instance
        event_name: Name of the event type to subscribe to

    Returns:
        Subscription ID
    """
    subscription = client.create_subscription(
        owning_application="nakadi-listener",
        event_types=[event_name],
        consumer_group="nakadi-listener-group"
    )
    subscription_id = subscription['id']
    logger.info(f"Created subscription with ID: {subscription_id}")
    return subscription_id

def listen_events(client: NakadiClient, subscription_id: str) -> None:
    """Listen for events using the specified subscription.

    Args:
        client: NakadiClient instance
        subscription_id: ID of the subscription to use
    """
    logger.info(f"Starting to listen for events using subscription {subscription_id}")

    try:
        # Start consuming events
        for events in client.get_subscription_events_stream(
            subscription_id=subscription_id,
            max_uncommitted_events=100,
            batch_limit=50,
            stream_timeout=60
        ):
            if events:
                process_events(events)
                # Commit the cursor to acknowledge processing
                client.commit_subscription_cursors(
                    subscription_id=subscription_id,
                    cursors=events.get('cursor', {})
                )
    except KeyboardInterrupt:
        logger.info("Received keyboard interrupt. Shutting down...")
    except Exception as e:
        logger.error(f"Error while listening for events: {e}")
        raise

def main() -> None:
    """Main function to run the Nakadi event listener."""
    args = parse_arguments()

    # Initialize Nakadi client
    client_kwargs = {
        'nakadi_url': args.nakadi_url,
    }

    if args.token:
        client_kwargs['access_token'] = args.token

    try:
        client = NakadiClient(**client_kwargs)

        # Check if the event type exists
        try:
            client.get_event_type(args.event_name)
            logger.info(f"Event type '{args.event_name}' exists")
        except Exception as e:
            logger.error(f"Error checking event type: {e}")
            logger.error(f"Event type '{args.event_name}' may not exist")
            sys.exit(1)

        # Get or create subscription
        subscription_id = args.subscription_id
        if not subscription_id:
            subscription_id = create_subscription(client, args.event_name)
        else:
            logger.info(f"Using existing subscription with ID: {subscription_id}")

        # Listen for events
        listen_events(client, subscription_id)

    except Exception as e:
        logger.error(f"Error: {e}")
        sys.exit(1)

if __name__ == '__main__':
    main()
