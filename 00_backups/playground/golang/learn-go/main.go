package main

import (
	"fmt"
	"learn-go/ifacedemo"
)

func main() {
	s := "gopher"
	fmt.Println("Hello and welcome, %s!", s)

	ifacedemo.Show()

	playWithSlices()
}

func playWithSlices() {
	s := []int{}

	fmt.Println(s)
	s = append(s, 6)
}

func IfElseConstructions() {
	i := 5

	if i >= 3 {
		fmt.Println("true")
	} else {
		fmt.Println("false")
	}
}
