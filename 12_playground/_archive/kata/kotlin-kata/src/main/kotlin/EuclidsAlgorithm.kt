fun main() {
  // größter gemeinsamer Teiler

    var a = 98
    var b = 46

    while (a % b != 0) {
        var newa = a % b
        var newb = a / b

        a = newa
        b = newb
    }

    println("Groesster gemeinsamer Teiler: ${b}");
}

