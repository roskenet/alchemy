# Nakadi Event Listener

A Python client for Zalando's Nakadi event broker that subscribes to and listens for events of a specified type.

## Installation

1. Clone this repository:
   ```
   git clone https://github.com/yourusername/nakadi-listener.git
   cd nakadi-listener
   ```

2. Install the required dependencies:
   ```
   pip install -r requirements.txt
   ```

## Usage

Run the script with the required `--event-name` parameter:

```
python main.py --event-name your-event-name
```

### Command Line Arguments

- `--event-name` (required): Name of the event type to subscribe to
- `--nakadi-url` (optional): URL of the Nakadi server (default: https://nakadi.example.com)
- `--subscription-id` (optional): Existing subscription ID (if not provided, a new subscription will be created)
- `--token` (optional): OAuth token for authentication

### Examples

1. Basic usage with default Nakadi URL:
   ```
   python main.py --event-name order.created
   ```

2. Specify a custom Nakadi URL:
   ```
   python main.py --event-name order.created --nakadi-url https://your-nakadi-instance.com
   ```

3. Use an existing subscription:
   ```
   python main.py --event-name order.created --subscription-id your-subscription-id
   ```

4. Provide an OAuth token for authentication:
   ```
   python main.py --event-name order.created --token your-oauth-token
   ```

## How It Works

1. The script connects to the specified Nakadi server
2. It creates a new subscription for the specified event type (or uses an existing one)
3. It starts listening for events on that subscription
4. When events are received, they are logged to the console

## Troubleshooting

If you encounter the error "nakadi-python package is not installed", make sure you've installed the dependencies:

```
pip install -r requirements.txt
```

If you're having issues with authentication, make sure you're providing a valid OAuth token with the `--token` parameter.

## License

This project is licensed under the MIT License - see the LICENSE file for details.