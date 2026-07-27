# Efficient Home Directory Backup on Fedora

For backing up your `/home` directory, `rsync` is highly recommended for its ability to perform incremental backups, ensuring that only changed files are copied, which is both fast and efficient.

## Using `rsync` (Recommended)

This command mirrors your `/home` directory to an external drive while excluding unnecessary cache and temporary folders.

```bash
rsync -avh --progress \
  --exclude='.cache' \
  --exclude='.local/share/containers' \
  --exclude='.docker' \
  --exclude='.local/share/Trash' \
  --exclude='node_modules' \
  /home/felix/ /run/media/your-external-drive/home-backup/
```

*   `-a`: Archive mode (preserves permissions, timestamps, symbolic links, etc.).
*   `-v`: Verbose output.
*   `-h`: Human-readable output.
*   `--progress`: Shows transfer progress.

## Using `tar` (Alternative for Archives)

If you prefer a single compressed file, use `tar` with `gzip`.

```bash
tar -cvpzf /run/media/your-external-drive/home-backup.tar.gz \
  --exclude='./.cache' \
  --exclude='./.local/share/containers' \
  --exclude='./.docker' \
  --exclude='./.local/share/Trash' \
  --exclude='./node_modules' \
  -C /home/felix .
```

## Key Recommendations

*   **Exclude Wisely**: Always exclude `.cache`, `.docker`, and `.local/share/containers` as these are either temporary or easily reconstructed/re-downloaded.
*   **Permissions**: Running these commands as your standard user is usually sufficient for files you own.
*   **Verification**: Always verify your backup by inspecting the files on the destination drive before wiping your current system.
