/*
 * Copyright (C) 2019 José Paumard
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.paumard.codeone2019.A_Lambdas.b_comparators;

import org.junit.Ignore;
import org.junit.Test;
import org.paumard.codeone2019.A_Lambdas.b_comparators.model.Person;

import java.util.Comparator;
import java.util.function.IntBinaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers the Comparator interface.
 * Comparator chaining and factory methods are also covered. The code you need
 * to write uses the factory methods and default methods of the Comparator interface.
 */
public class F_Comparators {

    final Person michael = new Person("Michael", "Jackson", 51);
    final Person rod = new Person("Rod", "Stewart", 71);
    final Person paul = new Person("Paul", "McCartney", 74);
    final Person mick = new Person("Mick", "Jagger", 73);
    final Person jermaine = new Person("Jermaine", "Jackson", 61);

    /**
     * Write a Comparator that compare instances of String using their length.
     * For instance FOUR (4 letters) is greater than TWO (three letters)
     */
    @Test
    @Ignore
    public void f_comparator01() {

        Comparator<String> compareByLength = null; // TODO

        assertThat(compareByLength.compare("FOUR", "TWO")).isGreaterThan(0);
        assertThat(compareByLength.compare("ONE", "SEVEN")).isLessThan(0);
        assertThat(compareByLength.compare("ONE", "TWO")).isEqualTo(0);
    }
    /* Hint:
     * Check the static factory methods of the Comparator interface.
     * Try to pass a method reference to this method call.
     */

    /**
     * Write a Comparator that compare instances of String using their length.
     * If the lengths are the same, then use the alphabetical order.
     */
    @Test
    @Ignore
    public void f_comparator02() {

        Comparator<String> compareByLengthThenAlphabetical = null; // TODO

        assertThat(compareByLengthThenAlphabetical.compare("FOUR", "TWO")).isGreaterThan(0);
        assertThat(compareByLengthThenAlphabetical.compare("ONE", "SEVEN")).isLessThan(0);
        assertThat(compareByLengthThenAlphabetical.compare("ONE", "TWO")).isLessThan(0);
        assertThat(compareByLengthThenAlphabetical.compare("FOUR", "FIVE")).isGreaterThan(0);
        assertThat(compareByLengthThenAlphabetical.compare("EIGHT", "EIGHT")).isEqualTo(0);
    }
    /* Hint:
     * Use the previous comparator and check the default methods of the Comparator interface.
     * See if some of them can chain comparators.
     * Remember that String is comparable and see if you can create a Comparator that can
     * compare Comparable objects usin their natural order.
     */

    /**
     * Write a Comparator that compares instances of Person using their lastName.
     */
    @Test
    @Ignore
    public void f_comparator03() {

        Comparator<Person> compareByLastName = null; // TODO

        assertThat(compareByLastName.compare(michael, rod)).isLessThan(0);
        assertThat(compareByLastName.compare(paul, paul)).isEqualTo(0);
        assertThat(compareByLastName.compare(michael, jermaine)).isEqualTo(0);
    }
    /* Hint:
     * Check the static factory methods of the Comparator interface.
     * Try to pass a method reference to this method call.
     */

    /**
     * Write a Comparator that compares instances of Person using their
     * lastName, and if their last name is the same, uses their first name.
     */
    @Test
    @Ignore
    public void f_comparator04() {

        Comparator<Person> compareByLastNameThenFirstName = null; // TODO

        assertThat(compareByLastNameThenFirstName.compare(michael, rod)).isLessThan(0);
        assertThat(compareByLastNameThenFirstName.compare(paul, paul)).isEqualTo(0);
        assertThat(compareByLastNameThenFirstName.compare(michael, jermaine)).isGreaterThan(0);
    }
    /* Hint:
     * You need to use all the solutions you used in the previous examples:
     * - creating comparators using factory methods
     * - chaining comparators using default methods.
     */

    /**
     * Write a Comparator that compares the people in the order reversed from
     * the one you wrote in the comparator04() exercise.
     */
    @Test
    @Ignore
    public void f_comparator05() {

        Comparator<Person> compareByLastNameThenFirstNameReversed = null; // TODO

        assertThat(compareByLastNameThenFirstNameReversed.compare(michael, rod)).isGreaterThan(0);
        assertThat(compareByLastNameThenFirstNameReversed.compare(paul, paul)).isEqualTo(0);
        assertThat(compareByLastNameThenFirstNameReversed.compare(michael, jermaine)).isLessThan(0);
    }
    /* Hint:
     * Use the previous comparator and check the default methods of the Comparator interface.
     * See if it can be reversed.
     */

    /**
     * Write a Comparator that compares the people in the same order than the
     * one you wrote in comparator04(), but that supports null values. The null
     * values should be considered greater than any non-null values.
     */
    @Test
    @Ignore
    public void f_comparator06() {

        Comparator<Person> compareByLastNameThenFirstNameWithNull = null; // TODO

        assertThat(compareByLastNameThenFirstNameWithNull.compare(michael, rod)).isLessThan(0);
        assertThat(compareByLastNameThenFirstNameWithNull.compare(paul, paul)).isEqualTo(0);
        assertThat(compareByLastNameThenFirstNameWithNull.compare(michael, jermaine) > 0);
        assertThat(compareByLastNameThenFirstNameWithNull.compare(mick, null)).isLessThan(0);
        assertThat(compareByLastNameThenFirstNameWithNull.compare(null, mick)).isGreaterThan(0);
    }
    /* Hint:
     * Use the previous comparator and check the static methods of the Comparator interface.
     * See if there are factory methods to handle null values.
     */

    /**
     * Write a Comparator that compares two people by age.
     * Try to write the comparator so as to avoid boxing of primitives.
     */
    @Test
    @Ignore
    public void f_comparator07() {

        Comparator<Person> compareByAge = null; // TODO

        assertThat(compareByAge.compare(michael, rod)).isLessThan(0);
        assertThat(compareByAge.compare(paul, paul)).isEqualTo(0);
        assertThat(compareByAge.compare(mick, jermaine)).isGreaterThan(0);
    }
    /* Hint:
     * Look for static methods on the Comparator interface that have primitive specializations.
     */


    /**
     * Write a Comparator that compares two people using the fact that the Person
     * class implements Comparable. Try to use a factory method from the
     * Comparator interface.
     */
    @Test
    @Ignore
    public void f_comparator08() {

        Comparator<Person> compare = null; // TODO

        assertThat(compare.compare(michael, rod)).isLessThan(0);
        assertThat(compare.compare(paul, paul)).isEqualTo(0);
        assertThat(compare.compare(mick, jermaine)).isGreaterThan(0);
        assertThat(compare.compare(michael, jermaine)).isGreaterThan(0);
    }
    /* Hint:
     * Use a ternary operator (cond ? result1 : result2) instead of subtraction.
     */


    /**
     * Write a lambda expression that compares two int values and returns an
     * int result that is less than, equal to, or greater than zero, like
     * a comparator. Watch out for overflow. The Comparator interface takes
     * two objects, but in this case we are comparing int primitives, so the
     * functional interface we use is IntBinaryOperator.
     */
    @Test
    @Ignore
    public void f_comparator09() {

        IntBinaryOperator intCompare = null; // TODO

        assertThat(intCompare.applyAsInt(0, 1)).isLessThan(0);
        assertThat(intCompare.applyAsInt(1, 1)).isEqualTo(0);
        assertThat(intCompare.applyAsInt(2, 1) > 0);
        assertThat(intCompare.applyAsInt(Integer.MIN_VALUE, Integer.MAX_VALUE)).isLessThan(0);
        assertThat(intCompare.applyAsInt(Integer.MAX_VALUE, Integer.MIN_VALUE)).isGreaterThan(0);
    }
    /* Hint:
     * Use a method reference to a static method on the Integer class.
     * Checking the source code of this static method from the Integer class gives a hint of
     * the problems raised by just subtracting integers to create comparators.
     */

    /**
     * Write a method reference that compares two int values and returns an
     * int result that is less than, equal to, or greater than zero, like
     * a comparator.
     */
    @Test
    @Ignore
    public void f_comparator10() {

        IntBinaryOperator intCompare = null; // TODO

        assertThat(intCompare.applyAsInt(0, 1)).isLessThan(0);
        assertThat(intCompare.applyAsInt(1, 1)).isEqualTo(0);
        assertThat(intCompare.applyAsInt(2, 1)).isGreaterThan(0);
        assertThat(intCompare.applyAsInt(Integer.MIN_VALUE, Integer.MAX_VALUE)).isLessThan(0);
        assertThat(intCompare.applyAsInt(Integer.MAX_VALUE, Integer.MIN_VALUE)).isGreaterThan(0);
    }
    /* Hint:
     * Use a method reference to a static method on the Double class.
     */

    interface DoubleToIntBiFunction {
        int applyAsInt(double a, double b);
    }

    /**
     * Write a method reference that compares two double values and returns an
     * int result that is less than, equal to, or greater than zero, like
     * a comparator. There functional interface that takes two doubles and returns
     * an int, so we define one here. Comparing double values introduces
     * special cases such NaN. Consider all NaN values to be equal to each other
     * and greater than any non-NaN value.
     */
    @Test
    @Ignore
    public void f_comparator11() {

        DoubleToIntBiFunction doubleCompare = null; // TODO

        assertThat(doubleCompare.applyAsInt(0.0, 1.0)).isLessThan(0);
        assertThat(doubleCompare.applyAsInt(1.0, 1.0)).isEqualTo(0);
        assertThat(doubleCompare.applyAsInt(2.0, 1.0)).isGreaterThan(0);
        assertThat(doubleCompare.applyAsInt(Double.NaN, Double.NaN)).isEqualTo(0);
        assertThat(doubleCompare.applyAsInt(Double.NaN, 0.0)).isGreaterThan(0);
        assertThat(doubleCompare.applyAsInt(0.0, Double.NaN)).isLessThan(0);
    }
}
