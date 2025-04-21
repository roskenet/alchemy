# 🧠 Felix' Coaching Cards – Software Engineering 

Eine Sammlung pointierter Gedanken zu typischen Software-Prinzipien – locker formuliert, aber mit ernstem Kern.

---

## 🪦 Toter Code ist kein guter Freund

Wenn Code nicht mehr benutzt wird, dann: weg damit.  
„Vielleicht brauchen wir das ja noch mal“ ist der erste Schritt ins Chaos.  
Toter Code stört beim Lesen, wird nicht getestet, und niemand traut sich, ihn anzufassen.  
Wenn du was brauchst, ist Git sowieso dein Backup-Zombie-Friedhof.

---

## 🔮 Magische Zahlen sind unmagisch

Wenn irgendwo eine `42` steht und keiner weiß warum – hast du ein Problem.  
Magische Zahlen machen deinen Code kryptisch wie ein Horoskop in Altgriechisch.  
Gib ihnen sprechende Namen, pack sie in Konstanten und tu so, als wärst du dein zukünftiges Ich.  
Spoiler: Es wird dir danken.

---

## ❌ YAGNI – You Ain’t Gonna Need It

Du willst schon jetzt Features bauen, die *vielleicht irgendwann* gebraucht werden?  
Lass es. Wirklich.  
90 % davon landen eh nie im Produkt und machen alles nur komplizierter.  
Mach das, was **jetzt** gebraucht wird – und bau später den Rest, wenn’s soweit ist.

---

## 🗣️ Kommentare ersetzen keine guten Namen

Wenn dein Code `// erhöht das Alter um 1` braucht, um `alter = alter + 1` zu erklären, läuft was schief.  
Kommentare gammeln, Namen bleiben – also gib Variablen, Funktionen & Klassen ehrliche Namen.  
Ein guter Name erspart dir fünf Zeilen Kommentar und drei graue Haare.  
Und wenn du doch kommentierst: Sag *warum*, nicht *was*.

---

## 🚨 Exceptions sind keine Abkürzung

Ein `try-catch` ist kein Ersatz für saubere Logik.  
Wenn dein Kontrollfluss wie ein Labyrinth aus Exceptions aussieht, bist du auf dem Holzweg.  
Exceptions sind für Ausnahmezustände, nicht für "Plan B".  
Und fang bloß keine `NullPointerException` ohne Grund – das ist wie "Einbruch im Haus? Einfach Vorhängeschloss drüber."

---

## 🤏 Kleine Funktionen rocken

Wenn deine Funktion so lang ist wie ein Sonntagskrimi, stimmt was nicht.  
Teile auf, gib deinen Blöcken Namen, und mach aus Monster-Methoden lauter kleine Helferlein.  
Dann kannst du sie testen, wiederverwenden – und endlich verstehen, was da passiert.  
Und hey: Weniger Scrollen = mehr Leben.

---

## 🧪 Tests sind kein nerviges Add-on

"Ich mach das später mit den Tests" ist wie "Ich ruf dich morgen an" – kommt selten.  
Tests helfen dir zu schlafen, wenn dein Code deployed ist.  
Sie zeigen, dass du’s ernst meinst – mit Qualität, mit Wartbarkeit, mit deinem Team.  
Und hey: Ein roter Test ist oft dein bester Kumpel beim Refactoring.

---

## 🧹 Sauberer Code ist kein Luxus

„Hauptsache, es funktioniert!“ ist der Anfang vom Ende.  
Spätestens beim nächsten Bug fluchst du über deinen alten Code – oder den deiner Kollegen.  
Sauberer Code spart Zeit. Immer. Auch wenn du’s erst später merkst.  
Mach’s ordentlich – für dich, für andere, für die Zukunft.

---

