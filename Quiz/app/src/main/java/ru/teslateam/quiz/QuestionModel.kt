package ru.teslateam.quiz

class QuestionModel {
    var variantOne = ""
    var variantTwo = ""
    var variantThree = ""
    var round = 0
    var imagepath = ""
    var arrayQuestion = arrayOf(0,0,0,0,0,0,0,0,0,0)
    var arrayAnswer = arrayOf(1,1,1,1,1,1,1,1,1,1)
    var results = 0

    fun compareResults() {
        for(i in 0..9){
            if (arrayQuestion[i] == arrayAnswer[i])
                results++
        }
    }

    fun OrdinaryRound(x: Int) {
        arrayQuestion[round] = x
        
    }

    fun switchRound(x: Int) {
        when (round) {
            in 0..9 -> OrdinaryRound(x)
            10 -> compareResults()
        }
    }

}