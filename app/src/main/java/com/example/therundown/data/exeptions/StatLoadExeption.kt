package com.example.therundown.data.exeptions

class StatLoadExeption(
    message: String? = null,
    exeption: Exception? = null
) : Exception(message, exeption)