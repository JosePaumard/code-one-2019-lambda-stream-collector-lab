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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers the default method added to the Collection interface.
 */
public class H_Collections {

    /**
     * Remove the words that have odd lengths from the list.
     */
    @Test
    @Ignore
    public void h_collection01() {

        List<String> list = new ArrayList<>(Arrays.asList(
                "alfa", "bravo", "charlie", "delta", "echo", "foxtrot"));

        // TODO write code to modify list

        assertThat(list).hasSize(2);
        assertThat(list).contains("alfa", "echo");
    }
    /* Hint:
     * Check the default methods of java.util.Collection.
     */
}
