package guru.springframework.netfluxexample.repositories

import guru.springframework.netfluxexample.domain.Movie
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface MovieRepository: ReactiveMongoRepository<Movie, String>
