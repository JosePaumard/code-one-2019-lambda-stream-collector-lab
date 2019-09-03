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

package org.paumard.codeone2019.A_Lambdas.c_collections;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers the default method added to the List interface.
 */
public class I_Lists {

    /**
     * Replace every word in the list with its upper case equivalent.
     */
    @Test
    @Ignore
    public void i_list01() {

        List<String> strings = Arrays.asList(
                "alfa", "bravo", "charlie", "delta", "echo", "foxtrot");

        // TODO code to modify list

        assertThat(strings).containsExactly("ALFA", "BRAVO", "CHARLIE", "DELTA", "ECHO", "FOXTROT");
    }
    /* Hint:
     * Use List.replaceAll() and try to pass a method reference.
     */

    /**
     * Replace every null value in the list with an empty String.
     */
    @Test
    @Ignore
    public void i_list02() {

        List<String> strings = Arrays.asList(
                "alfa", null, "charlie", "delta", null, "foxtrot");

        // TODO code to modify strings

        assertThat(strings).containsExactly("alfa", "", "charlie", "delta", "", "foxtrot");
    }
    /* Hint:
     * Use List.replaceAll().
     */

    /**
     * Sort the content of the list in the alphabetical order of the strings.
     * Try to use a factory method from Comparator.
     */
    @Test
    @Ignore
    public void i_list03() {

        List<String> strings = Arrays.asList(
                "one", "two", "three", "four", "five", "six");

        // TODO code to modify strings

        assertThat(strings).containsExactly("five", "four", "one", "six", "three", "two");
    }
    /* Hint:
     * Use List.sort().
     */

    /**
     * Sort the content of the list by the length of the strings. In case the length is the same,
     * then use the alphabetical order.
     * Try to use a factory method from Comparator.
     */
    @Test
    @Ignore
    public void i_list04() {

        List<String> strings = Arrays.asList(
                "one", "two", "three", "four", "five", "six");

        // TODO code to modify strings

        assertThat(strings).containsExactly("one", "six", "two", "five", "four", "three");
    }
    /* Hint:
     * Use List.sort().
     */
}
