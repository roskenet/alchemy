# Die zehn Impediments des Cold-Turkey-Ansatzes

Angelehnt an [4] gibt es zehn typische Schwierigkeiten beim kompletten Rewrite einer Software:

Ein besseres System muss versprochen werden: Ein Rewrite exakt derselben Funktionalität liefert keinen Mehrwert für das Business. Deswegen wird dieser Ansatz häufig mit neuen Features kombiniert, die zu einer weiteren Erhöhung der Komplexität führen.

Geschäftsanforderungen bleiben niemals stabil: Während der Rewrite-Phase bleibt die Welt nicht stehen und es prasseln weiter neue Anforderungen auf das Projekt ein, bei denen ständig entschieden werden muss, ob das Warten auf den Rewrite möglich ist. Ansonsten muss die Anforderung im Legacy-System doppelt umgesetzt werden.

Spezifikationen sind selten vorhanden: Software ohne eine Spezifikation neu zu schreiben führt zu vielen Missverständnissen, Fehlern und hohen Testaufwänden. Der Legacy-Code ist meistens als Dokumentation nicht ausreichend, da er schwer verständlich ist.

Undokumentierte Abhängigkeiten existieren häufig: Mitten im Projekt fällt bei ersten Tests oft auf, dass eine Schnittstelle vergessen wurde und entweder Daten vorhanden sind oder nicht an ein Drittsystem geliefert wurden, da nicht alle Abhängigkeiten dokumentiert waren.

Legacy-Systeme könnten zu groß für eine Datenmigration sein: Der Datenumfang von Legacy-Systemen mit langjährigen Aufbewahrungspflichten könnte für den Zeitraum der Datenmigration – meistens ein Wochenende – zu groß sein, sodass es technisch nicht machbar ist, alle Daten während der geplanten Downtime in das Zielsystem zu migrieren.

Das Management großer Projekte ist schwierig: Spätestens seit der CHAOS-Studie der Standish Group ist bekannt, dass nur ca. ein Drittel aller Projekte erfolgreich abgeschlossen werden [5].

Verspätungen werden selten toleriert: Komplexe Projekte tendieren dazu, sich zu verspäten. Beim Cold-Turkey-Ansatz steht das Datum für die Big-Bang-Migration lange vorher fest und eine Verschiebung ist aufwendig und teuer oder gar unmöglich.

Große Projekte werden aufgebläht: Das Rewrite-Projekt wird – wie andere große Projekte auch – dazu genutzt, alle mögliche Anforderungen und Wünsche zu berücksichtigen, die in den Hinterköpfen der Stakeholder geschlummert haben.

Das Gleichgewicht wird beibehalten, der Change vermieden: Angst vor Veränderung und neuen Technologien reduziert die Kooperationsbereitschaft mit dem Projekt oder führt sogar zu Widerstand dagegen.

Die Analyse des umfangreichen Legacy-Systems führt zur Lähmung: Der Rewrite soll vollständig die Funktionalität des Legacy-Systems abdecken. Deshalb ist eine umfangreiche Analyse der Legacy notwendig, ohne deren Ergebnisse nicht mit der Umsetzung des Rewrite gestartet werden kann.
