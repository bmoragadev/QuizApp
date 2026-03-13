package model

data class Question(
    val statement : String,
    val options : List<String>,
    val correctOption : String,
    val hint : String
)
