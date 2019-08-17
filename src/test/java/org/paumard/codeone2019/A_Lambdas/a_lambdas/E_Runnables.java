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

package org.paumard.codeone2019.A_Lambdas.a_lambdas;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This set of exercises covers the Runnable interface.
 */
public class E_Runnables {

    /**
     * Write a lambda expression that appends the string suffix
     * to the sb variable (a StringBuilder).
     */
    @Test
    @Ignore
    public void e_runnable01() {

        StringBuilder sb = new StringBuilder("abc");
        String suffix = "--";

        Runnable r = null; // TODO

        r.run();
        r.run();
        r.run();
        Assertions.assertThat(sb.toString()).isEqualTo("abc------");
    }
}
