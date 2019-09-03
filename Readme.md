### Oracle Code One 2019  Lambda Stream Collector Lab

#### Introduction

Welcome to the Lambda/Streams Programming Laboratory! The goal of this lab is for you to learn about the lambda expressions, default methods, and APIs (particularly the Streams library) introduced in Java 8.

The lab is structured as a set of exercises in the form of JUnit tests. To complete each exercise, write some code that uses a lambda or new API that enables the test to pass.

There is a PDF file called `Cheatsheet.pdf` that you can check for the useful information it contains about the patterns, classes and methods you are going to need in this lab. Ultimately, you should check the Javadoc.  

#### How to use the lab

This is the Java 9 branch for IntelliJ. Use it with a version 9 of the JDK. 

You can check the Settings of IntelliJ for the `Custom folding regions` property, that should be checked. With this the hints we put with the exercises will be closed by default when you open an exercise file. 

At the top of each exercise is a comment that describes the goal of the exercise. Within the test method, there is a `// TODO` comment that marks the location where you need fill in some implementation code. There may be some setup code above the `// TODO` comment, and there will be some assertion-checking code below. You shouldn't have to modify any of the setup code at the top of the test method or the assertions at the bottom of the test method.

There is sometimes a hint or two after a test method. If you're having trouble with an exercise, look for hints. The hint text is inside a editor fold that is closed by default, so click on the plus-sign in the left margin to read it.

The intent of the exercises is to solve them using the Java 8 lambda expressions feature, the Java 8 default methods feature, the Java 8 Streams API, and other APIs added in Java 8. Of course, it is possible to use conventional Java code, such as for-loops, but all of the exercises are amenable to being solved using new features in just a handful of lines. Most exercises will take less than half a dozen lines. Some of the more difficult exercises may take up to eight lines, depending upon how aggressive you are about breaking lines. None of the exercises involve writing large amounts of code. Most of the streams-based exercises involve writing a single stream pipeline.

Several of the exercises read data from a text file. The field named "reader" is a `BufferedReader` which will be opened for you on the text file. In any exercise that refers to reading from the text file, you can simply use the "reader" variable without worry about opening or closing it. This is set up by JUnit using the `@Before` and `@After` methods at the bottom of the file. The text files you need are provided with the project.

If you're really stuck, the solutions to the exercises are in the folder `src/solutions/java`. You can run them by declaring this folder as a source folder in your IDE.

There is one solutions file corresponding to each exercise file. Many exercises can be solved in several different ways. In some cases, the solutions file will have several alternatives. Even if you've solved an exercise, it can be useful to look at the solutions to compare your solutions with those of the lab authors.


#### Some technical details

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

There are 126 tests in the lab, enough to keep you busy for several hours. Good luck!