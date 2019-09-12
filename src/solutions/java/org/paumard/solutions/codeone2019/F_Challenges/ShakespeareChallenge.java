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

package org.paumard.solutions.codeone2019.F_Challenges;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Many information are missing on Shakespeare's life, and it is said, even if it cannot be sure,
 * that he was a great Scrabble player.
 * <p/>
 * The goal of this challenge is to measure how good a player he was.
 * <p/>
 * Several elements are given: first, the list of all the words he used in his writings, second the
 * list of all the allowed words at Scrabble, in english. Two arrays are also given: the first one
 * gives the score for each letter, and the second one the number of available letters in the game.
 */
public class ShakespeareChallenge {

    private static final int[] scrabbleENScore = {
            // a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,  q, r, s, t, u, v, w, x, y,  z
               1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

    private static final int[] scrabbleENDistribution = {
            // a, b, c, d,  e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
               9, 2, 2, 1, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};

    private Set<String> scrabbleWords;
    private Set<String> shakespeareWords;

    /**
     * This first test is free and is only here to make sure that everything is ok with the data files.
     */
    @Test
    public void shakespeare01() {

        assertThat(scrabbleWords).hasSize(23688);
        assertThat(shakespeareWords).hasSize(79339);
    }

    /**
     * First, compute the number of words allowed at Scrabble Shakespeare used.
     */
    @Test
    public void shakespeare02() {

        long number =
                shakespeareWords.stream()
                        .filter(scrabbleWords::contains)
                        .count();

        assertThat(number).isEqualTo(14277L);
    }

    /**
     * Second, compute a function that can compute the score of a given word.
     */
    @Test
    public void shakespeare03() {

        Function<String, Integer> score =
                word -> word.chars().map(letter -> scrabbleENScore[letter - 'a']).sum();

        assertThat(score.apply("hello")).isEqualTo(8);
        assertThat(score.apply("world")).isEqualTo(9);
    }

    /**
     * Third, get the best words that Shakespeare could have played.
     */
    @Test
    public void shakespeare04() {

        Function<String, Integer> score =
                word -> word.chars().map(letter -> scrabbleENScore[letter - 'a']).sum();

        Map.Entry<Integer, List<String>> wordsyScore =
                shakespeareWords.stream()
                        .filter(scrabbleWords::contains)
                        .collect(Collectors.groupingBy(score))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByKey())
                        .get();

        int bestScore = wordsyScore.getKey();
        List<String> bestWords = wordsyScore.getValue();

        assertThat(bestScore).isEqualTo(33);
        assertThat(bestWords).containsExactly("whizzing");
    }

    /**
     * The best word looks a little suspect, is it really possible to write
     * such a word, given that there is only on 'z' available in the game?
     * We need to check if the word can be written given the available letters
     * in the game.
     * <p/>
     * First, let us create a function that takes a word, and returns
     * the histogram of the letters in that word
     */
    @Test
    public void shakespeare05() {

        Function<String, Map<String, Long>> numberOfLettersUsed =
                word -> word.chars().mapToObj(c -> (char)c).map(Object::toString)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        assertThat(numberOfLettersUsed.apply("hello"))
                .containsOnly(Map.entry("h", 1L), Map.entry("e", 1L), Map.entry("l", 2L), Map.entry("o", 1L));
        assertThat(numberOfLettersUsed.apply("whizzing"))
                .containsOnly(Map.entry("w", 1L), Map.entry("h", 1L), Map.entry("i", 2L),
                        Map.entry("z", 2L), Map.entry("n", 1L), Map.entry("g", 1L));
    }

    /**
     * Second, create a Function, that computes the number of blanks you need to
     * write a word. You can use the previous function and scrabbleENDistribution.
     * This array gives the available letters in the game.
     */
    @Test
    public void shakespeare06() {

        Function<String, Map<String, Long>> numberOfLettersUsed =
                word -> word.chars().mapToObj(c -> (char)c).map(Object::toString)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Function<String, Long> numberOfBlanks =
                word ->
                        numberOfLettersUsed.apply(word)
                                .entrySet().stream()
                                .mapToLong(entry ->
                                        Long.max(0, entry.getValue() - scrabbleENDistribution[entry.getKey().charAt(0) - 'a']))
                                .sum();

        assertThat(numberOfBlanks.apply("hello")).isEqualTo(0);
        assertThat(numberOfBlanks.apply("whizzing")).isEqualTo(1L);
        assertThat(numberOfBlanks.apply("buzzards")).isEqualTo(1L);
    }

    /**
     * Remember that a blank letter does not score any point. So you need to update the scoring
     * function. Write the new scoring function, taking into account that some letters are blanks.
     */
    @Test
    public void shakespeare07() {

        Function<String, Map<String, Long>> numberOfLettersUsed =
                word -> word.chars().mapToObj(c -> (char)c).map(Object::toString)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Function<String, Integer> scoreWithBlank =
                word -> numberOfLettersUsed.apply(word)
                        .entrySet().stream()
                        .mapToInt(entry ->
                                Integer.min(entry.getValue().intValue(), scrabbleENDistribution[entry.getKey().charAt(0) - 'a']) *
                                        scrabbleENScore[entry.getKey().charAt(0) - 'a'])
                        .sum();

        assertThat(scoreWithBlank.apply("hello")).isEqualTo(8);
        assertThat(scoreWithBlank.apply("whizzing")).isEqualTo(23);
    }

    /**
     * You can now recompute the best word, taking into account the available letters
     * in the game and the new scoring function.
     */
    @Test
    public void shakespeare08() {

        Function<String, Map<String, Long>> numberOfLettersUsed =
                word -> word.chars().mapToObj(c -> (char)c).map(Object::toString)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Function<String, Long> numberOfBlanks =
                word ->
                        numberOfLettersUsed.apply(word)
                                .entrySet().stream()
                                .mapToLong(entry ->
                                        Long.max(0, entry.getValue() - scrabbleENDistribution[entry.getKey().charAt(0) - 'a']))
                                .sum();

        Function<String, Integer> scoreWithBlank =
                word -> numberOfLettersUsed.apply(word)
                        .entrySet().stream()
                        .mapToInt(entry ->
                                Integer.min(entry.getValue().intValue(), scrabbleENDistribution[entry.getKey().charAt(0) - 'a']) *
                                        scrabbleENScore[entry.getKey().charAt(0) - 'a'])
                        .sum();

        Map.Entry<Integer, List<String>> bestWordsByScore =
                shakespeareWords.stream()
                        .filter(scrabbleWords::contains)
                        .filter(word -> numberOfBlanks.apply(word) <= 2)
                        .collect(Collectors.groupingBy(scoreWithBlank))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByKey())
                        .get();

        int bestScore = bestWordsByScore.getKey();
        List<String> bestWords = bestWordsByScore.getValue();

        assertThat(bestScore).isEqualTo(26);
        assertThat(bestWords).containsExactly("squeezes");
    }

    /**
     * What about getting the words that would score 24? Do not forget to sort
     * them in the alphabetical order.
     */
    @Test
    public void shakespeare09() {


        Function<String, Map<String, Long>> numberOfLettersUsed =
                word -> word.chars().mapToObj(c -> (char)c).map(Object::toString)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Function<String, Long> numberOfBlanks =
                word ->
                        numberOfLettersUsed.apply(word)
                                .entrySet().stream()
                                .mapToLong(entry ->
                                        Long.max(0, entry.getValue() - scrabbleENDistribution[entry.getKey().charAt(0) - 'a']))
                                .sum();

        Function<String, Integer> scoreWithBlank =
                word -> numberOfLettersUsed.apply(word)
                        .entrySet().stream()
                        .mapToInt(entry ->
                                Integer.min(entry.getValue().intValue(), scrabbleENDistribution[entry.getKey().charAt(0) - 'a']) *
                                        scrabbleENScore[entry.getKey().charAt(0) - 'a'])
                        .sum();

        Map<Integer, List<String>> bestWordsByScore =
                shakespeareWords.stream()
                        .filter(scrabbleWords::contains)
                        .filter(word -> numberOfBlanks.apply(word) <= 2)
                        .collect(Collectors.groupingBy(scoreWithBlank));

        List<String> wordsOfScore24 = bestWordsByScore.get(24);
        wordsOfScore24.sort(Comparator.naturalOrder());

        assertThat(wordsOfScore24).containsExactly("exequies", "joyfully", "quaffing", "wheezing", "zephyrs");
    }

    /**
     * Now that we have the best words, we need to place them on the Scrabble board. The first move has to
     * touch the central square, and since the board is symmetrical, playing on a line is the same as playing
     * on a column.
     * <p/>
     * The line you must play on is the following: TW . . DL . . . C . . . DL . . TW
     * <p/>
     * Where TW stands for Triple Word score (you cannot use this square on the first move), DL Double Letter score,
     * and C Center. The word you put on the board must have one letter on the C square, and can then have a letter on
     * one of the DL square.
     * <p/>
     * Knowing that you draw 7 letters, that placing all the letters brings a 50 points bonus, and that the first
     * move gets a double word score, what would Shakespeare have scored? We ask for the 4 best scores, and their
     * corresponding words.
     */
    @Test
    public void shakespeare10() {

        Function<String, Map<String, Long>> numberOfLettersUsed =
                word -> word.chars().mapToObj(c -> (char)c).map(Object::toString)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Function<String, Long> numberOfBlanks =
                word ->
                        numberOfLettersUsed.apply(word)
                                .entrySet().stream()
                                .mapToLong(entry ->
                                        Long.max(0, entry.getValue() - scrabbleENDistribution[entry.getKey().charAt(0) - 'a']))
                                .sum();

        Function<String, Integer> scoreWithBlank =
                word -> numberOfLettersUsed.apply(word)
                        .entrySet().stream()
                        .mapToInt(entry ->
                                Integer.min(entry.getValue().intValue(), scrabbleENDistribution[entry.getKey().charAt(0) - 'a']) *
                                        scrabbleENScore[entry.getKey().charAt(0) - 'a'])
                        .sum();

        Function<String, Stream<String>> letters =
                word -> word.chars().mapToObj(c -> (char)c).map(Object::toString);

        Function<String, Long> limit =
                word -> Long.max((long) word.length() - 4L, 0L);

        Function<String, Integer> bonusForDoubleLetter =
                word -> Stream.concat(letters.apply(word).limit(limit.apply(word)), letters.apply(word).skip(7 - limit.apply(word)))
                        .mapToInt(letter -> scrabbleENScore[letter.charAt(0) - 'a'])
                        .max().orElse(0);

        Function<String, Integer> totalScore =
                word -> (scoreWithBlank.apply(word) + bonusForDoubleLetter.apply(word)) * 2 + (word.length() == 7 ? 50 : 0);

        Map<Integer, List<String>> bestWordsByScore =
                shakespeareWords.stream()
                        .filter(scrabbleWords::contains)
                        .filter(word -> numberOfBlanks.apply(word) <= 2)
                        .collect(Collectors.groupingBy(totalScore))
                        .entrySet().stream()
                        .sorted(Map.Entry.<Integer, List<String>>comparingByKey().reversed())
                        .limit(4)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        assertThat(bestWordsByScore).hasSize(4);
        assertThat(bestWordsByScore).containsKeys(114, 116, 118, 120);
        assertThat(bestWordsByScore.get(114)).contains("qualify", "quicker", "quicken");
        assertThat(bestWordsByScore.get(116)).contains("equinox");
        assertThat(bestWordsByScore.get(118)).contains("zephyrs");
        assertThat(bestWordsByScore.get(120)).contains("jezebel", "quickly");
    }


// ========================================================
// END OF EXERCISES
// TEST INFRASTRUCTURE IS BELOW
// ========================================================

    @Before
    public void z_setupData() {

        try (InputStream fileInputStream = new FileInputStream("files/shakespeare/words.shakespeare.txt.gz");
             GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
             InputStreamReader reader = new InputStreamReader(gzipInputStream);
             BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
            scrabbleWords = bufferedReader.lines().map(String::toLowerCase).collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (InputStream fileInputStream = new FileInputStream("files/shakespeare/ospd.txt.gz");
             GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
             InputStreamReader reader = new InputStreamReader(gzipInputStream);
             BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
            shakespeareWords = bufferedReader.lines().map(String::toLowerCase).collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
