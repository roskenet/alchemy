from ereader import open_epub_file
from ereader.epub_handler import process_xhtml_content
from bs4 import BeautifulSoup

def check_bold_italic_tags(epub_path):
    """
    Check if bold and italic tags are preserved in the ePub file.

    Args:
        epub_path (str): Path to the ePub file to check
    """
    print(f"Checking for bold and italic tags in: {epub_path}")

    # Open the ePub file
    contents, metadata = open_epub_file(epub_path)

    # Count bold and italic tags in XHTML files
    bold_count = 0
    italic_count = 0

    for file_name in metadata['file_list']:
        if file_name.endswith('.xhtml') or file_name.endswith('.html'):
            content = contents[file_name].decode('utf-8')
            soup = BeautifulSoup(content, 'html.parser')

            # Count bold tags
            bold_tags = soup.find_all(['b', 'strong'])
            bold_count += len(bold_tags)

            # Count italic tags
            italic_tags = soup.find_all(['i', 'em'])
            italic_count += len(italic_tags)

            # Print details for this file
            if bold_tags or italic_tags:
                print(f"\nFile: {file_name}")
                print(f"  Bold tags: {len(bold_tags)}")
                print(f"  Italic tags: {len(italic_tags)}")

    print(f"\nTotal bold tags found: {bold_count}")
    print(f"Total italic tags found: {italic_count}")

    return bold_count > 0 or italic_count > 0

def test_direct_processing():
    """
    Test the process_xhtml_content function directly with a sample XHTML file
    containing bold and italic tags.
    """
    print("\n=== Testing direct processing of XHTML with bold and italic tags ===")

    # Create a sample XHTML content with bold and italic tags
    sample_xhtml = """
    <!DOCTYPE html>
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Test Document</title>
        <style>
            body { font-family: Arial; }
            p { margin: 1em 0; }
            .bold-class { font-weight: bold; }
            .italic-class { font-style: italic; }
        </style>
    </head>
    <body>
        <h1 style="color: blue;">Test Document</h1>
        <p>This is a <b>bold</b> text.</p>
        <p>This is a <strong>strong</strong> text.</p>
        <p>This is an <i>italic</i> text.</p>
        <p>This is an <em>emphasized</em> text.</p>
        <p class="bold-class">This has a bold class.</p>
        <p class="italic-class">This has an italic class.</p>
        <p style="font-weight: bold;">This has bold style.</p>
        <p style="font-style: italic;">This has italic style.</p>
    </body>
    </html>
    """.encode('utf-8')

    # Process the sample XHTML
    processed_xhtml = process_xhtml_content(sample_xhtml)

    # Parse the processed XHTML
    soup = BeautifulSoup(processed_xhtml, 'html.parser')

    # Check if bold and italic tags are preserved
    bold_tags = soup.find_all(['b', 'strong'])
    italic_tags = soup.find_all(['i', 'em'])

    print(f"Bold tags after processing: {len(bold_tags)}")
    for tag in bold_tags:
        print(f"  {tag.name}: {tag.text}")

    print(f"Italic tags after processing: {len(italic_tags)}")
    for tag in italic_tags:
        print(f"  {tag.name}: {tag.text}")

    # Check if the tags have been preserved correctly
    if len(bold_tags) == 2 and len(italic_tags) == 2:
        print("\n✅ Bold and italic tags are preserved after processing.")
    else:
        print("\n❌ Bold and italic tags are not preserved correctly after processing.")

    # Check if style and class attributes are handled correctly
    bold_class_p = soup.find('p', class_='bold-class')
    italic_class_p = soup.find('p', class_='italic-class')

    if bold_class_p and 'class' in bold_class_p.attrs:
        print("✅ Class attribute for bold styling is preserved.")
    else:
        print("❌ Class attribute for bold styling is not preserved.")

    if italic_class_p and 'class' in italic_class_p.attrs:
        print("✅ Class attribute for italic styling is preserved.")
    else:
        print("❌ Class attribute for italic styling is not preserved.")

    # Check if inline styles are removed
    styled_bold_p = soup.find('p', text=lambda text: text and 'This has bold style.' in text)
    styled_italic_p = soup.find('p', text=lambda text: text and 'This has italic style.' in text)

    if styled_bold_p and not styled_bold_p.has_attr('style'):
        print("✅ Inline style for bold is correctly removed.")
    else:
        print("❌ Inline style for bold is not correctly handled.")

    if styled_italic_p and not styled_italic_p.has_attr('style'):
        print("✅ Inline style for italic is correctly removed.")
    else:
        print("❌ Inline style for italic is not correctly handled.")

    return len(bold_tags) == 2 and len(italic_tags) == 2

if __name__ == '__main__':
    # Check the original file
    original_path = "testbook/Fahrenheit451.epub"
    print("\n=== Checking original file ===")
    original_has_tags = check_bold_italic_tags(original_path)

    # Check the processed file
    processed_path = "testbook/Fahrenheit451_processed.epub"
    print("\n=== Checking processed file ===")
    processed_has_tags = check_bold_italic_tags(processed_path)

    # Compare results
    if original_has_tags and processed_has_tags:
        print("\n✅ Bold and italic tags are preserved in the processed file.")
    elif original_has_tags and not processed_has_tags:
        print("\n❌ Bold and italic tags were in the original file but are missing in the processed file.")
    elif not original_has_tags:
        print("\n⚠️ No bold or italic tags found in the original file, so preservation cannot be verified.")

    # Test direct processing of XHTML with bold and italic tags
    test_direct_processing()
