package de.felixroske

class MyData {
    var someData:Int = 0
}

fun main(args: Array<String>) {

    val myData: MyData = MyData()

    println(myData.someData)
/*
    async(CommonPool) {
        for(i in 11..20) {
            myData.someData+=i
            println("someData from 1st async ${myData.someData}")
            delay(500)
        }
    }

    async(CommonPool) {
        for(i in 1..10) {
            myData.someData++
            println("someData from 2nd async ${myData.someData}")
            delay(300)
        }
    }

    runBlocking { delay(10000) }
*/
}
