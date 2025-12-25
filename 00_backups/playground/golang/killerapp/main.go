package main

import "killerapp/superservice"

type MyInterface interface {
	DoPrint()
	DoSomethingElse()
}

type MyOwnInt int

func (m MyOwnInt) DoPrint() {
	println(m)
}

func (m MyOwnInt) DoSomethingElse() {
	println(m)
}

func experiment(i MyInterface) {
	i.DoPrint()
}

func playWithTypes() error {
	var i any
	println(i)

	//var myChar = i.(byte)

	return nil
}

func main() {
	superservice.Doprint()

	var myOwnInt MyOwnInt = 42
	var myOwnInt2 MyOwnInt = 43

	myOwnInt.DoPrint()

	ownInt := myOwnInt + myOwnInt2

	println(ownInt)

	// MyOwnInt implements DoPrint:
	experiment(myOwnInt)

	println("Hello World")

	funWithSlices()
	funWithMaps()

	type myStruct struct {
		a string
		b int
	}

	myStructInstance := myStruct{
		a: "",
		b: 0,
	}

	println(myStructInstance.a)
}

func funWithMaps() {
	myMap := map[string][]string{}

	for k, v := range myMap {
		println(k, v)
	}
}

func funWithSlices() {
	// a slice:
	myNumbers := []int{1, 2, 3}
	myOtherNumbers := []int{42}

	myNumbers = append(myNumbers, myOtherNumbers...)
	myNumbers = append(myNumbers, len(myNumbers))

	for _, n := range myNumbers {
		println(n)
	}
}
