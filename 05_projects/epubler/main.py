import os

from ereader import open_epub_file, process_epub_file


def example_epub_handling(epub_path):
    """
    Example function demonstrating how to use the open_epub_file function.

    Args:
        epub_path (str): Path to an ePub file
    """
    try:
        # Open the ePub file
        contents, metadata = open_epub_file(epub_path)

        # Print some information about the ePub
        print(f"Successfully opened ePub: {metadata['file_name']}")
        print(f"Number of files in ePub: {len(metadata['file_list'])}")

        # List the files in the ePub
        print("\nFiles in the ePub:")
        for file_name in metadata['file_list']:
            print(f"- {file_name} ({len(contents[file_name])} bytes)")

        # Here you could modify the contents of any file in the ePub
        # For example:
        # if 'OEBPS/content.opf' in contents:
        #     contents['OEBPS/content.opf'] = contents['OEBPS/content.opf'].replace(b'old text', b'new text')

        print("\nePub file is now in memory and ready for modification.")

    except FileNotFoundError as e:
        print(f"Error: {e}")
    except ValueError as e:
        print(f"Error: {e}")


def process_epub_example(epub_path):
    """
    Example function demonstrating how to use the process_epub_file function
    to replace style information with a standard stylesheet for English language novels
    and add random IDs to elements in XHTML files.

    Args:
        epub_path (str): Path to an ePub file
    """
    try:
        # Create an output path for the processed ePub
        output_path = epub_path.replace('.epub', '_processed.epub')

        print(f"Processing ePub file: {epub_path}")
        print(f"Output will be saved to: {output_path}")

        # Process the ePub file
        processed_path = process_epub_file(epub_path, output_path)

        print(f"\nSuccessfully processed ePub file.")
        print(f"Processed file saved to: {processed_path}")

        # Open the processed ePub to verify changes
        contents, metadata = open_epub_file(processed_path)

        print(f"\nVerifying processed ePub: {metadata['file_name']}")
        print(f"Number of files in processed ePub: {len(metadata['file_list'])}")

        # Count XHTML files that were processed
        xhtml_count = sum(1 for file_name in metadata['file_list'] 
                         if file_name.endswith('.xhtml') or file_name.endswith('.html'))

        print(f"Number of XHTML files processed: {xhtml_count}")
        print("\nAll style information has been replaced with a standard stylesheet for English language novels")
        print("and random IDs have been added to all elements.")

    except FileNotFoundError as e:
        print(f"Error: {e}")
    except ValueError as e:
        print(f"Error: {e}")


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    # Example usage of the ePub handler
    # Replace with the path to an actual ePub file
    example_epub_path = "testbook/Fahrenheit451.epub"
    if os.path.exists(example_epub_path):
        # Uncomment the function you want to run
        # example_epub_handling(example_epub_path)
        process_epub_example(example_epub_path)
    else:
        print(f"\nTo test ePub handling, replace 'example_epub_path' with the path to an actual ePub file.")

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
