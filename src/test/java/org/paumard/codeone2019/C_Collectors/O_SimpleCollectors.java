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

package org.paumard.codeone2019.C_Collectors;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers the collect() terminal operation with the basic collectors.
 * The collectors used in this class can be built from the factory methods of the Collectors
 * factory class. This collectors are the simplest ones: they do not take another, so-called
 * downstream collector as a parameter.
 */
public class O_SimpleCollectors {

    /**
     * Count the number of elements on that list.
     * Try to use a collector from the Collectors factory class.
     */
    @Test
    @Ignore
    public void n_simpleCollector01() {

        List<String> input = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        long count = 0L; // TODO

        assertThat(count).isEqualTo(10L);
    }
    /* Hint:
     * You can check the Collectors.counting() collector.
     */

    /**
     * Compute the max element of that list, in the alphabetical order.
     * Try to use a collector from the Collectors factory class.
     */
    @Test
    @Ignore
    public void n_simpleCollector02() {

        List<String> input = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        String max = null; // TODO

        assertThat(max).isEqualTo("two");
    }
    /* Hint:
     * You can check the Collectors.maxBy() collector.
     */

    /**
     * Compute the min length of the elements of that list.
     * Try to use a collector from the Collectors factory class.
     */
    @Test
    @Ignore
    public void n_simpleCollector03() {

        List<String> input = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        int minLength = 0; // TODO

        assertThat(minLength).isEqualTo(3);
    }
    /* Hint:
     * You can check the Collectors.minBy() collector.
     */

    /**
     * Compute the average length of the elements of that list.
     * Try to use a collector from the Collectors factory class.
     */
    @Test
    @Ignore
    public void n_simpleCollector04() {

        List<String> input = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        double averageLength = 0; // TODO

        assertThat(averageLength).isEqualTo(3.9d);
    }
    /* Hint:
     * You can check the Collectors.averagingXXX() collectors and choose the right one.
     */

    /**
     * Compute the sum of the elements of that list.
     * Try to use a collector from the Collectors factory class.
     */
    @Test
    @Ignore
    public void n_simpleCollector05() {

        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        int sum = 0; // TODO

        assertThat(sum).isEqualTo(45);
    }
    /* Hint:
     * You can check the Collectors.summingXXX() collectors and choose the right one.
     */

    /**
     * Concatenate the elements of that list in a String, separated by a space.
     * Try to use a collector from the Collectors factory class.
     */
    @Test
    @Ignore
    public void n_simpleCollector06() {

        List<String> input = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        String result = null; // TODO

        assertThat(result).isEqualTo("one two three four five six seven eight nine ten");
    }
    /* Hint:
     * You can check the Collectors.joining() collector.
     */
}
