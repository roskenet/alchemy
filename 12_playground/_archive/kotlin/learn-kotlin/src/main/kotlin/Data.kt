import java.util.function.Supplier

data class Singer(val name: String,
                  val song: String)

fun main() {

    val singer = Singer("Elvis", "Little less conversation")
    val (name, song) = singer
//    val theFuctionMachine = theFuctionMachine(song) { it.uppercase(Locale.getDefault()) }

    val thePerformer = anotherTest(singer::name)
    val theSong = anotherTest(singer::song)

    println("${thePerformer} sings ${theSong}.")
}

typealias PropertyReader = Supplier<String>

fun anotherTest(f: PropertyReader): String {
    val result = f.get()
    return result.uppercase()
}

fun theFuctionMachine(arg: String, f: (arg: String) -> String): String {
   return f(arg)
}