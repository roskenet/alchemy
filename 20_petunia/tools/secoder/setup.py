#!/usr/bin/env python3
"""
Setup script for the secoder package.
"""

from setuptools import setup, find_packages

# Read the version from the package
with open('secoder/__init__.py', 'r') as f:
    for line in f:
        if line.startswith('__version__'):
            version = line.split('=')[1].strip().strip("'").strip('"')
            break
    else:
        version = '0.1.0'

setup(
    name="secoder",
    version=version,
    description="A tool for handling secrets with PGP encryption",
    author="JetBrains",
    author_email="info@jetbrains.com",
    url="https://github.com/jetbrains/secoder",
    packages=find_packages(),
    entry_points={
        'console_scripts': [
            'secoder=secoder.cli:main',
        ],
    },
    classifiers=[
        "Development Status :: 3 - Alpha",
        "Intended Audience :: Developers",
        "License :: OSI Approved :: MIT License",
        "Programming Language :: Python :: 3",
        "Programming Language :: Python :: 3.6",
        "Programming Language :: Python :: 3.7",
        "Programming Language :: Python :: 3.8",
        "Programming Language :: Python :: 3.9",
    ],
    python_requires=">=3.6",
)