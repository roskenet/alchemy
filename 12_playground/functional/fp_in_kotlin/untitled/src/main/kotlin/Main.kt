package de.felixroske

class CreditCard {
    fun charge(price: Int) {
        println("Charge $price")
    }
}

class Cafe {
    fun buyCoffee(cc: CreditCard): Coffee {
        val cup = Coffee()
        cc.charge(cup.price)
        return cup
    }
}

fun main() {

}