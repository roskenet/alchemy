# Secoder

A command-line tool for handling secrets with PGP encryption. Secoder reads encrypted files from a directory, decrypts them using a PGP key, and writes the decrypted content to a YAML file.

## Installation

You can install the package directly from the source:

```bash
pip install .
```

This will install the package. Note that this tool requires the `gpg` command-line tool to be installed on your system.

## Usage

After installation, you can use the `secoder` command:

```bash
secoder [options]
```

### Available Options

- `--secret-dir`: Directory containing encrypted secret files (required)
- `--pgp-key`: PGP key file to use for decryption (required)
- `--key-password`: Password for the PGP key (required)

### How It Works

1. Secoder reads all files in the directory specified by `--secret-dir`
2. For each file, it:
   - Derives a key name from the filename (without extension)
   - Decrypts the file content using the PGP key and password
3. Appends all decrypted secrets to the end of `secret.yaml` in the current directory
   - Each line appended to the file has two spaces, followed by the key name, a colon, and the decrypted content
   - If the file doesn't exist, it will be created

### Example

```bash
secoder --secret-dir /path/to/secrets --pgp-key /path/to/key.asc --key-password mypassword
```

If the secrets directory contains files like:
- `database.gpg` (containing encrypted database credentials)
- `api-key.gpg` (containing an encrypted API key)

The resulting `secret.yaml` file would look like:

```yaml
  database: <decrypted database credentials>
  api-key: <decrypted API key>
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