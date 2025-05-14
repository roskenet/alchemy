#!/usr/bin/env python3
"""
Main application that reads command line options and passes them to the options_handler module.
"""

import argparse
import options_handler

def main():
    """
    Main function that parses command line arguments and processes them.
    """
    # Create argument parser
    parser = argparse.ArgumentParser(
        description="A simple application that demonstrates command line option handling",
        add_help=False  # We'll handle help manually to use our custom help message
    )
    
    # Add arguments
    parser.add_argument("-h", "--help", action="store_true", help="Show help message and exit")
    parser.add_argument("-n", "--name", type=str, default="World", help="Specify a name to greet")
    parser.add_argument("-c", "--count", type=int, default=1, help="Specify how many times to repeat the greeting")
    parser.add_argument("-v", "--verbose", action="store_true", help="Enable verbose output")
    
    # Parse arguments
    args = parser.parse_args()
    
    # Handle help option
    if args.help:
        print(options_handler.get_help_message())
        return
    
    # Convert args to dictionary for the options_handler
    options = {
        "name": args.name,
        "count": args.count,
        "verbose": args.verbose
    }
    
    # Process options using our module
    result = options_handler.process_options(options)
    
    # Print the result
    if args.verbose:
        print(result)
    
    # Print the greeting
    for _ in range(args.count):
        print(f"Hello, {args.name}!")

if __name__ == "__main__":
    main()
