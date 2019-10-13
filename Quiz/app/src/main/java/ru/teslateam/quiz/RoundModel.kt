package ru.teslateam.quiz

class RoundModel {

    data class MineUserInfo(
        val data: Array<Data>
    )

    data class Data(
        val question: String,
        val firstVariant: String,
        val secondVariant: String,
        val thirdVariant: String,
        val answer: String
    )
}