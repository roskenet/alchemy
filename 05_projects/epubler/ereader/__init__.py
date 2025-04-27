"""
ereader package for handling electronic books.
"""

from .epub_handler import open_epub_file, process_epub_file

__all__ = ['open_epub_file', 'process_epub_file']
