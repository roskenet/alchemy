"""
Module for handling ePub files.
This module provides functions to open, modify, and save ePub files.
"""
import zipfile
import os
import io
import re
import random
import string
from bs4 import BeautifulSoup

def save_epub_file(epub_contents, output_path):
    """
    Saves modified ePub content back to disk.

    Args:
        epub_contents (dict): Dictionary mapping file paths to their content
        output_path (str): Path where the modified ePub file should be saved

    Raises:
        IOError: If there is an error writing the file
    """
    with zipfile.ZipFile(output_path, 'w', compression=zipfile.ZIP_DEFLATED) as epub_zip:
        for file_name, content in epub_contents.items():
            epub_zip.writestr(file_name, content)

def generate_random_id(length=5):
    """
    Generates a pseudo-random ID of specified length.

    Args:
        length (int): Length of the ID to generate

    Returns:
        str: A random string of specified length using 0-9, a-z, and A-Z
    """
    return ''.join(random.choices(string.ascii_lowercase + string.ascii_uppercase + string.digits, k=length))

def get_standard_stylesheet():
    """
    Returns a standard stylesheet for English language novels.

    Returns:
        str: A CSS stylesheet with common styles for English novels
    """
    return """
    body {
        font-family: 'Georgia', serif;
        line-height: 1.5;
        margin: 0 5%;
        text-align: justify;
        font-size: 1em;
    }
    h1, h2, h3, h4, h5, h6 {
        font-family: 'Times New Roman', serif;
        line-height: 1.2;
        margin: 1em 0 0.5em 0;
        text-align: center;
    }
    h1 {
        font-size: 1.5em;
    }
    h2 {
        font-size: 1.3em;
    }
    p {
        margin: 0.5em 0;
        text-indent: 1.5em;
    }
    p.first, h1 + p, h2 + p, h3 + p, h4 + p, h5 + p, h6 + p {
        text-indent: 0;
    }
    blockquote {
        margin: 1em 2em;
        font-style: italic;
    }
    .chapter {
        margin-top: 2em;
    }
    .title {
        font-weight: bold;
        font-size: 1.2em;
    }
    .subtitle {
        font-style: italic;
        margin-bottom: 1em;
    }
    .footnote {
        font-size: 0.9em;
        margin: 0.5em 0;
    }
    """

def process_xhtml_content(content):
    """
    Processes XHTML content to replace style information with a standard stylesheet and add random IDs.

    Args:
        content (bytes): The XHTML content as bytes

    Returns:
        bytes: The modified XHTML content
    """
    # Convert bytes to string for BeautifulSoup
    content_str = content.decode('utf-8')

    # Parse the XHTML
    soup = BeautifulSoup(content_str, 'html.parser')

    # Remove style attributes and style tags
    for tag in soup.find_all(True):
        if tag.has_attr('style'):
            del tag['style']
        if tag.has_attr('class'):
            del tag['class']

    # Remove style tags
    for style_tag in soup.find_all('style'):
        style_tag.decompose()

    # Add random IDs to all elements and paragraphs
    for tag in soup.find_all(True):
        tag['id'] = generate_random_id()

    # Add standard stylesheet
    head_tag = soup.find('head')
    if head_tag:
        # Create a new style tag
        style_tag = soup.new_tag('style')
        style_tag['type'] = 'text/css'
        style_tag.string = get_standard_stylesheet()

        # Add it to the head
        head_tag.append(style_tag)

    # Convert back to bytes
    return soup.encode()

def process_css_content():
    """
    Creates a standard CSS file content for English language novels.

    Returns:
        bytes: The CSS content as bytes
    """
    return get_standard_stylesheet().encode('utf-8')

def process_epub_file(file_path, output_path=None):
    """
    Processes an ePub file to replace style information with a standard stylesheet and add random IDs.

    Args:
        file_path (str): Path to the ePub file to process
        output_path (str, optional): Path where the modified ePub file should be saved.
            If not provided, the original file will be overwritten.

    Returns:
        str: Path to the processed ePub file

    Raises:
        FileNotFoundError: If the specified file does not exist
        ValueError: If the file is not a valid ePub file
    """
    # If no output path is provided, overwrite the original file
    if output_path is None:
        output_path = file_path

    # Open the ePub file
    epub_contents, metadata = open_epub_file(file_path)

    # Process XHTML files
    for file_name in metadata['file_list']:
        if file_name.endswith('.xhtml') or file_name.endswith('.html'):
            epub_contents[file_name] = process_xhtml_content(epub_contents[file_name])
        elif file_name.endswith('.css'):
            # Replace CSS files with our standard stylesheet
            epub_contents[file_name] = process_css_content()

    # Save the modified ePub
    save_epub_file(epub_contents, output_path)

    return output_path

def open_epub_file(file_path):
    """
    Opens an ePub file from disk into memory for content modification.

    ePub files are essentially ZIP archives containing HTML, CSS, and other files.
    This function extracts the ePub file into memory, allowing for content modification
    before saving it back to disk.

    Args:
        file_path (str): Path to the ePub file to open

    Returns:
        tuple: A tuple containing:
            - dict: A dictionary mapping file paths within the ePub to their content
            - dict: Metadata about the ePub file

    Raises:
        FileNotFoundError: If the specified file does not exist
        ValueError: If the file is not a valid ePub file
    """
    import zipfile
    import os
    import io

    # Check if file exists
    if not os.path.exists(file_path):
        raise FileNotFoundError(f"The file {file_path} does not exist")

    # Check if file is a valid ePub (which is essentially a ZIP file)
    if not zipfile.is_zipfile(file_path):
        raise ValueError(f"The file {file_path} is not a valid ePub file")

    # Dictionary to store file contents
    epub_contents = {}

    # Dictionary to store metadata
    metadata = {
        'file_path': file_path,
        'file_name': os.path.basename(file_path)
    }

    # Open the ePub file as a ZIP archive
    with zipfile.ZipFile(file_path, 'r') as epub_zip:
        # Get list of all files in the ePub
        file_list = epub_zip.namelist()

        # Store metadata about files
        metadata['file_list'] = file_list

        # Extract each file's content into memory
        for file_name in file_list:
            with epub_zip.open(file_name) as file:
                # Read file content into memory
                content = file.read()
                epub_contents[file_name] = content

    return epub_contents, metadata
