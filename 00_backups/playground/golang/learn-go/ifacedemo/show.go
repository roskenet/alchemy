package ifacedemo

type TheThing interface {
	Show()
}

type Thing struct {
	a int
}

func (t *Thing) Show() {
	println(t.a)
}

func TestMe() {
	t := Thing{1}
	DoSomething(&t)
}

func DoSomething(t TheThing) {
	t.Show()
}
