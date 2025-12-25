# Effizient parallel arbeiten
Nebenläufige Entwicklung ohne viele Threads mit Kotlin-Koroutinen

Gunnar Hilling

===
In vielen Programmiersprachen ist es heute Stand der Technik, Aufgaben, die parallelisiert werden können, in mehreren Threads abzuarbeiten. Doch bringen Threads oft eine Komplexität mit sich, die nicht immer einfach zu beherrschen ist. Eine Alternative stellen Koroutinen dar, wie sie beispielsweise in der Programmiersprache Kotlin zur Verfügung stehen. 
===


Die nebenläufige Programmierung mittels Threads hat zwei wesentliche Nachteile. Zum einen ist sie fehlerträchtig, da es trotz moderner Synchronisationsmechanismen genügend Möglichkeiten gibt, in ein solches Stück Software Fehler einzubauen, die nur sporadisch auftreten und schwer zu entdecken sind. Andererseits ist diese Technik auch nicht wirklich effizient. Üblich sind oft Threadpools mit einer Größe von mehreren hundert Threads in einem Prozess, von denen ein Großteil stets brach liegt, da sie beispielsweise auf I/O warten. Koroutinen können hier helfen.

Doch was sind eigentlich Koroutinen? Der Begriff stammt ursprünglich aus den 50er-Jahren und wurde von Melvin Conway geprägt. Heute wird darunter ein Konzept für die unterbrechbare Ausführung von Prozeduren in einer Programmiersprache oder Plattform verstanden, das folgende Eigenschaften mitbringt:

*    Die Ausführung des Programms kann an bestimmten Punkten unterbrochen und später wieder aufgenommen werden.

*    Hierzu wird der Ausführungskontext gespeichert und später wiederhergestellt.

*    Ein wesentlicher Unterschied zu Multi-Threading ist, dass bei Koroutinen der Kontext kooperativ und nicht präemptiv gewechselt wird. Hierdurch entfällt ein Großteil der problematischen Synchronisationsarbeit zwischen den Tasks und das Ganze ist grundsätzlich auch effizienter.

Die Implementierung der Koroutinen in Kotlin bringt darüber hinaus weitere Features mit, die den Mehrwert noch erhöhen:

*    Koroutinen sind in Kotlin ein Sprachmittel, und der Compiler wacht darüber, dass sie korrekt verwendet werden.

*    Koroutinen besitzen Scopes, die geschachtelt werden können. Hierdurch kann sichergestellt werden, dass alle in einem Scope erzeugten Koroutinen auch tatsächlich bei Beendigung zu Ende laufen.

*    In Kotlin unterstützen Koroutinen auch die asynchrone Prozessausführung in mehreren Threads. Die Größe der Threadpools kann hierbei dann an die Hardware angepasst werden, statt zum Beispiel an die Anzahl der zu bedienenden Clients.

Das Besondere an Kotlin ist, dass die Unterstützung für Koroutinen elegant in die Sprache eingebaut wurde. Es handelt sich also um eine Erweiterung der Sprache, die so beispielsweise in Java nicht einfach umsetzbar wäre. Ich möchte dazu mit einem möglichst einfachen Beispiel beginnen (Listing 1).

```kotlin
fun main() {
  GlobalScope.launch ( block = {
    delay(500)
    log("World!")
  });
  log("Hello,")
  Thread.sleep(1000L)
}
```

GlobalScope.launch erzeugt ein neues Objekt vom Typ CoroutineScope. Hierzu wird als Lambdaparameter ein Codeblock block übergeben. In diesem Artikel soll es primär um Koroutinen gehen, sodass möglichst wenige Kotlin-Spezialitäten verwendet werden, damit die Beispiele auch für Einsteiger nachzuvollziehen sind. Alle Beispiele sind auf GitHub unter [1] verfügbar. Für die Kotlin-Basics sind die Tutorials unter [2] empfehlenswert. Im Beispiel aus Listing 1 würde man normalerweise von der Möglichkeit Gebrauch machen, den letzten Parameter direkt in die geschweiften Klammern zu schreiben, wenn es sich um einen Lambdaausdruck handelt. Die entsprechende Anpassung ist im Beispiel Hello-World-Blocking.kt enthalten.

Für ein einfaches Debugging und eine bessere Nachvollziehbarkeit der Interna gibt die Funktion log aus Common.kt den aktiven Thread und die Zeit in Millisekunden seit dem ersten Logaufruf mit aus. Setzt man zusätzlich den Switch -Dkotlinx.Coroutines.debug, enthält der Threadname auch jeweils den verwendeten Koroutinenkontext.


