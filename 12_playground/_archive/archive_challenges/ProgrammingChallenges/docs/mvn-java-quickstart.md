# Maven Quickstart

## [mvn-java-quickstart](https://github.com/roskenet/challenges/tree/main/mvn-java-quickstart)

Use the maven wrapper:

```sh
mvn -N io.takari:maven:wrapper
```

Now you can use `./mvnw clean install`.

## Junit Jupiter

```xml
  <properties>
    <junit.version>5.8.2</junit.version>
    <assertj.version>3.21.0</assertj.version>
  </properties>
  <dependencies>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>${junit.version}</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.assertj</groupId>
      <artifactId>assertj-core</artifactId>
      <version>${assertj.version}</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
```
