#!/usr/bin/env python3
"""
Command-line interface for the secoder tool.
"""

import argparse
import sys


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
    
    # Print Hello World and the three options
    print(f"Hello World and the three options:")
    print(f"  --secret-dir: {args.secret_dir}")
    print(f"  --pgp-key: {args.pgp_key}")
    print(f"  --key-password: {args.key_password}")
    
    return 0


if __name__ == "__main__":
    sys.exit(main())