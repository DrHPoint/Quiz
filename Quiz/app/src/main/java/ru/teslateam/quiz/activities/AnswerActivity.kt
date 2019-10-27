package ru.teslateam.quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.quiz_answer.*
import ru.teslateam.quiz.R

class AnswerActivity : AppCompatActivity() {

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_answer)

        val resultNum: Int = intent.getIntExtra(TOTAL_COUNT,7)
        val resultArray: Array<String> = resources.getStringArray(R.array.Result_array)
        var dialogResult: String = resultArray[resultNum / 4]

        textResultNumberAnswer.text = resultNum.toString() + resources.getString(R.string.ResultPlusNum)
        textAnswerResult.text = dialogResult

        buttonReStart.setOnClickListener{
            val newIntent = Intent(this, QuestionActivity::class.java)
            startActivity(newIntent)
            finish()
        }

        buttonFinalExit.setOnClickListener {
            finish()
        }

    }
}
