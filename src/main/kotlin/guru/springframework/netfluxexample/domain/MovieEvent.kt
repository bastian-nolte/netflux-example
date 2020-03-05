package guru.springframework.netfluxexample.domain

import java.util.*

data class MovieEvent(
        val movieId: String,
        val date: Date
)
