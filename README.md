
Rest Assured api automation test project.

Post request, create for id -> Put request in according id and update for address -> Get request, asserts with update address.

**Setup:** 
1. Install Java and set variables

   1.1  https://www.oracle.com/java/technologies/downloads , download and install.
   
   1.2  use the command to check path of Java

        $ /usr/libexec/java_home -V

   1.3  Add the path in .zshrc

        $ vi ~/.zshrc
      
        export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-25.jdk/Contents/Home
        export PATH=$JAVA_HOME/bin:$PATH

    1.4  Apply change

        $ source ~/.zshrc

    1.5  Verify the setup:

        $  echo $JAVA_HOME
        $  java -version

3.   Install eclipse
  
     2.1  https://www.eclipse.org/downloads/packages/, download and install.

     2.2  Create a Maven project.


    


5. Configure Rest Assured into project

     3.1 Add < dependencies > < /dependencies >  in pom.xml 


     3.2 Go to mvnrepository.com, search for Dependency (or add Jar) and copy the block of code under 3.1 e.g.
   
       - Rest assured
       - TestNG    // test runner, annotation
       - Hamcrest  // matcher framework
 


**Run the tests:** 

A. at each file,
- src > (default package) > basic.java -> Run As -> "Java Application".
- src > files > DynamicJson.java -> Run As -> "TestNG Test" (ensure enabled=true at @Test) // need to install TestNG Test first via Help > "Eclipse Marketplace...".
- src > files > ReadFromJsonFile.java -> Run As -> "TestNG Test".

B. create testng-suite.xml at root project level,
- Right-click on the testng-suite.xml file, also add <class> name.
- Select "Run As" > "TestNG Suite".

C. run from cmd line via Maven,
- go to project directory, and run "mvn clean test".  // need to install maven and setup environment path first. also here project has suite .xml file outside default setting to run it needs specific configuration for test suite xml which declared under plugin 'manven-surefire-plugin' in pom.xml. Otherwise, or in default 'mvn clean test' can run for test with its default settings.
