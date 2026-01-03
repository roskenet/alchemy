# a_assoc


## Usage

FIXME

Wie bei jeder Clojure-Funktion ist es sinnvoll, zuerst einen Blick in die Dokumentation [1] zu werfen. Die Signatur (
assoc map key val) bzw. (assoc map key val & kvs) besagt, dass die Funktion assoc mit den Parametern map, key und val
aufgerufen wird. Optional können weitere key- und value-Paare am Ende der Parameterliste hinzugefügt werden. Des
Weiteren ergibt sich aus der Dokumentation, dass die Funktion auf eine Map oder einen Vektor angewandt werden kann. Wenn
sie auf eine Map angewandt wird, gibt sie eine neue Map desselben Typs zurück, die zusätzlich die Zuordnung vom Value
val zum Schlüssel key enthält. Bei Vektoren verhält es sich ähnlich, nur dass der key den Index des Vektors bestimmt, an
dem der neue Wert eingesetzt wird. Dabei muss der Index kleiner/gleich der Länge des Vektors sein. Damit lässt sich ein
Element direkt am Ende des Vektors hinzufügen, aber nicht darüber hinaus. Dass jeweils eine neue Datenstruktur
zurückgegeben wird, liegt in der Natur von Clojure: Datenstrukturen sind in der Regel unveränderlich. Den Umgang von
Clojure mit unveränderlichen Datenstrukturen und die Gründe, die für unveränderliche Datenstrukturen sprechen, werden
wir im Teil „P wie Persistenz“ dieser Reihe genauer beleuchten. Wie sich die Benutzung der Funktion gestaltet, lässt
sich in Listing 1 sehen. Zeilen, die mit => beginnen, gehören hierbei nicht zum eigentlichen Programmcode, sondern
sollen das Ergebnis der vorangegangenen Evaluation im Code visualisieren.

Listing 1

(let [example-map {:a 1}]

; neuer Schlüssel :b mit dem Wert 2 hinzugefügt
(assoc example-map :b 2)
=> {:a 1, :b 2}

; Bestehende Assoziationen werden überschrieben
(assoc example-map :a 2 :b 3 :c 4))
=> {:a 2, :b 3, :c 4}

; Dem Vektor wird das neue Element '4' an Index 3 hinzugefügt
(assoc [1 2 3] 3 4)
=> [1 2 3 4]
In den gezeigten Beispielen wird assoc benutzt, um eindimensionale Maps oder Vektoren um neue Assoziationen zu
ergänzen (genau genommen lässt sich assoc auf alle Datenstrukturen anwenden, die das Interface clojure.lang.Associative
implementieren). Die Funktion auf verschachtelte Vektoren oder Maps anzuwenden, gestaltet sich schwierig.
Glücklicherweise existiert eine Hilfsfunktion assoc-in, die Entwicklern exakt diese Funktion bereitstellt. Der Blick in
die Dokumentation [2] zeigt uns die Signatur: (assoc-in m [k & ks] v). Der erste Parameter ist wieder eine assoziative
Datenstruktur, gefolgt von einem Vektor mit beliebig vielen, aber mindestens einem Schlüsselwert. Der letzte Parameter
enthält den zu assoziierenden Wert. In Listing 2 sind einige Codebeispiele zu dieser Funktion enthalten.

Extreme Java Camp
Extreme Java Camp im Dezember
Dr. Heinz Kabutz
Eine Woche Java Power! Lerne über 30 Design Patterns & Refactoring.
mit Dr. Heinz Kabutz, Java Champion, Autor, Trainer

Listing 2

(let [person {:name {:first "Homer"
:second "Simpson"}
:age 40}]
; Ein neuer Wert wird in der zweiten Ebene ergänzt
(assoc-in person [:name :middle] "Jay")
=> {:name {:first "Homer"
:second "Simpson"
:middle "Jay"}
:age 40}

; Existiert eine verschachtelte Assoziation noch nicht, wird eine neue Map hinzugefügt
(assoc-in person [:address :street] "Evergreen Terrace"))
=> {:name {:first "Homer"
:middle "Jay"}
:age 40
:address {:street "Evergreen Terrace"}}

; Ein Wert wird in der zweiten Ebene des Vektors neu zugewiesen
(assoc-in [[1 2] [2 3]] [1 0] 0)
=> [[1 2][0 3]]

; Mischformen aus Maps und Vektoren sind möglich
(assoc-in [{:name "Holger"} {:name "Fritz"}] [0 :age] 40)
=> [{:name "Holger" :age 40} {:name "Fritz"}]
Die Werte einer assoziativen Datenstruktur lassen sich natürlich auch extrahieren. Hierfür ist die Funktion get [3]
vorgesehen. Die Nutzung lässt sich an ihrer Signatur ableiten: Mit (get map key) lässt sich der zum Schlüssel key
zugeordnete Wert aus einer assoziativen Datenstruktur map ermitteln. Als optionaler vierter Parameter not-found wird ein
Wert übergeben, welcher zurückgegeben wird, wenn das eigentliche Ergebnis des Funktionsaufrufs nil wäre. Ähnlich wie
assoc lässt sich get nur komfortabel auf flachen Datenstrukturen anwenden. Um im Falle verschachtelter Datenstrukturen
einen mehrfachen Aufruf von get zu verhindern, bietet es sich an, die Funktion get-in [4] mit der Signatur (get-in m ks)
bzw. (get-in m ks not-found) zu verwenden. Die Verwendung von get und get-in wird in Listing 3 verdeutlicht.

Listing 3

(let [person {:name {:first "Homer"
:second "Simpson"}
:age 40}]

(get person :name)
=> {:first "Homer", :second "Simpson"}

; Der dritte Parameter definiert einen Defaultwert
(get person :height 180)
=> 180

; Verschachtelte Aufrufe für verschachtelte Datenstrukturen
(get (get person :name) :second)
=> "Simpson"

; get-in vereinfacht den Zugriff auf verschachtelte Datenstrukturen
(get-in person [:name :second])
=> "Simpson"

(get [:a :b :c] 2)
=> :c

(get-in [[:a :b] [:c :d]] [1 0]))
=> :c
Um existierende Assoziationen in einer Datenstruktur zu aktualisieren, könnte man assoc bzw. assoc-in und get bzw.
get-in kombinieren, da die Funktion assoc ja bereits bestehende Assoziationen überschreibt. Auch hier bietet Clojure
einen schöneren und vor allem sprechenderen Weg an. Mit update bzw. update-in ist es möglich, eine Funktion auf einen
Teil einer Datenstruktur anzuwenden. Dabei sind sämtliche Arten von Funktionen erlaubt, unabhängig von ihrer Signatur.
Einige Beispiele dazu sind in Listing 4 aufgeführt. Interessant ist in diesem Beispiel, dass das Symbol + auf eine
Funktion referenziert und nicht, etwa wie in Java, auf einen Operator. Mehr dazu wird es im Laufe der Serie beim Thema
„O wie Operator“ geben.

Listing 4

(let [person {:name {:first "Homer"
:second "Simpson"}
:age 40}]

; inc erhöht einen numerischen Wert um 1
(update person :age inc)
=> {:name {:first "Homer", :second "Simpson"}, :age 41}

; Wendet die Funktion + mit dem zusätzlichen Parameter auf dem mit :age assoziierten Wert an
(update person :age + 10)
=> {:name {:first "Homer", :second "Simpson"}, :age 50}

; String-Konkatenation auf dem verschachtelten Vornamen
(update-in person [:name :first] str "Jay"))
=> {:name {:first "Homer Jay", :second "Simpson"}, :age 40}
Möchte man in einer Datenstruktur eine existierende Assoziation entfernen – quasi dissoziieren – bietet sich die
Funktion dissoc [5] an. Die Signatur erinnert an die der Funktion assoc, mit dem Unterschied, dass natürlich kein Wert
angegeben werden kann, nur der zu dissoziierende Schlüssel. Ein weiterer Unterschied zu assoc ist, dass dissoc nur auf
Maps angewandt werden kann, nicht auf Vektoren. Wenn man genau darüber nachdenkt, ist das auch logisch: Eine Assoziation
aus einem Vektor zu entfernen, würde weitere Effekte auslösen, beispielsweise das Verschieben aller folgenden Elemente
um eine Position nach vorne, um die entstandene Lücke zu schließen. Ein Gegenstück zu assoc-in, also etwa dissoc-in,
existiert nicht, lässt sich jedoch mit der bereits erwähnten Funktion update-in [6] umsetzen. Ein Anwendungsbeispiel
findet sich in Listing 5.

Listing 5

(let [person {:name {:first "Homer"
:second "Simpson"}
:age 40}]
; Entfernt die Assoziation des Schlüssels :age aus der Map
(dissoc person :age)
=> {:name {:first "Homer", :second "Simpson"}

; Wendet (dissoc map :second) auf die verschachtelte Map an, welche mit :name assoziiert ist
(update-in person [:name] dissoc :second))
=> {:name {:first "Homer"}
:age 40}
In diesem Teil der Serie haben wir grundlegende Funktionen zum Hinzufügen, Lesen, Aktualisieren und Entfernen von Werten
in und aus assoziativen Datenstrukturen vorgestellt. Dabei lässt sich vor allem an den Funktionen update und update-in
erahnen, dass Clojures funktionaler Ansatz sehr mächtig ist. Wir hoffen, dass wir mit dem ersten Artikel die Lust auf
mehr geweckt haben und freuen uns darauf, euch auch im weiteren Verlauf der Serie einige Ansätze der Sprache
näherbringen zu können.