package eachcons

import "fmt"

// https://www.codewars.com/kata/545af3d185166a3dec001190/train/go
// https://www.codewars.com/kata/545af3d185166a3dec001190/solutions/go

func RunEachConsTest() {
	fmt.Println("EachCons")
	arr := []int{3, 5, 8, 13, 16}

	res := EachCons(arr, 4)

	fmt.Println(res)
}

func EachCons(arr []int, n int) [][]int {

	//for k, v := range arr {
	//	a1 := make([]int, n)
	//}

	result := [][]int{}

	for i := 0; i <= len(arr)-n; i++ {
		result = append(result, arr[i:i+n])
	}

	return result
}
