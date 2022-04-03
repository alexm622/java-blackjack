Requirements
====
[Apache Maven](https://maven.apache.org/download.cgi) >= 3.8.4 \
[Java JDK Version](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) >= 17*

\* you may be able to get away with a lesser java version if you edit the pom file, but this is not recommended


Running
===
there are two different methods to running this application \
both of these methods will require that you run it from the command line
1. run the .jar file provided in the releases tab
2. [build](#building) the application using maven and execute the built jar file in cmd
3. use the command `mvn exec:java` in the project root

Building
===
Steps: 
1. use the command `mvn clean install` to build into a jar file. 
2. The final jar file will be between 10 and 15 megabytes and in the target folder named `Blackjack-jar-with-dependencies.jar`
you can then run it with `java -jar Blackjack-jar-with-dependencies.jar`