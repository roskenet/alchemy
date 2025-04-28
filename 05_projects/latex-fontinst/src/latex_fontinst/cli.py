#!/usr/bin/env python3
"""
Command-line tool for converting OTF fonts to TeX-compatible formats.
"""
import argparse
import os
import sys
import glob
import shutil
from pathlib import Path
from typing import List, Optional

from latex_fontinst.font_processor import FontProcessor


def find_otf_files(input_dir: str) -> List[str]:
    """
    Find all OTF font files in the input directory.

    Args:
        input_dir: Path to the directory containing OTF files

    Returns:
        List of paths to OTF files
    """
    otf_pattern = os.path.join(input_dir, "**", "*.otf")
    return glob.glob(otf_pattern, recursive=True)


def create_texlive_structure(output_dir: str) -> None:
    """
    Create a TeX Live compatible directory structure in the output directory.

    Args:
        output_dir: Directory where the TeX Live structure will be created
    """
    # Create TeX Live directory structure
    texmf_dir = os.path.join(output_dir, 'texmf')
    fonts_dir = os.path.join(texmf_dir, 'fonts')
    tex_dir = os.path.join(texmf_dir, 'tex')

    os.makedirs(fonts_dir, exist_ok=True)
    os.makedirs(tex_dir, exist_ok=True)


def main() -> int:
    """
    Main entry point for the command-line tool.

    Returns:
        Exit code (0 for success, non-zero for failure)
    """
    parser = argparse.ArgumentParser(
        description="Convert OTF fonts to TeX-compatible formats"
    )
    parser.add_argument(
        "-i", "--input-dir",
        required=True,
        help="Directory containing OTF font files"
    )
    parser.add_argument(
        "-o", "--output-dir",
        required=True,
        help="Directory where generated files will be saved"
    )
    parser.add_argument(
        "-v", "--verbose",
        action="store_true",
        help="Enable verbose output"
    )

    args = parser.parse_args()

    # Validate input directory
    if not os.path.isdir(args.input_dir):
        print(f"Error: Input directory '{args.input_dir}' does not exist", file=sys.stderr)
        return 1

    # Create output directory if it doesn't exist
    os.makedirs(args.output_dir, exist_ok=True)

    # Create TeX Live directory structure
    create_texlive_structure(args.output_dir)

    # Find OTF files
    otf_files = find_otf_files(args.input_dir)

    if not otf_files:
        print(f"No OTF files found in '{args.input_dir}'", file=sys.stderr)
        return 1

    if args.verbose:
        print(f"Found {len(otf_files)} OTF files")

    # Process each font file
    success_count = 0
    processor = FontProcessor(verbose=args.verbose)
    for font_path in otf_files:
        if args.verbose:
            print(f"Processing {font_path}")

        if processor.process_font(font_path, args.output_dir):
            success_count += 1

    if args.verbose:
        print(f"Successfully processed {success_count} out of {len(otf_files)} fonts")

    return 0


if __name__ == "__main__":
    sys.exit(main())
