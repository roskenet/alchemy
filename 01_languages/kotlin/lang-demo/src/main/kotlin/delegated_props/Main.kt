package delegated_props

import kotlin.reflect.KProperty

class PropDelegate {

    private var value: String = "Manhattan"

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        val retVal = this.value
        this.value = "Berlin"
        return retVal
    }

//    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
//        println("Setting value to: $value")
//        this.value = value
//    }

}

class MyClass {
   val myPropDelegate: PropDelegate = PropDelegate()
//   var theProp: String by PropDelegate()
    val theProp: String by myPropDelegate
}

fun main() {
    val myClass = MyClass()
    println("First we take ${myClass.theProp}")
    println("Then we take ${myClass.theProp}")
}