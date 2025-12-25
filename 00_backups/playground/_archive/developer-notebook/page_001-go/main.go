package main

func init() {
	println("I am in init")
}

func main() {
	println("Hello World!")

	m := make(map[string]string)

	m["Germany"] = "Berlin"
	m["France"] = "Paris"
	m["Great Britain"] = "London"

	for key, value := range m {
		println(key, ":", value)
	}

	println(m["France"])
}
