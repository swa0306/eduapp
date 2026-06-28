package com.example.edu.models

data class QuestionModel(
    val question: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val correctAnswer: Int,
    var selectedAnswer: Int = -1
)