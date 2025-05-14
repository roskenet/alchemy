package main

import "fmt"

type myCoolInterface interface {
	doSomething(string)
}

type myCoolType struct {
	an_int   int
	a_string string
}

func (t myCoolType) doSomething(another_string string) {
	fmt.Print(another_string)
}

func anothermain() {
	fmt.Print("Hello World!")

	something := myCoolType{
		an_int:   42,
		a_string: "Hello World!",
	}

	something.doSomething("Blubber")
}
