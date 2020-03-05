package guru.springframework.netfluxexample.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Movie(
        @Id
        val id: String? = null,
        val title: String
)
