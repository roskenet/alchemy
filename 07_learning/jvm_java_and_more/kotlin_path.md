# JVM Lernpfad mit Übungsprojekten

Ein strukturierter Lernpfad zur JVM-Entwicklung in drei Stufen – jeweils mit passenden Übungsprojekten. Der Fokus liegt zusätzlich auf der Sprache **Kotlin**.

---

## 🟢 Einsteiger: Java- und Kotlin-Grundlagen & OOP

### Lernziele
- Syntax und Kontrollstrukturen in Kotlin
- Objektorientierte Konzepte
- Arbeiten mit Collections und Standard-APIs
- Erste Tests und Build-Tools

### Themen
- Kotlin-Grundsyntax: `val`/`var`, Funktionen, Kontrollstrukturen
- Klassen, Objekte, Datenklassen (`data class`)
- Vererbung und Interfaces
- Fehlerbehandlung mit `try/catch`
- Kotlin Collections API
- Einfache Unit-Tests mit KotlinTest oder JUnit
- Gradle Basics

### Übungsprojekte
- **Taschenrechner-CLI in Kotlin**: einfache Eingaben, Schleifen, `when`-Ausdrücke
- **Adressbuch-CLI**: Nutzung von Listen, Datenklassen, einfache OOP
- **Todo-Liste mit Datei-Storage**: File I/O mit Kotlin, Exception Handling
- **Mini-Kalender-App**: `LocalDate`, `ChronoUnit`, Kotlin-Zeitfunktionen

---

## 🟡 Fortgeschrittene: Moderne Kotlin-Features & saubere Softwareentwicklung

### Lernziele
- Funktionale Programmierung mit Kotlin
- Null-Safety und immutables Design
- Testabdeckung und Mocking
- Einstieg in Webentwicklung mit Spring Boot (Kotlin DSL)

### Themen
- Lambdas, Higher-Order Functions, `map`, `filter`, `fold`
- `sealed class`, `object`, Erweiterungsfunktionen
- DSLs in Kotlin
- Dependency Injection mit Koin oder Spring
- REST mit Spring Boot und Kotlin
- Datenbankzugriff mit Exposed oder Spring Data JPA
- Testen mit JUnit 5, MockK

### Übungsprojekte
- **Notiz-REST-API mit Spring Boot + Kotlin**: vollständiger CRUD-Service
- **CSV-Importer als DSL**: eigene Mini-DSL zur Datenverarbeitung
- **Mini-Forum mit REST und Datenbank**: z. B. H2 oder PostgreSQL
- **Bankkonto-Domainmodell mit Tests**: Wertobjekte, Geschäftslogik, DDD-Light

---

## 🔴 Profi: Architektur, Performance, Kotlin-Ökosystem

### Lernziele
- Fortgeschrittenes Kotlin-Design
- Multiplatform-Fähigkeiten verstehen
- Coroutines und asynchrone Verarbeitung
- Clean Architecture und DDD mit Kotlin

### Themen
- Kotlin Coroutines (Suspending Functions, `flow`)
- Clean Architecture mit Ports & Adapters (Hexagonal)
- Event Sourcing & CQRS mit Kotlin + Axon oder Ktor + Kafka
- Spring Boot Advanced: Configuration Properties, Security
- JVM Internals verstehen (GC, Threads, Memory, ClassLoader)
- Kotlin Multiplatform (JVM, JS, Native)
- Docker, CI/CD, Monitoring

### Übungsprojekte
- **Reaktives Backend mit Ktor + Kotlin Flow**: Chat, Live-Daten
- **Microservice-System in Kotlin (Spring Boot oder Ktor)**: Services, API-Gateway, Docker
- **DDD-Projekt mit EventSourcing**: z. B. Bestellservice mit EventStore
- **Kotlin Multiplatform Projekt**: z. B. API-Client für Android & JVM
- **Coroutines-Tuning & Vergleich mit Threads**: Benchmarks, JMH, VisualVM

---

## Bonus: Nützliche Tools & Ressourcen
- IDE: IntelliJ IDEA (Community oder Ultimate)
- Gradle Kotlin DSL
- Ktor, Koin, Exposed, kotlinx.coroutines, kotlinx.serialization
- Postman oder Insomnia für API-Tests
- GitHub Copilot oder ChatGPT zur Ideensammlung
- Bücher: *Kotlin in Action*, *Effective Kotlin*, *Clean Architecture*, *Domain-Driven Design distilled*

---


