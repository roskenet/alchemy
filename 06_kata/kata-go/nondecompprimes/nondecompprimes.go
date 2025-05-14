package nondecompprimes

import "fmt"

// https://www.codewars.com/kata/561c34b31dbb1b11640000de/train/go

func IthNondecompPrime(i int) int {
	return 0
}

func Dotest() {
	//		dotest(3, 11)
	//		dotest(10, 67)
	//		dotest(20, 163)
	//		dotest(25, 211)
	//		dotest(30, 263)

	nondecompPrime := IthNondecompPrime(3)

	if nondecompPrime != 11 {
		fmt.Println("WRONG!")
	} else {
		fmt.Println("OK!")
	}
}

//var _ = Describe("Tests", func() {
//	It("Sample tests", func() {
//		dotest(3, 11)
//		dotest(10, 67)
//		dotest(20, 163)
//		dotest(25, 211)
//		dotest(30, 263)
//	})
//})
