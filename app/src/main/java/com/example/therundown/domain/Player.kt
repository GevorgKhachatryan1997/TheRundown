package com.example.therundown.domain

import java.io.Serializable

class Player(
    val id: String,
    val firstName: String,
    val team: TeamDto
) : Serializable {

    override fun equals(other: Any?): Boolean {
        return other is Player &&
                other.id == id &&
                other.firstName == firstName &&
                other.team == team
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + firstName.hashCode()
        return result
    }
}