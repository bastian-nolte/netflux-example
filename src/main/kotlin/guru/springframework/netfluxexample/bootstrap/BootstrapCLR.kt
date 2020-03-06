package guru.springframework.netfluxexample.bootstrap

import guru.springframework.netfluxexample.domain.Movie
import guru.springframework.netfluxexample.repositories.MovieRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.util.*

@Component
class BootstrapCLR(
        val movieRepository: MovieRepository
) : CommandLineRunner {
    override fun run(vararg args: String?) {

        // Delete existing Data.
        movieRepository
                .deleteAll()
                .thenMany(
                        Flux.just(
                                        "Lock, Stock and two smocking barrels.",
                                        "Panther",
                                        "Machete kills in space again.",
                                        "Super Woman"
                                )
                                .map { title -> Movie(UUID.randomUUID().toString(), title) }
                                .flatMap(movieRepository::save)
                )
                .subscribe(
                        null,
                        null,
                        { movieRepository.findAll().subscribe(::println) })
    }

}
