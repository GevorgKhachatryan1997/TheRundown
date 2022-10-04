package com.example.therundown.data.exeptions

class TeamLoadExeption(
    message: String? = null,
    exeption: Exception? = null
) : Exception(message, exeption)