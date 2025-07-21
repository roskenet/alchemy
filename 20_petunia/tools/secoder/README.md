# Secoder

A command-line tool for handling secrets with PGP encryption.

## Installation

You can install the package directly from the source:

```bash
pip install .
```

## Usage

After installation, you can use the `secoder` command:

```bash
secoder [options]
```

### Available Options

- `--secret-dir`: Directory containing secrets
- `--pgp-key`: PGP key to use for encryption/decryption
- `--key-password`: Password for the PGP key

### Example

```bash
secoder --secret-dir /path/to/secrets --pgp-key /path/to/key.asc --key-password mypassword
```

This will output:

```
Hello World and the three options:
  --secret-dir: /path/to/secrets
  --pgp-key: /path/to/key.asc
  --key-password: mypassword
```

## Development

To run the tool directly from the source code:

```bash
cd secoder
python -m secoder.cli
```

Or make the script executable and run it directly:

```bash
chmod +x secoder/cli.py
./secoder/cli.py
```