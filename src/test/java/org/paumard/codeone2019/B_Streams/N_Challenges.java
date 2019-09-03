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

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class N_Challenges {

    /**
     * Given a stream of strings, accumulate (collect) them into the result string
     * by inserting the input string at both the beginning and end. For example, given
     * input strings "x" and "y" the result should be "yxxy". Note: the input stream
     * is a parallel stream, so you MUST write a proper combiner function to get the
     * correct result.
     */
    @Test
    @Ignore
    public void p_challenge01() {

        Stream<String> input = Arrays.asList(
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t")
                .parallelStream();

        String result = input.collect(null, null, null).toString();
        // TODO fill in lambda expressions or method references in place of the nulls in the line above.

        assertThat(result).isEqualTo("tsrqponmlkjihgfedcbaabcdefghijklmnopqrst");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use the Stream.collect() method that takes 3 arguments. Check precisely the role of each argument.
    // </editor-fold>

    /**
     * Count the total number of words and the number of distinct, lower case
     * words in a stream, in one pass. This exercise uses a helper class
     * that defines methods that are called by the Stream.collect() method.
     * Your task is to fill in the implementation of the accumulate() and
     * combine() methods in the helper class. You don't need to modify the
     * test method itself.
     * <p>
     * The stream is run in parallel, so you must write a combine() method
     * that works properly.
     */
    static class TotalAndDistinct {
        private int count = 0;
        private final Set<String> set = new HashSet<>();

        // rely on implicit no-arg constructor

        void accumulate(String s) {
            // TODO write code to accumulate a single string into this object
        }

        void combine(TotalAndDistinct other) {
            // TODO write code to combine the other object into this one
        }

        int getTotalCount() {
            return count;
        }

        int getDistinctCount() {
            return set.size();
        }
    }

    @Test
    @Ignore
    public void p_challenge02() {

        List<String> allWords = sonnetReader.lines()
                .map(String::toLowerCase)
                .flatMap(SPLIT_PATTERN::splitAsStream)
                .collect(Collectors.toList());

        TotalAndDistinct totalAndDistinct =
                Collections.nCopies(100, allWords)
                        .parallelStream()
                        .flatMap(List::stream)
                        .collect(TotalAndDistinct::new,
                                TotalAndDistinct::accumulate,
                                TotalAndDistinct::combine);

        assertThat(totalAndDistinct.getDistinctCount()).isEqualTo(81);
        assertThat(totalAndDistinct.getTotalCount()).isEqualTo(10700);
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use the Stream.collect() method that takes 3 arguments.
    // Implement the TotalAndDistinct methods to create the 3 parameters.
    // </editor-fold>


    /**
     * Denormalize this map. The input is a map whose keys are the number of legs of an animal
     * and whose values are lists of names of animals. Run through the map and generate a
     * "denormalized" list of strings describing the animal, with the animal's name separated
     * by a colon from the number of legs it has. The ordering in the output list is not
     * considered significant.
     * <p>
     * Input is Map<Integer, List<String>>:
     * { 4=["ibex", "hedgehog", "wombat"],
     * 6=["ant", "beetle", "cricket"],
     * ...
     * }
     * <p>
     * Output should be a List<String>:
     * [ "ibex:4",
     * "hedgehog:4",
     * "wombat:4",
     * "ant:6",
     * "beetle:6",
     * "cricket:6",
     * ...
     * ]
     */
    @Test
    @Ignore
    public void p_challenge03() {

        Map<Integer, List<String>> input = new HashMap<>();
        input.put(4, Arrays.asList("ibex", "hedgehog", "wombat"));
        input.put(6, Arrays.asList("ant", "beetle", "cricket"));
        input.put(8, Arrays.asList("octopus", "spider", "squid"));
        input.put(10, Arrays.asList("crab", "lobster", "scorpion"));
        input.put(750, Arrays.asList("millipede"));

        List<String> result = null; // TODO

        assertThat(result).hasSize(13);
        assertThat(result).contains(
                "ibex:4", "hedgehog:4", "wombat:4", "ant:6", "beetle:6", "cricket:6",
                "octopus:8", "spider:8", "squid:8", "crab:10", "lobster:10", "scorpion:10",
                "millipede:750");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // First create a stream of the Map.Entry key / value pairs from that map.
    // Then find the right mapping of that stream to create the final stream.
    // </editor-fold>

    /**
     * Invert a "multi-map". (From an idea by Paul Sandoz)
     * <p>
     * Given a Map<X, Set<Y>>, convert it to Map<Y, Set<X>>.
     * Each set member of the input map's values becomes a key in
     * the result map. Each key in the input map becomes a set member
     * of the values of the result map. In the input map, an item
     * may appear in the value set of multiple keys. In the result
     * map, that item will be a key, and its value set will be
     * its corresponding keys from the input map.
     * <p>
     * In this case the input is Map<String, Set<Integer>>
     * and the result is Map<Integer, Set<String>>.
     * <p>
     * For example, if the input map is
     * {p=[10, 20], q=[20, 30]}
     * then the result map should be
     * {10=[p], 20=[p, q], 30=[q]}
     * irrespective of ordering. Note that the Integer 20 appears
     * in the value sets for both p and q in the input map. Therefore,
     * in the result map, there should be a mapping with 20 as the key
     * and p and q as its value set.
     * <p>
     * It is possible to accomplish this task using a single stream
     * pipeline (not counting nested B_streams), that is, in a single pass
     * over the input, without storing anything in a temporary collection.
     */
    @Test
    @Ignore
    public void p_challenge04() {

        Map<String, Set<Integer>> input = new HashMap<>();
        input.put("a", new HashSet<>(Arrays.asList(1, 2)));
        input.put("b", new HashSet<>(Arrays.asList(2, 3)));
        input.put("c", new HashSet<>(Arrays.asList(1, 3)));
        input.put("d", new HashSet<>(Arrays.asList(1, 4)));
        input.put("e", new HashSet<>(Arrays.asList(2, 4)));
        input.put("f", new HashSet<>(Arrays.asList(3, 4)));

        Map<Integer, Set<String>> result = null; // TODO

        assertThat(result).hasSize(4);
        assertThat(result.get(1)).contains("a", "c", "d");
        assertThat(result.get(2)).contains("a", "b", "e");
        assertThat(result.get(3)).contains("b", "c", "f");
        assertThat(result.get(4)).contains("d", "e", "f");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use the same idea than the previous exercise to stream the map.
    // Then regroup it as needed using the standard collectors.
    // </editor-fold>

    /**
     * Select the longest words from an input stream. That is, select the words
     * whose lengths are equal to the maximum word length. For this exercise,
     * you must compute the result in a single pass over the input stream.
     * The type of the input is a Stream, so you cannot access elements at random.
     * The stream is run in parallel, so the combiner function must be correct.
     */
    @Test
    @Ignore
    public void p_challenge05() {

        Stream<String> input = Stream.of(
                "alfa", "bravo", "charlie", "delta",
                "echo", "foxtrot", "golf", "hotel").parallel();

        List<String> result = input.collect(
                Collector.of(null, null, null, null));
        // TODO implement a collector by replacing the nulls above

        assertThat(result).containsExactly("charlie", "foxtrot");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // You can first create a helper class as the TotalAndDistinct class and use its
    // methods to create the argument of the Collector.of() method call.
    // </editor-fold>

    /**
     * Given a string, split it into a list of strings consisting of
     * consecutive characters from the original string. Note: this is
     * similar to Python's itertools.groupby function, but it differs
     * from Java's Collectors.groupingBy() collector.
     */
    @Test
    @Ignore
    public void p_challenge06() {

        String input = "aaaaabbccccdeeeeeeaaafff";

        List<String> result = null; // TODO

        assertThat(result).containsExactly("aaaaa", "bb", "cccc", "d", "eeeeee", "aaa", "fff");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // One possibility is a two-pass approach: one pass to gather data about
    // the boundaries between the runs, and the second to create the substrings
    // based on output from the first.
    // </editor-fold>

    /**
     * Given a parallel stream of strings, collect them into a collection in reverse order.
     * Since the stream is parallel, you MUST write a proper combiner function in order to get
     * the correct result.
     */
    @Test
    @Ignore
    public void p_challenge07() {

        Stream<String> input =
                IntStream.range(0, 100).mapToObj(String::valueOf).parallel();
        List<String> expectedResult =
                IntStream.range(0, 100)
                        .map(i -> 99 - i)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.toList());

        List<String> result =
                input.collect(Collector.of(null, null, null));
        // TODO fill in collector functions above

        assertThat(result).containsExactlyElementsOf(expectedResult);
    }
    // Hint 1:
    // <editor-fold defaultstate="collapsed">
    // ArrayDeque supports fast insertion at the front.
    // </editor-fold>
    // Hint 2:
    // <editor-fold defaultstate="collapsed">
    // Be careful with ordering of the arguments and results in the combiner.
    // </editor-fold>


    /**
     * Given an array of int, find the int value that occurs a majority
     * of times in the array (that is, strictly more than half of the
     * elements are that value), and return that int value in an OptionalInt.
     * Note, return the majority int value, not the number of times it occurs.
     * If there is no majority value, return an empty OptionalInt.
     * <p>
     * For example, given an input array [11, 12, 12] the result should be
     * an OptionalInt containing 12. Given an input array [11, 12, 13]
     * the result should be an empty OptionalInt.
     */

    OptionalInt majority(int[] array) {
        return null; // TODO
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // A two-pass approach may be called for here: a counting pass
    // and a majority-finding pass.
    // </editor-fold>

    @Test
    @Ignore
    public void p_challenge08() {

        int[] array1 = {13, 13, 24, 35, 24, 24, 35, 24, 24};
        int[] array2 = {13, 13, 24, 35, 24, 24, 35, 24};

        OptionalInt result1 = majority(array1);
        OptionalInt result2 = majority(array2);


        assertThat(result1).isEqualTo(OptionalInt.of(24));
        assertThat(result2).isEmpty();
    }


    /**
     * Create the following String with the people from the people.txt file.
     * <p/>
     * Remember to use the BufferedReader named "peopleReader" that has already been
     * opened for you.
     */
    @Test
    @Ignore
    public void p_challenge09() {

        String expectedResult = "23: Barbara, Mary, Patricia, Susan\n" +
                "24: Sarah, Thomas, William\n" +
                "25: Linda, Richard\n" +
                "26: John, Margaret, Robert\n" +
                "27: Charles, David, Jennifer, Joseph, Michael\n" +
                "28: Elizabeth, James, Jessica";

        String result = null; // TODO

        assertThat(result).isEqualTo(expectedResult);
    }

// ========================================================
// END OF EXERCISES
// TEST INFRASTRUCTURE IS BELOW
// ========================================================


    // Pattern for splitting a string into words
    static final Pattern SPLIT_PATTERN = Pattern.compile("[- .:,]+");

    private BufferedReader sonnetReader;
    private BufferedReader peopleReader;

    @Before
    public void z_setUpBufferedReader() throws IOException {
        sonnetReader = Files.newBufferedReader(
                Paths.get("files/Sonnet.txt"), StandardCharsets.UTF_8);
        peopleReader = Files.newBufferedReader(
                Paths.get("files/people.txt"), StandardCharsets.UTF_8);
    }

    @After
    public void z_closeBufferedReader() throws IOException {
        sonnetReader.close();
        peopleReader.close();
    }
}
