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

package org.paumard.solutions.codeone2019.A_Lambdas.a_lambdas;

import org.junit.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * This set of exercises covers the Consumer and BiConsumer interfaces.
 * Some exercises also cover consumer chaining.
 */
public class B_Consumers {

    /**
     * Write a lambda expression that clears the given list.
     * Try to write this lambda using a method reference.
     */
    @Test
    public void b_consumer01() {

        Consumer<List<String>> cons = List::clear;

        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        cons.accept(list);
        assertTrue(list.isEmpty());
    }

    /**
     * Write a lambda expression that appends the
     * string ")" to the given StringBuilder.
     */
    @Test
    public void b_consumer02() {

        Consumer<StringBuilder> cons = sb -> sb.append(')');

        StringBuilder sb = new StringBuilder("Hello");
        cons.accept(sb);
        assertThat(sb.toString()).isEqualTo("Hello)");
    }

    /**
     * Write a lambda expression that adds the
     * string "(" as the first element of the given StringBuilder.
     */
    @Test
    public void b_consumer03() {

        Consumer<StringBuilder> cons = sb -> sb.insert(0, '(');

        StringBuilder sb = new StringBuilder("Hello");
        cons.accept(sb);
        assertThat(sb.toString()).isEqualTo("(Hello");
    }

    /**
     * Write a lambda expression that adds the
     * string "(" as the first element of the given StringBuilder
     * and the string ")" as the last element of the given StringBuilder.
     * Try to use the consumers written for b_consumer2()
     * and b_consumer3()
     */
    @Test
    public void b_consumer04() {

        Consumer<StringBuilder> cons03 = sb -> sb.append(')');
        Consumer<StringBuilder> cons04 = sb -> sb.insert(0, '(');

        Consumer<StringBuilder> cons = cons03.andThen(cons04);

        StringBuilder sb = new StringBuilder("Hello");
        cons.accept(sb);
        assertThat(sb.toString()).isEqualTo("(Hello)");
    }

    /**
     * Write a lambda expression that adds the given string to the
     * given list. Try to write this lambda as a method reference.
     */
    @Test
    public void b_consumer05() {

        List<String> strings = new ArrayList<>(Arrays.asList("one", "two", "three"));

        BiConsumer<List<String>, String> bicons = List::add;
        bicons.accept(strings, "four");

        assertThat(strings).containsExactly("one", "two", "three", "four");
    }

    /**
     * Write a lambda expression that adds the given key and value to the
     * map. Try to write this lambda as a method reference.
     */
    @Test
    public void b_consumer06() {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        BiConsumer<Integer, String> bicons = map::put;
        bicons.accept(4, "four");

        assertThat(map).containsKeys(1, 2, 3, 4);
        assertThat(map.get(4)).isEqualTo("four");
    }
}
