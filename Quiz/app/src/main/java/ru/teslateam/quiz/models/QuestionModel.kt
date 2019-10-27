package ru.teslateam.quiz.models

import android.widget.Toast
import com.google.gson.Gson

import ru.teslateam.quiz.R

class QuestionModel {
    private var arrayQuestion = Array(10){0}
    private var arrayAnswer = Array(10){0}
    private var questionStringArray = Array(10){""}
    private var variantsStringArray = Array(30){""}
    private var imageIntArray = Array(10){0}
    var questionText = ""
    var variantOne = ""
    var variantTwo = ""
    var variantThree = ""
    var imagePath = 0
    var round = 0
    var results = 0
    var variant = 0

    init {
        val gson = Gson()
        val inputString = MyApplication.applicationContext().resources.openRawResource(R.raw.doctorwho)
            .bufferedReader().use { it.readText() }
        val quiz = gson.fromJson(inputString, RoundModel::class.java)
        for (i in 0..9) {
            questionStringArray[i] = quiz.data[i].question
            variantsStringArray[i*3] = quiz.data[i].firstVariant
            variantsStringArray[i*3+1] = quiz.data[i].secondVariant
            variantsStringArray[i*3+2] = quiz.data[i].thirdVariant
            imageIntArray[i] = MyApplication.applicationContext().resources
                .getIdentifier("image$i","drawable", MyApplication.applicationContext().packageName)
            arrayAnswer[i] = quiz.data[i].answer
        }
        viewVariants()
    }

    private fun viewVariants() {
        questionText = questionStringArray[round]
        variantOne = variantsStringArray[round*3]
        variantTwo = variantsStringArray[round*3+1]
        variantThree = variantsStringArray[round*3+2]
        imagePath = imageIntArray[round]
    }

    fun modelIf() : Boolean = (round == 10)

    fun roundPlus() = round++

    private fun compareResults() {
        arrayQuestion[round] = variant
        round++
        for(i in 0..9){
            if (arrayQuestion[i] == arrayAnswer[i])
              results++
        }
    }

    private fun ordinaryRound() {
        arrayQuestion[round] = variant
        round++
        viewVariants()
        results = arrayQuestion[round]
    }

    fun switchRound() {
        when (round) {
            in 0..8 -> ordinaryRound()
            9 -> compareResults()
            else -> {
                Toast.makeText(MyApplication.applicationContext(),
                    MyApplication.applicationContext().resources.getString(R.string.Error),
                    Toast.LENGTH_LONG).show()
            }
        }
    }

}