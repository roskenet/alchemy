To encrypt a password with GPG from the command line:

```bash
echo "your-secure-password" | gpg --encrypt --armor --recipient recipient@example.com
```

For a one-liner that doesn't leave the password in shell history:

```bash
gpg --encrypt --armor --recipient recipient@example.com <<< "your-secure-password"
```

