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
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers the default method added to the Iterable interface.
 */
public class G_Iterables {

    /**
     * Given a list of StringBuilders, modify each StringBuilder
     * in-place by appending the string "new" to each one.
     */
    @Test
    @Ignore
    public void g_iterable01() {

        List<StringBuilder> sbList = Arrays.asList(
                new StringBuilder("alfa"),
                new StringBuilder("bravo"),
                new StringBuilder("charlie"));

        // TODO write code to modify sbList

        List<String> strings = sbList.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());

        assertThat(strings).hasSize(3);
        assertThat(strings).contains("alfanew", "bravonew", "charlienew");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Check the default methods of java.lang.Iterable.
    // </editor-fold>
}
