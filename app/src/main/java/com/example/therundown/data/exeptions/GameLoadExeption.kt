package com.example.therundown.data.exeptions

class GameLoadExeption(
    message: String? = null,
    exeption: Exception? = null
) : Exception(message, exeption)