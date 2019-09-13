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

package org.paumard.codeone2019.F_Challenges;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.paumard.codeone2019.F_Challenges.model.Actor;
import org.paumard.codeone2019.F_Challenges.model.Movie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * In this challenge, you are going to analyze a database of movies. Each movies has several properties:
 * a release year, a title, and the set of the actors that played in that movie. An Actor has a first name
 * and a last name. There are almost 14k movies in the base.
 * <p/>
 * You can check the Movie class and the Actor class for more information.
 */
public class ActorsAndMoviesChallenge {

    private Set<Movie> movies;


    /**
     * This first test is free and is only here to make sure that everything is ok with the data files.
     */
    @Test
    @Ignore
    public void actorsAndMovies00() {

        assertThat(movies).hasSize(13891);
    }

    /**
     * From the set of movies, it should not be too hard to count the number of actors.
     */
    @Test
    @Ignore
    public void actorsAndMovies01() {

        long numberOfActors = 0L; // TODO

        assertThat(numberOfActors).isEqualTo(168727L);
    }

    /**
     * First, count the number of release years in this file.
     */
    @Test
    @Ignore
    public void actorsAndMovies02() {

        long numberOfRelaseYears = 0L; // TODO

        assertThat(numberOfRelaseYears).isEqualTo(76L);
    }

    /**
     * Second, find the earliest year and the last year in this file.
     * Try to do it in one pass over the data.
     */
    @Test
    @Ignore
    public void actorsAndMovies03() {

        int firstYear = 0; // TODO
        int lastYear = 0; // TODO

        assertThat(firstYear).isEqualTo(1916);
        assertThat(lastYear).isEqualTo(2004);
    }

    /**
     * Third, find the year that saw the greatest number of released movies, along
     * with the number of movie released.
     */
    @Test
    @Ignore
    public void actorsAndMovies04() {

        int year = 0; // TODO
        long numberOfMovies = 0L; // TODO

        assertThat(year).isEqualTo(1997);
        assertThat(numberOfMovies).isEqualTo(678L);
    }

    /**
     * Fourth, find the movie with the greatest number of actors in it. Hint: there is only one.
     */
    @Test
    @Ignore
    public void actorsAndMovies05() {

        int maxNumberOfActors = 0; // TODO
        String title = null; // TODO

        assertThat(maxNumberOfActors).isEqualTo(238);
        assertThat(title).isEqualTo("Malcolm X");
    }

    /**
     * Then, find the actor that played in the greatest number of movies.
     */
    @Test
    @Ignore
    public void actorsAndMovies06() {

        Actor mostSeenActor = null; // TODO
        long numberOfMoviePlayed = 0L; // TODO

        assertThat(mostSeenActor).isEqualTo(new Actor("Welker", "Frank"));
        assertThat(numberOfMoviePlayed).isEqualTo(90L);
    }

    /**
     * A little harder: try to find the actor that played in the greatest number of movies
     * during a year.
     * <p/>
     * This question is for Java 9 and later. You are on the Java 8 branch, so if you want to work on it,
     * you should checkout another branch of this lab.
     */
    @Test
    @Ignore
    public void actorsAndMovies07() {
    }

    /**
     * Create now a stream of Map.Entry&lt;Actor, Actor> with all the actors that played together. Since we want
     * unique pairs, you should make sure that in a pair, the actors are ordered alphabetically. That is, the following
     * stream:
     * <p/>
     * A B C D
     * <p/>
     * should generate the following stream of pairs:
     * <p/>
     * {A, B} {A, C} {A, D} {B, C} {B, D} {C, D}
     * <p/>
     * You may find useful to create a Comparator of Actors to achieve that.
     * <p/>
     * What is the total number of such pairs? What is the number of unique pairs?
     */
    @Test
    @Ignore
    public void actorsAndMovies08() {

        long totalNumberOfPairs = 0L; // TODO
        long numberOfUniquePairs = 0L; // TODO

        assertThat(totalNumberOfPairs).isEqualTo(7616029L);
        assertThat(numberOfUniquePairs).isEqualTo(7487873L);
    }

    /**
     * The (almost) last step is to find the two actors that played the most together. Look carefully at the code
     * you are writing. Since there are 170k actors in the base, that could make 14 billions of potential couples.
     * You clearly do not want to compute that!
     * <p/>
     * You may use the stream you create in the previous step.
     */
    @Test
    @Ignore
    public void actorsAndMovies09() {

        long number = 0L;
        Actor actor1 = null; // TODO
        Actor actor2 = null; // TODO

        assertThat(number).isEqualTo(15L);
        assertThat(actor1).isEqualTo(new Actor("Howard", "Clint"));
        assertThat(actor2).isEqualTo(new Actor("Howard", "Rance"));
    }

    /**
     * The (real) last step is to find the two actors that played the most together during a year. The approach is the
     * same as previously: try to create a collector and use it as a downstream collector.
     * <p/>
     * This question is for Java 9 and later. You are on the Java 8 branch, so if you want to work on it,
     * you should checkout another branch of this lab.
     */
    @Test
    @Ignore
    public void actorsAndMovies10() {
    }


// ========================================================
// END OF EXERCISES
// TEST INFRASTRUCTURE IS BELOW
// ========================================================

    @Before
    public void z_setupData() {

        Function<String, Stream<Movie>> toMovie =
                line -> {
                    String[] elements = line.split("/");
                    String title = elements[0].substring(0, elements[0].lastIndexOf("(")).trim();
                    String releaseYear = elements[0].substring(elements[0].lastIndexOf("(") + 1, elements[0].lastIndexOf(")"));
                    if (releaseYear.contains(",")) {
                        // Movies with a coma in their title are discarded
                        return Stream.empty();
                    }
                    Movie movie = new Movie(title, Integer.valueOf(releaseYear));


                    for (int i = 1; i < elements.length; i++) {
                        String[] name = elements[i].split(", ");
                        String lastName = name[0].trim();
                        String firstName = "";
                        if (name.length > 1) {
                            firstName = name[1].trim();
                        }

                        Actor actor = new Actor(lastName, firstName);
                        movie.addActor(actor);
                    }
                    return Stream.of(movie);
                };

        try (FileInputStream fis = new FileInputStream("files/movies/movies-mpaa.txt.gz");
             GZIPInputStream gzis = new GZIPInputStream(fis);
             InputStreamReader reader = new InputStreamReader(gzis);
             BufferedReader bufferedReader = new BufferedReader(reader);
             Stream<String> lines = bufferedReader.lines();
        ) {

            movies = lines.flatMap(toMovie).collect(Collectors.toSet());

        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}
