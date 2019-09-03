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

package org.paumard.codeone2019.A_Lambdas.d_maps;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers the default method added to the Map interface.
 */
public class J_Maps {

    /**
     * Given a map whose keys are Integers and whose values are Strings,
     * set each value to upper case.
     */
    @Test
    @Ignore
    public void j_map01() {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "alfa");
        map.put(2, "bravo");
        map.put(3, "charlie");

        // TODO write code to modify map

        assertThat(map).hasSize(3);
        assertThat(map).containsKeys(1, 2, 3);
        assertThat(map).containsValues("ALFA", "BRAVO", "CHARLIE");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.replaceAll().
    // </editor-fold>

    /**
     * For some reason the provided map doesn't have mappings for all the keys.
     * Some keys are missing, some have a null value.
     * This is a problem, because if we call get() on a key that isn't present, it returns
     * null, and we need to add checks to protect against NullPointerException.
     * Write code to ensure that all missing keys are mapped to the empty string.
     * You can check the Map.putIfAbsent() method.
     */
    @Test
    @Ignore
    public void j_map02() {

        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");
        map.put("e", null);

        // TODO write code to fix the map

        assertThat(map).hasSize(7);
        assertThat(map)
                .contains(Map.entry("a", "alfa"))
                .contains(Map.entry("b", "bravo"))
                .contains(Map.entry("c", "charlie"))
                .contains(Map.entry("d", "delta"))
                .contains(Map.entry("e", ""))
                .contains(Map.entry("f", ""))
                .contains(Map.entry("g", ""));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.putIfAbsent().
    // </editor-fold>


    /**
     * In the previous example, we added map entries that had a default value.
     * We've now determined that's incorrect, and we want to undo that. This
     * time, we want to remove the entry if the value is the empty string.
     */
    @Test
    @Ignore
    public void j_map03() {

        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");
        map.put("e", "");
        map.put("f", "");
        map.put("g", "");

        // TODO write code to fix the map

        assertThat(map).hasSize(4);
        assertThat(map)
                .contains(Map.entry("a", "alfa"))
                .contains(Map.entry("b", "bravo"))
                .contains(Map.entry("c", "charlie"))
                .contains(Map.entry("d", "delta"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.remove().
    // </editor-fold>

    /**
     * We need another way to deal with the problem of the previous example.
     * Instead of removing entries whose value is the empty string, we want
     * to replace the empty-string values with a value that's the key itself.
     * Write the code to do that.
     */
    @Test
    @Ignore
    public void j_map04() {

        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");
        map.put("e", "");
        map.put("f", "");
        map.put("g", "");

        // TODO write code to fix the map

        assertThat(map).hasSize(7);
        assertThat(map)
                .contains(Map.entry("a", "alfa"))
                .contains(Map.entry("b", "bravo"))
                .contains(Map.entry("c", "charlie"))
                .contains(Map.entry("d", "delta"))
                .contains(Map.entry("e", "e"))
                .contains(Map.entry("f", "f"))
                .contains(Map.entry("g", "g"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.replace().
    // </editor-fold>

    /**
     * We are still dealing with a map with missing entries. For entries that
     * are present, we want to convert the value to upper case; and for keys
     * that are not present, we want to add an entry where the value is the
     * same as the key.
     */
    @Test
    @Ignore
    public void j_map05() {

        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");

        // TODO write code transform the map

        assertThat(map).hasSize(7);
        assertThat(map)
                .contains(Map.entry("a", "ALFA"))
                .contains(Map.entry("b", "BRAVO"))
                .contains(Map.entry("c", "CHARLIE"))
                .contains(Map.entry("d", "DELTA"))
                .contains(Map.entry("e", "e"))
                .contains(Map.entry("f", "f"))
                .contains(Map.entry("g", "g"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.compute().
    // </editor-fold>

    /**
     * The map now has several entries, some with valid values, and some
     * with values that are the empty string. This time, we want to convert
     * the non-empty values to upper case, but we want to remove the entries
     * for which the values are the empty string.
     */
    @Test
    @Ignore
    public void j_map06() {

        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");
        map.put("e", "");
        map.put("f", "");
        map.put("g", "");

        // TODO write code transform the map

        assertThat(map).hasSize(4);
        assertThat(map)
                .contains(Map.entry("a", "ALFA"))
                .contains(Map.entry("b", "BRAVO"))
                .contains(Map.entry("c", "CHARLIE"))
                .contains(Map.entry("d", "DELTA"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.compute().
    // </editor-fold>

    /**
     * Given a list of words, populate a map whose keys are the lengths of
     * each word, and whose values are list of words with that length.
     * You can check the Map.computeIfAbsent() method.
     */
    @Test
    @Ignore
    public void j_map07() {

        List<String> list = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        Map<Integer, List<String>> result = new HashMap<>();

        // TODO write code to populate result

        assertThat(result).hasSize(3);
        assertThat(result).containsKeys(3, 4, 5);
        assertThat(result)
                .contains(Map.entry(3, List.of("one", "two", "six", "ten")))
                .contains(Map.entry(4, List.of("four", "five", "nine")))
                .contains(Map.entry(5, List.of("three", "seven", "eight")));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.computeIfAbsent().
    // </editor-fold>

    /**
     * Given a list of words, populate a map whose keys are the first letter of each
     * word, and whose values are maps of lengths of each word, and list of words with that length.
     * The map should have the form:
     * e -> 5 -> {eight}
     * f -> 4 -> {four, five}
     * s -> 3 -> {six}
     * 5 -> {seven}
     * etc...
     */
    @Test
    @Ignore
    public void j_map08() {

        List<String> list = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        Map<String, Map<Integer, List<String>>> result = new HashMap<>();

        // TODO write code to populate result

        assertThat(result).hasSize(6);
        assertThat(result).containsKeys("e", "f", "n", "o", "s", "t");
        assertThat(result.get("e"))
                .contains(Map.entry(5, List.of("eight")));
        assertThat(result.get("f"))
                .contains(Map.entry(4, List.of("four", "five")));
        assertThat(result.get("n"))
                .contains(Map.entry(4, List.of("nine")));
        assertThat(result.get("o"))
                .contains(Map.entry(3, List.of("one")));
        assertThat(result.get("s"))
                .contains(Map.entry(3, List.of("six")))
                .contains(Map.entry(5, List.of("seven")));
        assertThat(result.get("t"))
                .contains(Map.entry(3, List.of("two", "ten")))
                .contains(Map.entry(5, List.of("three")));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.computeIfAbsent().
    // </editor-fold>

    /**
     * Given a list of words, populate a map whose keys are the lengths of each word, and whose values
     * the concatenation of words with that length, separated by a space.
     */
    @Test
    @Ignore
    public void j_map09() {

        List<String> list = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        Map<Integer, String> result = new HashMap<>();

        // TODO write code to populate result

        assertThat(result).hasSize(3);
        assertThat(result).containsKeys(3, 4, 5);
        assertThat(result)
                .contains(Map.entry(3, "one two six ten"))
                .contains(Map.entry(4, "four five nine"))
                .contains(Map.entry(5, "three seven eight"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.merge().
    // </editor-fold>

    /**
     * Given a list of words, populate a map whose keys are the first letter of each
     * word, and whose values are maps of lengths of each word, and concatenations of words
     * with that length, separated by a space.
     * The map should have the form:
     * e -> 5 -> "eight"
     * f -> 4 -> "four five"
     * s -> 3 -> "six"
     * 5 -> "seven"
     * etc...
     */
    @Test
    @Ignore
    public void j_map10() {

        List<String> list = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        Map<String, Map<Integer, String>> result = new HashMap<>();

        // TODO write code to populate result

        assertThat(result).hasSize(6);
        assertThat(result).containsKeys("e", "f", "n", "o", "s", "t");
        assertThat(result.get("e"))
                .contains(Map.entry(5, "eight"));
        assertThat(result.get("f"))
                .contains(Map.entry(4, "four five"));
        assertThat(result.get("n"))
                .contains(Map.entry(4, "nine"));
        assertThat(result.get("o"))
                .contains(Map.entry(3, "one"));
        assertThat(result.get("s"))
                .contains(Map.entry(3, "six"))
                .contains(Map.entry(5, "seven"));
        assertThat(result.get("t"))
                .contains(Map.entry(3, "two ten"))
                .contains(Map.entry(5, "three"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.computeIfAbsent() and the Map.merge() methods.
    // </editor-fold>

}
