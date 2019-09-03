### Oracle Code One 2019  Lambda Stream Collector Lab

You are are currently on the master branch on this repository. This repository contains branches for each version of Java from 8 to 12, and for two IDEs: Eclipse and IntelliJ. 

For instance, the branch for Java 10 and Eclipse is called `Java10-Eclipse`. 

From this, you should check out the right branch for you, and check the instructions for that branch. See the detailed description of the lab on that branch. Some instructions are specific to the IDE you are using. 

The lab is almost the same on all the branches. Several questions have been removed from the Java 8 branch, since they rely on API added in Java 9 or later.  

There is a PDF file called `Cheatsheet.pdf` that you can check for the useful information it contains about the patterns, classes and methods you are going to need in this lab. Ultimately, you should check the Javadoc.  

This is a lab created for Oracle Code One 2019. It is a Maven project, with the following content in the `test/java` folder:

1. A `A_Lambdas` package
2. A `B_Streams` package
3. A `C_Collectors` package
4. A `D_Challenges` package

Maven declares two dependencies: JUnit and AssertJ. Just make sure that your configuration allows for the downloading of them. 

Each package is then divided into subpackages so that you can easily find your way in the lab. The difficulty is increasing from beginner level to challenge level in each package. If the first questions are too easy for you, just jump to the end and to try the challenges!

The solutions of the exercises are provided in the `src/solutions/java` folder. You can run them by declaring this folder as a source folder in your IDE.  

Each package contains JUnit test classes that you need to modify so that the tests pass.  

For instance, here is the first method of the first test class `A_Suppliers`: 

```Java
    @Test
    @Ignore
    public void a_supplier01() {
        Supplier<StringBuilder> sup = null; // TODO
        assertThat(sup.get().toString()).isEqualTo("abc");
    }
```

The first thing you need to do to run the test is to remove the `@Ignore` annotation so that the test will be run. If you run it as it is, it will be red.

Then you need to modify the line where the `// TODO` mark is found so that the test becomes green. In this very simple case, you can write the following: 

```Java
    @Test
    public void a_supplier01() {
        Supplier<StringBuilder> sup = () -> new StringBuilder("abc");
        assertThat(sup.get().toString()).isEqualTo("abc");
    }
```

If you run this test it should be green, so you can move to the next one. 

Depending on the branch you are looking at, there are up to 126 exercises in the lab, enough to keep you busy for several hours. Good luck!