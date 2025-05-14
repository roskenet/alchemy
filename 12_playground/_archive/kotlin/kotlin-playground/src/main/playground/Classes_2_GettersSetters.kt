fun main() {
    // Named params:
    val performer = Performer(perf = "I am Celine Dion on steroids.")

    performer.name = "Celine Dion"
    print("The Name is: ${performer.name}")
}
class Performer(val perf: String){
   var name: String = "Elton John"
       get() = field
       set(value) {
           field = value.uppercase()
       }
}