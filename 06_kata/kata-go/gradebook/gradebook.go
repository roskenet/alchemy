package gradebook

// https://www.codewars.com/kata/55cbd4ba903825f7970000f5/train/go

func GetGrade(a, b, c int) rune {
	avg := (a + b + c) / 3

	if avg >= 90 {
		return 'A'
	}
	if avg >= 80 {
		return 'B'
	}
	if avg >= 70 {
		return 'C'
	}
	if avg >= 60 {
		return 'D'
	}
	return 'F'
}

func TestGetGrade() {

	grade := GetGrade(95, 90, 93)

	if grade != 'A' {
		println("Wrong")
	}
}
