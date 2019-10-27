package ru.teslateam.quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.os.Bundle
import android.os.Handler
import android.widget.RadioButton
import kotlinx.android.synthetic.main.quiz_question.*

import ru.teslateam.quiz.models.QuestionModel
import ru.teslateam.quiz.R

class QuestionActivity : AppCompatActivity() {

    private lateinit var question: QuestionModel

    private fun viewRound() {
        textQuestion.text = question.questionText
        variant1button.text = question.variantOne
        variant2button.text = question.variantTwo
        variant3button.text = question.variantThree
        questionPicture.setImageResource(question.imagePath)
    }

    fun chooseVariant(view: View) {
        when((view as RadioButton).id) {
            variant1button.id -> question.variant = 1
            variant2button.id -> question.variant = 2
            variant3button.id -> question.variant = 3
        }
        question.switchRound()
        Handler().postDelayed({
            view.isChecked = false
            Handler().postDelayed({
                viewRound()
                if (question.modelIf()) {
                    question.roundPlus()
                    val randomIntent = Intent(this, AnswerActivity::class.java)
                    randomIntent.putExtra(AnswerActivity.TOTAL_COUNT, question.results)
                    startActivity(randomIntent)
                    finish()
                }
            }, 200)
        }, 100)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_question)

        question = QuestionModel()
        viewRound()
    }
}
