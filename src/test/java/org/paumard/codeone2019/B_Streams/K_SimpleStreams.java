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

package org.paumard.codeone2019.B_Streams;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers simple simpleStream pipelines,
 * including intermediate operations and basic collectors.
 */
public class K_SimpleStreams {

    /**
     * Given a list of words, create an output list that contains the elements
     * converted to upper case.
     * Use the collect(Collectors.toList()) pattern to create the output list.
     */
    @Test
    @Ignore
    public void k_simpleStream01() {

        List<String> input = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        List<String> result = null; // TODO

        assertThat(result)
                .containsExactly("ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN");
    }

    /**
     * Given a list of words, create an output list that contains
     * only the odd-length words, converted to upper case.
     * Use the collect(Collectors.toList()) pattern to create the output list.
     */
    @Test
    @Ignore
    public void k_simpleStream02() {

        List<String> input = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        List<String> result = null; // TODO

        assertThat(result)
                .containsExactly("ONE", "TWO", "THREE", "SIX", "SEVEN", "EIGHT", "TEN");
    }

    /**
     * Given a list of words, create an output list that contains
     * only words from 3 to 8.
     * Use the collect(Collectors.toList()) pattern to create the output list.
     */
    @Test
    @Ignore
    public void k_simpleStream03() {

        List<String> input = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        List<String> result = null; // TODO

        assertThat(result)
                .containsExactly("three", "four", "five", "six", "seven", "eight");
    }

    /**
     * Given a list of words, create an output list that contains
     * only the first letters of all the words, without any double.
     * Use the collect(Collectors.toList()) pattern to create the output list.
     */
    @Test
    @Ignore
    public void k_simpleStream04() {

        List<String> input = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        List<String> result = null; // TODO

        assertThat(result)
                .containsExactly("o", "t", "f", "s", "e", "n");
    }

    /**
     * Given a list of words, create an output list that contains
     * only the first letters of all the words, without any double, sorted in the alphabetical order.
     * Use the collect(Collectors.toList()) pattern to create the output list.
     */
    @Test
    @Ignore
    public void k_simpleStream05() {

        List<String> input = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        List<String> result = null; // TODO

        assertThat(result)
                .containsExactly("e", "f", "n", "o", "s", "t");
    }

    /**
     * Given a list of words, count the number of different lengths of those words.
     * Try not to create any list.
     */
    @Test
    @Ignore
    public void k_simpleStream06() {

        List<String> input = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        long result = 0L; // TODO

        assertThat(result).isEqualTo(3L);
    }

    /**
     * Create the following list: {"+", "+", "+", "+", "+"}.
     * Try to use a factory method from Stream.
     */
    @Test
    @Ignore
    public void k_simpleStream07() {

        List<String> result = null; // TODO

        assertThat(result).containsExactly("+", "+", "+", "+", "+");
    }

    /**
     * Create the following list: {"+++", "++++", "+++++", "+++++++", "++++++++"}.
     * Try to use a factory method from Stream.
     */
    @Test
    @Ignore
    public void k_simpleStream08() {

        List<String> result = null; // TODO

        assertThat(result).containsExactly("+++", "++++", "+++++", "++++++", "+++++++");
    }

    /**
     * Create the following list: {1, 2, 3, 4, 5}.
     * Try to avoid the boxing of integers until the list is created.
     */
    @Test
    @Ignore
    public void k_simpleStream09() {

        List<Integer> result = null; // TODO

        assertThat(result).containsExactly(1, 2, 3, 4, 5);
    }

    /**
     * Create a function that take a String as a parameter and returns
     * the list of the letters of that string, in lower case, ordered in alphabetical order
     * and with no doubles.
     */
    @Test
    @Ignore
    public void k_simpleStream10() {

        Function<String, List<String>> wordToLetters = null; // TODO

        assertThat(wordToLetters.apply("Hello world")).containsExactly("d", "e", "h", "l", "o", "r", "w");
    }
}
