"""
Module for handling command line options.
This module provides functionality to process and utilize command line arguments.
"""

def process_options(options):
    """
    Process the command line options passed from the main application.
    
    Args:
        options (dict): A dictionary containing command line options.
        
    Returns:
        str: A message indicating the processed options.
    """
    if not options:
        return "No options provided."
    
    result = "Processed options:\n"
    for key, value in options.items():
        result += f"- {key}: {value}\n"
    
    return result

def get_help_message():
    """
    Returns a help message for the application.
    
    Returns:
        str: Help message with available options.
    """
    return """
    Usage: python hello.py [options]
    
    Options:
      -h, --help     Show this help message and exit
      -n, --name     Specify a name to greet
      -c, --count    Specify how many times to repeat the greeting
      -v, --verbose  Enable verbose output
    """