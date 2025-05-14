package main

import "fmt"

type Address struct {
	Name string
	ZIP  string
	City string
}

func main() {
	fmt.Println("Hello World!")

	addresses := make([]*Address, 3)

	fmt.Println("Addresses: ", addresses)
}
