package main

import (
	"fmt"
	"strings"
	"time"
)

func main() {
	fmt.Println(strings.Title("hello, brave new world"))
	fmt.Println("Jetzt ist es: ", time.Now())
	fmt.Println("und etwas später: ", time.Now())
}
