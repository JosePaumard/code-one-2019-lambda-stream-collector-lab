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

package org.paumard.codeone2019.D_Challenges.model;

import java.util.HashSet;
import java.util.Set;

public class Movie {
    private String title ;
    private int releaseYear ;
    
    private Set<Actor> actors = new HashSet<>() ;
    
    public Movie(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }
    
    public String title() {
        return this.title ;
    }
    
    public int releaseYear() {
        return this.releaseYear ;
    }
    
    public void addActor(Actor actor) {
        this.actors.add(actor) ;
    }
    
    public Set<Actor> actors() {
        return this.actors ;
    }
    
    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", releaseYear=" + releaseYear + ", actors=" + actors + '}';
    }
}
