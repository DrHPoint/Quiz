package ru.teslateam.quiz

class RoundModel (
    var data: List<Data>
)

class Data(
    var question: String,
    var firstVariant: String,
    var secondVariant: String,
    var thirdVariant: String,
    var answer: Int
)