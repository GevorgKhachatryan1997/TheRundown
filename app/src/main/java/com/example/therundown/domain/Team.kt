package com.example.therundown.domain

import java.io.Serializable

class Team(
    val id: String? = null,
    val name: String? = null,
    val fullName: String? = null,
    val abbreviation: String? = null,
    val city: String? = null,
    val conference: String? = null,
    val division: String? = null
) : Serializable {

    override fun equals(other: Any?): Boolean {
        return other is Team &&
                other.id == id &&
                other.name == name &&
                other.fullName == fullName &&
                other.abbreviation == abbreviation &&
                other.city == city &&
                other.conference == conference &&
                other.division == division
    }
}