package delegated_props

import kotlin.reflect.KProperty

class PropDelegate {
    private var value: String = "Berlin"

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("Setting value to: $value") // Extra side-effect if desired
        this.value = value
    }

}

class MyClass {
   val myPropDelegate: PropDelegate = PropDelegate()
//   var theProp: String by PropDelegate()
    var theProp: String by myPropDelegate
}

fun main() {
    val myClass = MyClass()
    myClass.theProp = "New York"

    println(myClass.theProp)
}