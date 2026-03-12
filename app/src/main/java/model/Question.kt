package model

data class Question(
    val statement : String,
    val options : List<String>,
    val correctOptions : String,
    val answer : String,
    val hint : String
)
