package arrays_and_lists

class Juggler(var numOfItems: Int=1) : Performer {

//    var numOfItems: Int = 1

    override fun doSomething(item: String) {
        println("I am juggling with $numOfItems $item")
    }
}