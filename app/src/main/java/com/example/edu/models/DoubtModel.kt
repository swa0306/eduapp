package com.example.edu.models

data class DoubtModel(

    val title: String,
    val description: String,
    val status: String = "Pending"
)