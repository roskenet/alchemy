package flx

import "fmt"

// DemonstrateForLoop shows various for loop patterns in Go
func DemonstrateForLoop() {
	// Traditional for loop with init, condition, and post
	fmt.Println("Traditional for loop:")
	for i := 0; i < 5; i++ {
		fmt.Printf("  Iteration %d\n", i)
	}

	// For loop as a while loop (only condition)
	fmt.Println("\nFor loop as while:")
	j := 0
	for j < 3 {
		fmt.Printf("  j = %d\n", j)
		j++
	}

	// Infinite loop with break
	fmt.Println("\nInfinite loop with break:")
	k := 0
	for {
		if k >= 3 {
			break
		}
		fmt.Printf("  k = %d\n", k)
		k++
	}

	// For range over slice
	fmt.Println("\nFor range over slice:")
	numbers := []int{10, 20, 30}
	for index, value := range numbers {
		fmt.Printf("  Index: %d, Value: %d\n", index, value)
	}
}
