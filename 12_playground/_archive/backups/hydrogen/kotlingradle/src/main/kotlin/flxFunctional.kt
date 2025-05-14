fun doSomething() {
   val elements = listOf("gold", "aluminium", "oxygen", "hydrogen", "actinium")

   val sortedBy = elements
      .sortedBy{ it.length }
      .map { it.toUpperCase() }
      .forEach{println(it)}
}