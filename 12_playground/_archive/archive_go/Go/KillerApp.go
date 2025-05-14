package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"reflect"
	"strconv"
	"strings"
)

func main() {
	fmt.Println("Hello World!")

	reader := bufio.NewReader(os.Stdin)
	fmt.Print("Enter first number: ")
	text, _ := reader.ReadString('\n')
	trimmedText := strings.TrimSpace(text)

	parseInt, _ := strconv.ParseInt(trimmedText, 10, 64)

	typeOf := reflect.TypeOf(parseInt)
	fmt.Println(typeOf)

	fmt.Println(doSomething(2, parseInt))
}

func doSomething(my1stint int64, my2ndint int64) float64 {
	return math.Pow(float64(my1stint), float64(my2ndint))
}
