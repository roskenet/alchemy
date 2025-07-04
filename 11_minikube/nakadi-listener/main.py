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
        default='http://nakadi.minikube',
        help='URL of the Nakadi server (default: http://nakadi.minikube)'
    )
    parser.add_argument(
        '--subscription-id',
        help='Existing subscription ID (if not provided, a new subscription will be created)'
    )
    return parser.parse_args()

def main() -> None:
    """Main function to run the Nakadi event listener."""
    args = parse_arguments()

    # Initialize Nakadi client
    client_kwargs = {
        'nakadi_url': args.nakadi_url,
        'token': 'dummy-token'
    }


if __name__ == '__main__':
    main()
