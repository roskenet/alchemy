# Tantalum

In einer Microservice-Architektur tritt ein Service sehr häufig als Server und Client gleichzeitig auf: Er nimmt Daten an seinen Schnittstellen an und muss, um seine Aufgabe zu erfüllen, sehr oft einen anderen Service rufen.
Um die Funktionalität des eigenen Service isoliert zu testen, sollen hier verschiedene Möglichkeiten aufgezeigt werden.

Der tantalum-server ist ein Microservice, der uns unter /api/cars eine List der Autos in unserem Fahrzeugpool zurückgibt.

Im tantulum-client entwickeln wir eine Klasse, die die Summe aller gefahrener Kilometer unserer Autos berechnet.

## CDI
Möglichkeit Eins: Benutze das eingesetzte CDI-Framework (hier also Spring) um ein Mock-Objekt des Clients im App-Kontext zu haben.
Im tantalum-test1 Projekt wird im ApplicationContext das ursprüngliche TantalumWebClient mit unserem Mock ersetzt. Das SpringFramework autowired nun im MileageCounter unseren 'Client' der nur die beiden hardcodierten Fahrzeuge zurückgibt.

Bei umfangreicheren Projekten empfiehlt es sich übrigens, die zusätzliche Konfigurationsklasse zu externalisieren.

## Mocks
Möglichkeit Zwei: Benutze ein MockingTool
Diese Möglichkeit ist sehr eng mit der ersten Möglichkeit verwandt und bietet sich häufig für umfangreichere Testszenarien an.
Im Beispiel tantalum-test2 benutze ich Mockito um zum Beispiel zu überprüfen, ob der Client auch tatsächlich benutzt wurde.
