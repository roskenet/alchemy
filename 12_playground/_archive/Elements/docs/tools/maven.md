---
Title:	Maven Cookbook
Authors:	Felix Roske
---

# Maven 

## Add the maven wrapper

To ensure that everybody has the correct maven version to build a specific project it is a good idea to have maven to be part of your code:

To add the maven wrapper tool to an existing project:

```bash
cd yourmavenproject
mvn -N io.takari:maven:0.7.6:wrapper -Dmaven=3.5.4
```

# Maven and docker

```xml
    <build>
        <finalName>my-application-artifact</finalName>
        <plugins>
            <plugin>
                <groupId>io.fabric8</groupId>
                <artifactId>docker-maven-plugin</artifactId>
                <version>0.31.0</version>
                <configuration>
                    <images>
                        <image>
                            <name>${docker.repo}/${project.build.finalName}:${cdp-build-version}</name>
                            <build>
                                <from>${docker.from}</from>
                                <labels>
                                    <maintainer>${docker.maintainer}</maintainer>
                                </labels>
                                <assembly>
                                    <descriptorRef>artifact</descriptorRef>
                                </assembly>
                                <cmd>java -jar $JAVA_OPTS maven/${project.build.finalName}.jar</cmd>
                            </build>
                        </image>
                    </images>
                </configuration>
            </plugin>
        <plugins>
    </build>
```
