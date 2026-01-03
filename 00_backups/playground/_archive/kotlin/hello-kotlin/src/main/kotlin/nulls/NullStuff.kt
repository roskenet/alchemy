package nulls

fun main(args: Array<String>) {

    var s: String? = "Hello World!"

    if(args.size < 1) {
        s = null
    }

    println("${s?.uppercase() ?: "Unknown"}")
}

fun notGuaranteedToBeNonNull(arg: String?) {
    if(arg != null) {
        println(arg)
    }
}