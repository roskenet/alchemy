#!/usr/bin/env python3
"""
Command-line interface for the secoder tool.
"""

import argparse
import sys
import logging
from secoder.secret_handler import SecretHandler

# Configure logging
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s'
)


def parse_args(args=None):
    """Parse command line arguments."""
    parser = argparse.ArgumentParser(
        description="Secoder - A tool for handling secrets with PGP encryption."
    )
    
    parser.add_argument(
        "--secret-dir",
        help="Directory containing secrets",
        required=False,
    )
    
    parser.add_argument(
        "--pgp-key",
        help="PGP key to use for encryption/decryption",
        required=False,
    )
    
    parser.add_argument(
        "--key-password",
        help="Password for the PGP key",
        required=False,
    )
    
    return parser.parse_args(args)


def main(args=None):
    """Main entry point for the application."""
    args = parse_args(args)
    
    # Check if required arguments are provided
    if not args.secret_dir:
        logging.error("--secret-dir is required")
        return 1
    
    if not args.pgp_key:
        logging.error("--pgp-key is required")
        return 1
    
    if not args.key_password:
        logging.error("--key-password is required")
        return 1
    
    # Create a SecretHandler instance
    handler = SecretHandler(
        secret_dir=args.secret_dir,
        pgp_key=args.pgp_key,
        key_password=args.key_password
    )
    
    # Process secrets
    if handler.process_secrets():
        logging.info("Successfully processed secrets")
        return 0
    else:
        logging.error("Failed to process secrets")
        return 1


if __name__ == "__main__":
    sys.exit(main())