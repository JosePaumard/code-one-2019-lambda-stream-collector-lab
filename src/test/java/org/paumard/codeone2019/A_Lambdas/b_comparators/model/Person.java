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

package org.paumard.codeone2019.A_Lambdas.b_comparators.model;

public class Person implements Comparable<Person> {

    private String lastName;
    private String firstName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        int compareByLastName = lastName.compareTo(other.lastName);
        if (compareByLastName == 0) {
            int compareByFirstName = firstName.compareTo(other.firstName);
            if (compareByFirstName == 0) {
                return Integer.compare(age, other.age);
            } else {
                return compareByFirstName;
            }
        } else {
            return compareByLastName;
        }
    }
}
