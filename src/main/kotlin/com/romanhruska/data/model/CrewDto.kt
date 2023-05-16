package com.romanhruska.alihopa.business

import kotlinx.serialization.Serializable

@Serializable
data class CrewDto(
    val id: String,
    val name: String,
    val description: String
) {
    fun toCrew(): Crew {
        return Crew(
            id = id,
            name = name,
            description = description
        )
    }
    // Nothing special happening there, just mapping via extension function.
}
