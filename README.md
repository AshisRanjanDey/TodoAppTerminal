This is a Java Terminal Application for managing Todos. This has below features - 
  1. Add a Todo
  2. Show the list of current Todos
  3. Delete Todo
  4. Update Todo Status
  5. Exit ( Saves the data)
Cool thing about this application is we don't need to setup a Database for this. It uses a json file to save the data and we can share this file to be used in any other machine
to start with already existing data.

Prerequisite:
  1. Preferably java 17.0.8 2023-07-18 LTS or higher
  2. Preferably Java(TM) SE Runtime Environment (build 17.0.8+9-LTS-211) or higher
  3. Preferably Java HotSpot(TM) 64-Bit Server VM (build 17.0.8+9-LTS-211, mixed mode, sharing) or higher
  4. Preferable apache maven 3.6.3 or higher setup and maven bin location added to path

How to run:
  1. In terminal go to the project root directory (where your pom.xml (Maven project file) is located). Then run :  mvn exec:java -Dexec.mainClass="com.ashis.todo.App".
