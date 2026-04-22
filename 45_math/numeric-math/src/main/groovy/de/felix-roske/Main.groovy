package de.felixroske

static void main(String[] args) {
    println "Hello world!"

    def strings = ['this','is','a','list','of','strings']
//    Collections.sort(strings, {s1,s2 -> s2.size() - s1.size()} as Comparator)
//    assert strings*.size() == [7, 4, 4, 2, 2, 1]

    strings.sort { -it?.size() }
    println(strings)

    print "Hello World"


}