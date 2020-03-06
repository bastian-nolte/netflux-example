package guru.springframework.netfluxexample.service

import guru.springframework.netfluxexample.domain.Movie
import guru.springframework.netfluxexample.domain.MovieEvent
import guru.springframework.netfluxexample.repositories.MovieRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.*

@Service
class MovieServiceImpl(
        val movieRepository: MovieRepository
) : MovieService {

    override fun events(movieId: String): Flux<MovieEvent> = Flux
            .generate<MovieEvent> { it.next(MovieEvent(movieId, Date())) }
            .delayElements(Duration.ofSeconds(1))

    override fun getMovieById(movieId: String): Mono<Movie> = movieRepository.findById(movieId)

    override fun getAllMovies(): Flux<Movie> = this.movieRepository.findAll()
}
