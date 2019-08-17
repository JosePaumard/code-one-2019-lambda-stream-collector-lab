### Oracle Code One 2019  Lambda Stream Collector Lab

This is the Java 9 branch. Use it with a version 9 of the JDK.

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

There are 124 tests in the lab, enough to keep you busy for several hours. Good luck!