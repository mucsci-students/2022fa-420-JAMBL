# 2022fa-420-JAMBL
# Description
Users can use this command line interface to construct a class UML diagram. It contains class features such as add, remove, and rename. Fields and methods can be added/removed/edited to each class. Furthermore, this tool allows users to build or remove a class relationship. Once the UML diagram is constructed, the user can view a list of classes, a class with attributes, and a list of relationships. Once the user has completed creating the UML diagram, the program can be saved to a Json format, and the exit command can be used to exit the program. A previously saved file can also be uploaded to the UML editor. A help command is provided to aid the user.

# Design Pattern Implementation
* ModelViewController - used to separate the data, logic and display. Allows for different views and controllers based off of CLI or GUI modes.
* Iterator - used to traverse the HashSets used within the Model components. We made use of the built-in Java Iterator class.
* Memento - used to create a state of the Model to return to if needed. Memento was used in the implementation of the undo/redo functionality.
* Command - used to encapsulate each type of function the program was performing with a uniform execution. Command design pattern was used in the Controller to actually run each command from the user.

# How to run JAMBL UML Editor
* Ensure that both Maven and Java JDK 19 are both installed correctly by typing in the command line "mvn -version" or "java -version" to show both the Maven version or the Java version currently running on the machine.
* Go to https://github.com/mucsci-students/2022fa-420-JAMBL. From the code button Download the project zip file and unzip the file.
* Change your directory to /jambl which contains a src directory and pom.xml file.
* Enter the following command: mvn dependency:copy-dependencies package
* To run the program in GUI mode use the command: java -jar target/jambl-1.0.jar
* To run the program in CLI mode use the command: java -jar target/jambl-1.0.jar --cli
 
# Requirements
* Java JDK 19 (https://www.oracle.com/java/technologies/downloads/)
* Apache Maven 3.8.6 (https://maven.apache.org/download.cgi)
* Store Data: JSON

# Developers
* Alex P.
* Ben S.
* John S.
* Lauryn S.
* Meba S.



# MIT License

Copyright (c) [2022] [JAMBL]

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions: The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
