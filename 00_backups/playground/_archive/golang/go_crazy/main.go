package main

import (
	"encoding/json"
	"fmt"
)

type Hello struct {
	Message string `json:"helloooooo"`
}

func main() {
	h := Hello{Message: "world"}

	b, _ := json.Marshal(h)

	fmt.Printf("%s\n", string(b))
}

func playWithDatatypes() {

}
