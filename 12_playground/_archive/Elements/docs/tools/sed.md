# Sed, awk, grep

## Extract between two tags

```bash
sed -n '/<body/,/<\/body>/p' titlepage01.html
```

## Remove lines between two tags

```bash
sed "/PI/,/Value:/d" your_file
```

## Remove empty lines and spaces

```bash
sed 's/^ *//; s/ *$//; /^$/d' file.txt
```
