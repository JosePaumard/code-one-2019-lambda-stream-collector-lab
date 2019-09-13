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

package org.paumard.solutions.codeone2019.F_Challenges;

import org.junit.Before;
import org.junit.Test;
import org.paumard.codeone2019.F_Challenges.model.Actor;
import org.paumard.codeone2019.F_Challenges.model.Movie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * In this challenge, you are going to analyze a database of movies. Each movies has several properties:
 * a release year, a title, and the set of the actors that played in that movie. An Actor has a first name
 * and a last name. There are almost 14k movies in the base and 170k actors.
 * <p/>
 * You can check the Movie class and the Actor class for more information.
 */
public class ActorsAndMoviesChallenge {

    private Set<Movie> movies;


    /**
     * This first test is free and is only here to make sure that everything is ok with the data files.
     */
    @Test
    public void actorsAndMovies00() {

        assertThat(movies).hasSize(13891);
    }

    /**
     * From the set of movies, it should not be too hard to count the number of actors.
     */
    @Test
    public void actorsAndMovies01() {

        long numberOfActors = movies.stream().flatMap(movie -> movie.actors().stream()).distinct().count();

        assertThat(numberOfActors).isEqualTo(168727L);
    }

    /**
     * First, count the number of release years in this file.
     */
    @Test
    public void actorsAndMovies02() {

        long numberOfRelaseYears = movies.stream().map(Movie::releaseYear).distinct().count();

        assertThat(numberOfRelaseYears).isEqualTo(76L);
    }

    /**
     * Second, find the earliest year and the last year in this file.
     * Try to do it in one pass over the data.
     */
    @Test
    public void actorsAndMovies03() {

        IntSummaryStatistics statistics = movies.stream().mapToInt(Movie::releaseYear).summaryStatistics();

        int firstYear = statistics.getMin();
        int lastYear = statistics.getMax();

        assertThat(firstYear).isEqualTo(1916);
        assertThat(lastYear).isEqualTo(2004);
    }

    /**
     * Third, find the year that saw the greatest number of released movies, along
     * with the number of movie released.
     */
    @Test
    public void actorsAndMovies04() {

        Map.Entry<Integer, Long> numberOfMoviesPerYear =
                movies.stream().collect(Collectors.groupingBy(
                        Movie::releaseYear, Collectors.counting()
                ))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .get();

        int year = numberOfMoviesPerYear.getKey();
        long numberOfMovies = numberOfMoviesPerYear.getValue();

        assertThat(year).isEqualTo(1997);
        assertThat(numberOfMovies).isEqualTo(678L);
    }

    /**
     * Fourth, find the movie with the greatest number of actors in it. Hint: there is only one.
     */
    @Test
    public void actorsAndMovies05() {

        Movie movieWithMostActors =
                movies.stream().max(Comparator.comparing(movie -> movie.actors().size())).get();

        int maxNumberOfActors = movieWithMostActors.actors().size();
        String title = movieWithMostActors.title();

        assertThat(maxNumberOfActors).isEqualTo(238);
        assertThat(title).isEqualTo("Malcolm X");
    }

    /**
     * Then, find the actor that played in the greatest number of movies.
     */
    @Test
    public void actorsAndMovies06() {

        Map.Entry<Actor, Long> actorPerMovie =
                movies.stream().flatMap(movie -> movie.actors().stream())
                        .collect(Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        ))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .get();

        Actor mostSeenActor = actorPerMovie.getKey();
        long numberOfMoviePlayed = actorPerMovie.getValue();

        assertThat(mostSeenActor).isEqualTo(new Actor("Welker", "Frank"));
        assertThat(numberOfMoviePlayed).isEqualTo(90L);
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
    public void actorsAndMovies08() {

        Comparator<Actor> cmpActor = Comparator.comparing(Actor::lastName).thenComparing(Actor::firstName);

        BiFunction<Movie, Actor, Stream<Map.Entry<Actor, Actor>>> mapper =
                (movie, actor1) -> movie.actors().stream()
                        .filter(actor2 -> cmpActor.compare(actor1, actor2) < 0)
                        .map(actor2 -> new AbstractMap.SimpleEntry<>(actor1, actor2));

        Function<Movie, Stream<Map.Entry<Actor, Actor>>> movieToActors =
                movie -> movie.actors().stream()
                        .flatMap(actor -> mapper.apply(movie, actor));

        long totalNumberOfPairs =
                movies.stream()
                        .flatMap(movieToActors)
                        .count();

        long numberOfUniquePairs =
                movies.stream()
                        .flatMap(movieToActors)
                        .distinct()
                        .count();

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
    public void actorsAndMovies09() {

        Comparator<Actor> cmpActor = Comparator.comparing(Actor::lastName).thenComparing(Actor::firstName);

        BiFunction<Movie, Actor, Stream<Map.Entry<Actor, Actor>>> mapper =
                (movie, actor1) -> movie.actors().stream()
                        .filter(actor2 -> cmpActor.compare(actor1, actor2) < 0)
                        .map(actor2 -> new AbstractMap.SimpleEntry<>(actor1, actor2));

        Function<Movie, Stream<Map.Entry<Actor, Actor>>> movieToActors =
                movie -> movie.actors().stream()
                        .flatMap(actor -> mapper.apply(movie, actor));

        Map.Entry<Map.Entry<Actor, Actor>, Long> entry =
                movies.stream()
                        .flatMap(movieToActors)
                        .collect(Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        ))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .get();

        long number = entry.getValue();
        Actor actor1 = entry.getKey().getKey();
        Actor actor2 = entry.getKey().getValue();

        assertThat(number).isEqualTo(15L);
        assertThat(actor1).isEqualTo(new Actor("Howard", "Clint"));
        assertThat(actor2).isEqualTo(new Actor("Howard", "Rance"));
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
