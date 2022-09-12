package com.example.therundown.domain

class Player(val id: String, val lastName: String) {

    override fun equals(other: Any?): Boolean {
        return other is Player &&
                other.id == id &&
                other.lastName == lastName
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + lastName.hashCode()
        return result
    }
}