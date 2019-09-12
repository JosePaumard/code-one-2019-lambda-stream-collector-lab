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

package org.paumard.codeone2019.F_Challenges.model;

import java.util.Objects;

public class Actor {
    public String lastName, firstName ;
    
    public Actor(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    public String lastName() {
        return this.lastName ;
    }
    
    public String firstName() {
        return this.firstName ;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.lastName);
        hash = 67 * hash + Objects.hashCode(this.firstName);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actor other = (Actor) obj;
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return Objects.equals(this.firstName, other.firstName);
    }
    
    @Override
    public String toString() {
        return "Actor{" + "lastName=" + lastName + ", firstName=" + firstName + '}';
    }
}
