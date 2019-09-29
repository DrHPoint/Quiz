package ru.teslateam.quiz

class QuestionModel {
    var questionText = ""
    var variantOne = ""
    var variantTwo = ""
    var variantThree = ""
    var round = 0
    var imagepath = ""
    var arrayQuestion = arrayOf(0,0,0,0,0,0,0,0,0,0)
    var arrayAnswer = arrayOf(2,3,1,3,2,1,3,1,3,2)
    var results = 0
    var questionStringArray = arrayOf<String>("0")
    var variantsStringArray = arrayOf<String>("0")

    fun inputArrays(a: Array<String>, b: Array<String>) {
        questionStringArray = a
        variantsStringArray = b
    }

    fun compareResults(x: Int) {
        arrayQuestion[round] = x
        round++
        for(i in 0..9){
            if (arrayQuestion[i] == arrayAnswer[i])
              results++
        }
    }

    fun viewVariants() {
        questionText = questionStringArray[round]
        variantOne = variantsStringArray[round*3]
        variantTwo = variantsStringArray[round*3+1]
        variantThree = variantsStringArray[round*3+2]
    }

    fun ordinaryRound(x: Int) {
        arrayQuestion[round] = x
        round++
        viewVariants()
        results = arrayQuestion[round]

    }

    fun switchRound(x: Int) {
        when (round) {
            in 0..8 -> ordinaryRound(x)
            9 -> compareResults(x)
        }
    }

}