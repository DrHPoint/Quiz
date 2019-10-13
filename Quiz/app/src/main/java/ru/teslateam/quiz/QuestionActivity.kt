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
    private var variant = 0
    private var results = 0
    var imageArray = arrayOf(0,0,0,0,0,0,0,0,0,0)


    //View

    private fun viewRound() {
        question.viewVariants()
        textQuestion.text = question.questionText
        variant1button.text = question.variantOne
        variant2button.text = question.variantTwo
        variant3button.text = question.variantThree
        questionPicture.setImageResource(question.imagePath)
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
                    randomIntent.putExtra(AnswerActivity.TOTAL_COUNT, results)
                    startActivity(randomIntent)
                    exitProcess(-1)
                }
            }, 200)
        }, 100)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_question)

        //Model

        val questionArray: Array<String> = resources.getStringArray(R.array.Questions_array)
        val variantArray: Array<String> = resources.getStringArray(R.array.Variants_array)
        for (i in 0..9) {
            imageArray[i] = resources.getIdentifier("image$i","drawable", getPackageName())
        }

        /*var gson = Gson()
        var mMineUserEntity = gson?.fromJson(response, MineUserEntity.MineUserInfo::class.java)*/

        question.inputArrays(questionArray, variantArray, imageArray)
        viewRound()

    }
}
