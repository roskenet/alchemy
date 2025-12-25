# Bash Cookbook

## Special characters

```$*``` and ```$@``` expand to the value of all positional parameters
```$0``` the path to the running script OR the shell itself
```$?``` exit code of last executed command
```$_``` last argument

## Input a file line by line

```bash
INPUT="./my_list.txt"
while IFS= read -r line
do
  echo "$line"
done < "$INPUT"
```

```bash
while IFS= read -r line
do  
   : do something with "$line"
done < FILENAME?
```

## Input a file line by line 2

```bash
for i in "$(cat ./my_list.txt)"
do
   echo "$i"
done
```

## Read and strip file name components

```bash
filename=$(basename -- "$fullfile")
extension="${filename##*.}"
filename="${filename%.*}"
```

## Loops

Get out of a loop with ```break```.
