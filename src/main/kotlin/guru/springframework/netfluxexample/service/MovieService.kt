package guru.springframework.netfluxexample.service

import guru.springframework.netfluxexample.domain.Movie
import guru.springframework.netfluxexample.domain.MovieEvent
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MovieService {
    /**
     * Generate a stream of movie events for given movie id.
     *
     * @param movieId: The unique identifier of the movie.
     * @return The reactive stream of movie events.
     */
    fun events(movieId: String): Flux<MovieEvent>

    /**
     * Get movie by id.
     *
     * @param movieId: The unique identifier of the movie.
     * @return The reactive stream with the movie.
     */
    fun getMovieById(movieId: String): Mono<Movie>

    /**
     * Get stream of all movies.
     *
     * @return The reactive stream of movies.
     */
    fun getAllMovies(): Flux<Movie>
}
