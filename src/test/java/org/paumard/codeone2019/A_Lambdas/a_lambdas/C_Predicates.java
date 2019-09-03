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

import org.junit.Ignore;
import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This set of exercises covers the Predicate interface.
 * Some exercises also cover predicate chaining.
 */
public class C_Predicates {

    /**
     * Write a lambda expression that is a predicate
     * that tests whether a string null.
     * Try to write this lambda using a method reference.
     */
    @Test
    @Ignore
    public void c_predicate01() {

        Predicate<String> pred = null; // TODO

        assertTrue(pred.test(null));
        assertFalse(pred.test(""));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // This method reference is to be found in the Objects factory class.
    // You can also pop up the menu over the "light bulb" icon in the left margin. This menu
    // has an option to convert the lambda to a method reference.
    // </editor-fold>

    /**
     * Write a lambda expression that is a predicate
     * that tests whether a string is empty.
     * Try to write this lambda using a method reference.
     */
    @Test
    @Ignore
    public void c_predicate02() {

        Predicate<String> pred = null; // TODO

        assertTrue(pred.test(""));
        assertFalse(pred.test("a"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // You can pop up the menu over the "light bulb" icon in the left margin. This menu
    // has an option to convert the lambda to a method reference.
    // </editor-fold>

    /**
     * Create a predicate that returns true when the given String
     * is non-null.
     */
    @Test
    @Ignore
    public void c_predicate03() {

        Predicate<String> pred = null; // TODO

        assertTrue(pred.test(""));
        assertFalse(pred.test(null));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // see the factory methods from the Objects class and try to write the solution as a method reference.
    // </editor-fold>

    /**
     * Create a predicate that returns true when the given String
     * is null or empty. Try to use the predicates you wrote
     * for c_predicate01() and c_predicate02()
     */
    @Test
    @Ignore
    public void c_predicate04() {

        Predicate<String> pred = null; // TODO

        assertTrue(pred.test(""));
        assertTrue(pred.test(null));
        assertFalse(pred.test("Hello"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // see java.util.function.Predicate.or()
    // </editor-fold>

    /**
     * Create a predicate that returns true when the given String
     * is non-null and non-empty. You can use the predicates you
     * wrote for c_predicate01() and c_predicate02(), and the one
     * you wrote for c_predicate04()
     */
    @Test
    @Ignore
    public void c_predicate05() {

        Predicate<String> pred = null; // TODO

        assertFalse(pred.test(""));
        assertFalse(pred.test(null));
        assertTrue(pred.test("Hello"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // see java.util.function.Predicate.or() and java.util.function.Predicate.negate()
    // </editor-fold>

    /**
     * Write a lambda expression that is a predicate
     * that tests whether a string is shorter than four characters.
     */
    @Test
    @Ignore
    public void c_predicate06() {

        Predicate<String> pred = null; // TODO

        assertTrue(pred.test("abc"));
        assertFalse(pred.test("abcd"));
        assertFalse(pred.test("abcde"));
    }

    /**
     * Create a predicate that is true if the provided string equals ERROR.
     * Try writing it using a method reference.
     */
    @Test
    @Ignore
    public void c_predicate07() {

        Predicate<String> equalsError = null; // TODO

        assertFalse(equalsError.test("Hello"));
        assertTrue(equalsError.test("ERROR"));
        assertFalse(equalsError.test(null));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // You can pop up the menu over the "light bulb" icon in the left margin. This menu
    // has an option to convert the lambda to a method reference.
    // </editor-fold>

    /**
     * Create a predicate that is true if the provided string is different from ERROR.
     * Try writing it using the previous predicate.
     */
    @Test
    public void c_predicate08() {

        Predicate<String> nonEqualsError = null; // TODO

        assertTrue(nonEqualsError.test("Hello"));
        assertFalse(nonEqualsError.test("ERROR"));
        assertTrue(nonEqualsError.test(null));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Check the default methods of the Predicate interface.
    // </editor-fold>
}
