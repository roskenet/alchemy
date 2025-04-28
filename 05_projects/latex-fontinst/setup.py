#!/usr/bin/env python3
from setuptools import setup, find_packages

setup(
    name="latex-fontinst",
    version="0.1.0",
    description="Tool for converting OTF fonts to TeX-compatible formats",
    author="Your Name",
    author_email="your.email@example.com",
    url="https://github.com/yourusername/latex-fontinst",
    packages=find_packages(where="src"),
    package_dir={"": "src"},
    install_requires=[
        "fonttools>=4.0.0",
    ],
    entry_points={
        "console_scripts": [
            "latex-fontinst=latex_fontinst.cli:main",
        ],
    },
    classifiers=[
        "Development Status :: 3 - Alpha",
        "Intended Audience :: Developers",
        "Intended Audience :: Science/Research",
        "License :: OSI Approved :: MIT License",
        "Programming Language :: Python :: 3",
        "Programming Language :: Python :: 3.6",
        "Programming Language :: Python :: 3.7",
        "Programming Language :: Python :: 3.8",
        "Programming Language :: Python :: 3.9",
        "Topic :: Text Processing :: Fonts",
        "Topic :: Text Processing :: Markup :: LaTeX",
    ],
    python_requires=">=3.6",
)