package functionalkotlin

interface Bakeable {
  fun bake(): String
}

abstract class BakeryGood(val flavour: String): Bakeable {
  fun eat(): String {
    return "nom, nom, nom... delicious $flavour ${name()}"
  }
  abstract fun name(): String
}

class Cupcake(flavour: String): BakeryGood(flavour) {
  override fun name(): String {
    return "Nice cupcake"
  }

  override fun bake(): String {
    return "50"
  }

  companion object {
    fun chocolate(): BakeryGood {
      return object : BakeryGood("Chocolate") {
        override fun name(): String {
          return "Chocolate"
        }

        override fun bake(): String {
          return "120"
        }

      }
    }
  }
}

fun main() {

  val chocolate = Cupcake.chocolate()

  chocolate.eat()
}
