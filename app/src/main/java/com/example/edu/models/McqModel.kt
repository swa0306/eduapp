package com.example.edu.models

data class McqModel(
    val question: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctAnswer: Int
)