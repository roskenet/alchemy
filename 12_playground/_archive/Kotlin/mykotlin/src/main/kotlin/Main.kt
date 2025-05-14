// Expressions are much better than statements

private const val votingAgeGermany = 18 // only visible in Main.kt

//fun mayVote(age: Int = 18, name: String) : String {
//    if (age >= votingAgeGermany) {
//        return "Yes, ${name} can vote."
//    }
//    else {
//        return "No, ${name} can't vote."
//    }
//}

fun mayVote(age: Int = votingAgeGermany, name: String) =
    if (age >= votingAgeGermany)
        "Yes $name may vote!"
    else
        "No, $name can't vote"

fun main(args: Array<String>) =
    println("Hello World! ${mayVote(name = "John")}")