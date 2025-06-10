# Search your git logs with fzf

How can I use fzf efficiently together in a git log command? For example: H
ow can I search for a ticket number in my git logs to see if something was comm
itted for this ticket?
You can combine `git log` with `fzf` for powerful interactive searching. For ticket numbers, try:

```bash
git log --oneline | fzf -i --multi --preview 'git show --color=always {1}'
```

This gives you a fuzzy search interface where you can type your ticket number (like "TICKET-123") to filter commits.

For a more specific ticket search:

```bash
git log --grep="TICKET-[0-9]+" --oneline | fzf --preview 'git show --color=always {1}'
```

Or create an alias in your `.gitconfig`:

```
[alias]
    find-ticket = "!f() { git log --oneline | fzf -i --query=\"$1\" --preview 'git show --color=always {1}'; }; f"
```

Then use: `git find-ticket TICKET-123`

