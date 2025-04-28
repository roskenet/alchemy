# LaTeX Font Installer

A command-line tool for converting OTF fonts to TeX-compatible formats and generating LaTeX packages for easy font usage.

## Features

- Scans directories for OTF font files
- Extracts font metadata (family name, style, weight)
- Generates TFM files for TeX font metrics
- Creates MAP files for font mapping
- Generates LaTeX style files for easy font inclusion via `\usepackage`
- Creates a TeX Live compatible directory structure

## Installation

### From PyPI

```bash
pip install latex-fontinst
```

### From Source

```bash
git clone https://github.com/yourusername/latex-fontinst.git
cd latex-fontinst
pip install -e .
```

## Dependencies

- Python 3.6+
- fonttools (automatically installed with pip)

## Usage

### Basic Usage

```bash
latex-fontinst -i /path/to/fonts -o /path/to/output
```

### Command-line Options

```
-i, --input-dir    Directory containing OTF font files (required)
-o, --output-dir   Directory where generated files will be saved (required)
-v, --verbose      Enable verbose output
```

### Example

```bash
# Convert all OTF fonts in the current directory
latex-fontinst -i . -o ~/texmf -v
```

## Output Directory Structure

The tool creates a TeX Live compatible directory structure in the output directory:

```
output_dir/
└── texmf/
    ├── fonts/
    │   ├── tfm/
    │   │   └── FontName/
    │   │       └── fontname.tfm
    │   ├── map/
    │   │   └── dvips/
    │   │       └── FontName/
    │   │           └── fontname.map
    │   ├── type1/
    │   │   └── FontName/
    │   │       └── fontname.otf
    │   └── enc/
    │       └── FontName/
    └── tex/
        └── latex/
            └── FontName/
                └── fontname.sty
```

## Using the Fonts in LaTeX

After running the tool, you can use the generated fonts in your LaTeX documents:

1. Make sure the output directory is in your TeX search path
   - For a personal installation, use `~/texmf`
   - Run `mktexlsr` to update the TeX database

2. Include the font package in your LaTeX document:

```latex
\usepackage{fontname}
```

3. Use the font in your document:

```latex
{\fontname This text uses the new font.}
```

Or with the text command:

```latex
\textfontname{This text uses the new font.}
```

## Limitations

- The current implementation creates placeholder TFM files. For full functionality, external tools like `otftotfm` would be needed.
- Font subsetting is not implemented.
- Only basic font properties (regular, bold, italic) are supported.

## License

MIT License