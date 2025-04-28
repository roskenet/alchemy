#!/usr/bin/env python3
"""
Test script for the FontProcessor class.

This script demonstrates how to use the FontProcessor class directly
in your own Python scripts.
"""
import os
import sys
import tempfile
from pathlib import Path

# Add the src directory to the Python path
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), "..", "src")))

from latex_fontinst.font_processor import FontProcessor


def test_process_font(font_path, output_dir, verbose=True):
    """
    Test processing a single font file.
    
    Args:
        font_path: Path to the OTF font file
        output_dir: Directory where generated files will be saved
        verbose: Whether to print verbose output
    """
    processor = FontProcessor(verbose=verbose)
    
    print(f"Processing font: {font_path}")
    result = processor.process_font(font_path, output_dir)
    
    if result:
        print(f"Successfully processed font: {font_path}")
        print(f"Output files are in: {output_dir}")
    else:
        print(f"Failed to process font: {font_path}")


def test_process_directory(input_dir, output_dir, verbose=True):
    """
    Test processing all OTF files in a directory.
    
    Args:
        input_dir: Directory containing OTF font files
        output_dir: Directory where generated files will be saved
        verbose: Whether to print verbose output
    """
    import glob
    
    processor = FontProcessor(verbose=verbose)
    
    # Find all OTF files in the input directory
    otf_pattern = os.path.join(input_dir, "**", "*.otf")
    otf_files = glob.glob(otf_pattern, recursive=True)
    
    if not otf_files:
        print(f"No OTF files found in {input_dir}")
        return
    
    print(f"Found {len(otf_files)} OTF files")
    
    # Process each font file
    success_count = 0
    for font_path in otf_files:
        if verbose:
            print(f"Processing {font_path}")
        
        if processor.process_font(font_path, output_dir):
            success_count += 1
    
    print(f"Successfully processed {success_count} out of {len(otf_files)} fonts")
    print(f"Output files are in: {output_dir}")


def main():
    """
    Main function to demonstrate the FontProcessor class.
    """
    # Check if a font file or directory was provided
    if len(sys.argv) < 2:
        print("Usage: python test_font_processor.py <font_file_or_directory>")
        return 1
    
    path = sys.argv[1]
    
    # Create a temporary output directory
    with tempfile.TemporaryDirectory() as output_dir:
        if os.path.isfile(path) and path.lower().endswith('.otf'):
            # Process a single font file
            test_process_font(path, output_dir)
        elif os.path.isdir(path):
            # Process all OTF files in a directory
            test_process_directory(path, output_dir)
        else:
            print(f"Error: {path} is not a valid OTF file or directory")
            return 1
    
    return 0


if __name__ == "__main__":
    sys.exit(main())