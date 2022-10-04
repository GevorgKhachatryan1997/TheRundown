package com.example.therundown.data.exeptions

import java.lang.Exception

class PlayerLoadExeption(
    message: String? = null,
    exeption: Exception? = null
) : Exception(message, exeption)