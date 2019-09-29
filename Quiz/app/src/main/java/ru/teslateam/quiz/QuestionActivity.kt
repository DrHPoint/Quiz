package ru.teslateam.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.os.Bundle
import android.os.Handler
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.quiz_question.*
import kotlin.system.exitProcess

class QuestionActivity : AppCompatActivity() {

    private var question = QuestionModel()
    var variant = 0
    var results = 0

    //View

    fun viewRound() {
        question.viewVariants()
        textQuestion.text = question.questionText
        variant1button.text = question.variantOne
        variant2button.text = question.variantTwo
        variant3button.text = question.variantThree
        when (question.round) {
            0 -> questionPicture.setImageResource(R.drawable.dalek)
            1 -> questionPicture.setImageResource(R.drawable.elevendoctor)
            2 -> questionPicture.setImageResource(R.drawable.riversong)
            3 -> questionPicture.setImageResource(R.drawable.cryingangel)
            4 -> questionPicture.setImageResource(R.drawable.moffat)
            5 -> questionPicture.setImageResource(R.drawable.doctorwho)
            6 -> questionPicture.setImageResource(R.drawable.compainion)
            7 -> questionPicture.setImageResource(R.drawable.daugter)
            8 -> questionPicture.setImageResource(R.drawable.death)
            9 -> questionPicture.setImageResource(R.drawable.twelvedoctorwho)
        }
    }

    //Controller

    fun chooseVariant(view: View) {
        when((view as RadioButton).id) {
            variant1button.id -> variant = 1
            variant2button.id -> variant = 2
            variant3button.id -> variant = 3
        }
        question.switchRound(variant)
        Handler().postDelayed({
            variant1button.isChecked = false
            variant2button.isChecked = false
            variant3button.isChecked = false
            Handler().postDelayed({
                if (question.round < 10) {viewRound()}
                results = question.results
                if (question.round == 10) {
                    val randomIntent = Intent(this, AnswerActivity::class.java)
                    randomIntent.putExtra("result", results)
                    startActivity(randomIntent)
                    exitProcess(-1)
                }
            }, 200)
        }, 100)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_question)

        //Controller

        val rist: String = getString(R.string.Varr)
        val questionArray: Array<String> = resources.getStringArray(R.array.Questions_array)
        val variantArray: Array<String> = resources.getStringArray(R.array.Variants_array)

        question.inputArrays(questionArray, variantArray)
        viewRound()

    }
}
