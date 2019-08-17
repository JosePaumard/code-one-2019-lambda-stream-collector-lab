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
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers harder stream pipelines,
 * including intermediate operations and collectors.
 * <p>
 * Some of these exercises use a BufferedReader variable
 * named "reader" that the test has set up for you.
 */
public class L_HarderStreams {

    /**
     * Count the number of lines in the text file.
     * <p/>
     * Remember to use the BufferedReader named "reader" that has already been
     * opened for you.
     */
    @Test
    @Ignore
    public void l_harderStream01() {

        long count = 0; // TODO

        assertThat(count).isEqualTo(14);
    }

    /**
     * Find the length of the longest line in the text file.
     * <p/>
     * Remember to use the BufferedReader named "reader" that has already been
     * opened for you.
     */
    @Test
    @Ignore
    public void l_harderStream02() {

        int longestLength = 0; // TODO

        assertThat(longestLength).isEqualTo(53);
    }

    /**
     * Find the longest line in the text file.
     * <p/>
     * Remember to use the BufferedReader named "reader" that has already been
     * opened for you.
     */
    @Test
    @Ignore
    public void l_harderStream03() {

        String longestLine = null; // TODO

        assertThat(longestLine).isEqualTo("Feed'st thy light's flame with self-substantial fuel,");
    }

    /**
     * Select one of the longest words from the input list.
     */
    @Test
    @Ignore
    public void l_harderStream04() {

        List<String> input = Arrays.asList(
                "alfa", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel");

        String result = null; // TODO

        assertThat(result).isIn("charlie", "foxtrot");
    }

    /**
     * Create a list of all the letters used in the following list, ordered in the alphabetical order
     * and with no doubles.
     * You can use a variant of the function created for K_SimpleStreams.simpleStream10().
     */
    @Test
    @Ignore
    public void l_harderStream05() {

        List<String> input = Arrays.asList(
                "alfa", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel");

        List<String> result = null; // TODO

        assertThat(result).containsExactly("a", "b", "c", "d", "e", "f", "g", "h", "i", "l", "o", "r", "t", "v", "x");
    }

    /**
     * Collect all the words from the text file into a list.
     * <p/>
     * Remember to use the BufferedReader named "reader" that has already been
     * opened for you.
     * Use the regular expression Pattern SPLIT_PATTERN to split a string into words, and use
     * Pattern.splitAsStream(String) to do the splitting. SPLIT_PATTERN is defined at the bottom of this file.
     * As before, use the BufferedReader variable named "reader" that has been set up for you to read from
     * the text file.
     */
    @Test
    @Ignore
    public void l_harderStream06() {

        List<String> output = null; // TODO

        assertThat(output).isEqualTo(
                Arrays.asList(
                        "From", "fairest", "creatures", "we", "desire", "increase",
                        "That", "thereby", "beauty's", "rose", "might", "never", "die",
                        "But", "as", "the", "riper", "should", "by", "time", "decease",
                        "His", "tender", "heir", "might", "bear", "his", "memory",
                        "But", "thou", "contracted", "to", "thine", "own", "bright", "eyes",
                        "Feed'st", "thy", "light's", "flame", "with", "self", "substantial", "fuel",
                        "Making", "a", "famine", "where", "abundance", "lies",
                        "Thy", "self", "thy", "foe", "to", "thy", "sweet", "self", "too", "cruel",
                        "Thou", "that", "art", "now", "the", "world's", "fresh", "ornament",
                        "And", "only", "herald", "to", "the", "gaudy", "spring",
                        "Within", "thine", "own", "bud", "buriest", "thy", "content",
                        "And", "tender", "churl", "mak'st", "waste", "in", "niggarding",
                        "Pity", "the", "world", "or", "else", "this", "glutton", "be",
                        "To", "eat", "the", "world's", "due", "by", "the", "grave", "and", "thee"));
    }

    /**
     * Read the words from the text file, and create a list containing the words
     * of length 8 or longer, converted to lower case, and sorted alphabetically.
     * <p/>
     * Remember to use the BufferedReader named "reader" that has already been
     * opened for you.
     */
    @Test
    @Ignore
    public void l_harderStream07() {

        List<String> output = null; // TODO

        assertThat(output).isEqualTo(
                Arrays.asList(
                        "abundance", "beauty's", "contracted", "creatures",
                        "increase", "niggarding", "ornament", "substantial"));
    }

    /**
     * Read the words from the text file, and create a list containing the words
     * of length 8 or longer, converted to lower case, and sorted reverse alphabetically.
     * (Same as above except for reversed sort order.)
     */
    @Test
    @Ignore
    public void l_harderStream08() {

        List<String> output = null; // TODO

        assertThat(output).isEqualTo(
                Arrays.asList(
                        "substantial", "ornament", "niggarding", "increase",
                        "creatures", "contracted", "beauty's", "abundance"));
    }

    /**
     * Read words from the text file, and sort unique, lower-cased words by length,
     * then alphabetically within length, and place the result into an output list.
     * <p/>
     * Remember to use the BufferedReader named "reader" that has already been
     * opened for you.
     */
    @Test
    @Ignore
    public void l_harderStream09() {

        List<String> output = null; // TODO

        assertThat(output).isEqualTo(
                Arrays.asList(
                        "a", "as", "be", "by", "in", "or", "to", "we",
                        "and", "art", "bud", "but", "die", "due", "eat", "foe",
                        "his", "now", "own", "the", "thy", "too", "bear", "else",
                        "eyes", "from", "fuel", "heir", "lies", "only",
                        "pity", "rose", "self", "that", "thee", "this", "thou",
                        "time", "with", "churl", "cruel", "flame", "fresh", "gaudy",
                        "grave", "might", "never", "riper", "sweet", "thine",
                        "waste", "where", "world", "bright", "desire", "famine",
                        "herald", "mak'st", "making", "memory", "should", "spring",
                        "tender", "within", "buriest", "content", "decease",
                        "fairest", "feed'st", "glutton", "light's", "thereby", "world's", "beauty's",
                        "increase", "ornament", "abundance", "creatures", "contracted", "niggarding",
                        "substantial"));
    }


// ========================================================
// END OF EXERCISES
// TEST INFRASTRUCTURE IS BELOW
// ========================================================

    // Pattern for splitting a string into words
    static final Pattern SPLIT_PATTERN = Pattern.compile("[- .:,]+");

    private BufferedReader reader;

    @Before
    public void z_setUpBufferedReader() throws IOException {
        reader = Files.newBufferedReader(
                Paths.get("files/Sonnet.txt"), StandardCharsets.UTF_8);
    }

    @After
    public void z_closeBufferedReader() throws IOException {
        reader.close();
    }
}
