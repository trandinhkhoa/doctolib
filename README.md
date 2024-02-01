PROMPT:
You are building the back-end for a website that will allow patients to book appointments with their doctor!
Your goal is to write an algorithm in or Java that computes the available slots in a doctor's calendar.
You will write a function that takes a date as input and returns an object/hash containing the doctor's available slots for the next seven days, starting on the input date.
There's a SQL database table that contains events. Events come in two kinds:
- opening: times when the doctor is available to take patients
- appointment: times when the doctor is not available because she's with a patient
The details of the specification for the function will be provided in the form of unit tests.
Your goal is to make the tests pass by writing code that will make the tests pass one by one.

Create the database
```
sqlite3 my.db < database.sql
```

Generate the project
```
mvn archetype:generate -DgroupId=com.example -DartifactId=hello-world -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

Set java version
```
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
		<java.version>17</java.version>
  </properties>
```
Update the test library
```
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
```

Build
```
mvn clean install
```
Run
```
java -cp target/hello-world-1.0-SNAPSHOT.jar com.example.App
```


By default, dependencies are not packaged into the output jar.
```
  <build>
    <plugins>
      <plugin>
        <artifactId>maven-assembly-plugin</artifactId>
        <configuration>
          <archive>
            <manifest>
              <mainClass>fully.qualified.MainClass</mainClass>
            </manifest>
          </archive>
          <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
          </descriptorRefs>
        </configuration>
      </plugin>
    </plugins>
  </build>
```
run this plugin
```
mvn clean compile assembly:single
```
run
```
java -cp target/hello-world-1.0-SNAPSHOT-jar-with-dependencies.jar   com.example.App
```