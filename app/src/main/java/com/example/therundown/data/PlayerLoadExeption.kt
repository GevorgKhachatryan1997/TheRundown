package com.example.therundown.data

import java.lang.Exception

class PlayerLoadExeption(
    override val message: String? = null,
    exeption: Exception? = null
) : Exception(message, exeption)