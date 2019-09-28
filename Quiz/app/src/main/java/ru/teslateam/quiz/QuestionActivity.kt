package ru.teslateam.quiz

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.os.Bundle
import android.widget.RadioButton
import kotlinx.android.synthetic.main.quiz_question.*

class QuestionActivity : AppCompatActivity() {

    private var question = QuestionModel()
    var variant = 0

    fun chooseVariant(view: View) {
        when((view as RadioButton).id.toString()) {
            "radioButton1" -> variant = 1
            "radioButton2" -> variant = 2
            "radioButton3" -> variant = 3
        }
        question.switchRound(variant)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_question)
    }
}
