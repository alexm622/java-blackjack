Requirements
====
[Apache Maven](https://maven.apache.org/download.cgi) >= 3.8.4 \
[Java JDK Version](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) >= 17*

\* you may be able to get away with a lesser java version if you edit the pom file, but this is not recommended


Running
===
there are two different methods to running this application
1. run the .jar file provided in the releases tab
2. build the application using maven and execute the built jar file

Building
===
Steps: 
1. use the command `mvn clean install` to build into a jar file. 
2. The final jar file will be between 10 and 15 megabytes and in the target folder named `javafx-editor-1.0.0.jar`
you can then run it with `java -jar javafx-editor-1.0.0.jar`