package main

import (
	"fmt"

	"myapp.roskenet.de/subdir"
)

func main() {

	myslice := []int16{1, 2, 3, 4}

	myslice = append(myslice, 42)

	for i, num := range myslice {
		fmt.Printf("%d ist %d\n", i, num)
	}

	elvis := new(subdir.Singer)
	elvis.Name = "Elvis Presley"
	elvis.Song = "Jailhouse Rock"

	madonna := subdir.Singer {
		Name: "Madonna",
		Song: "Like a Virgin",
	}

	fmt.Printf("%s sings %s \n", elvis.Name, elvis.Song)
	fmt.Printf("Madonna: %s", madonna)
}
