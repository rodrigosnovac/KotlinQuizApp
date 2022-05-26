package com.example.quiz

// EVERY QUESTION STRUCTURE
data class Question(
    val id : Int,
    val question : String,
    val image: Int,
    // answers
    val correctAnswer : Int,
    val optionA : String,
    val optionB : String,
    val optionC : String,
    val optionD : String
)
