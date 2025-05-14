package main

import "fmt"

func main() {
	s := "Mississippi"

	count := make(map[rune]int)
	for _, c := range s {
		count[c]++
	}

	for i, c := range count {
		fmt.Printf("%c: %d\n", i, c)
	}
}
