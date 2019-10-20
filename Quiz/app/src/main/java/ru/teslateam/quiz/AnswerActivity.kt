package ru.teslateam.quiz

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.quiz_answer.*
import kotlin.system.exitProcess

class AnswerActivity : AppCompatActivity() {

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_answer)

        //Model

        val resultNum: Int = intent.getIntExtra(TOTAL_COUNT,7)
        val resultArray: Array<String> = resources.getStringArray(R.array.Result_array)
        var dialogResult: String = resultArray[resultNum / 4]

        //View

        textResultNumberAnswer.text = "$resultNum/10"
        textAnswerResult.text = dialogResult

        //Controller

        val newIntent = Intent(this, QuestionActivity::class.java)

        buttonReStart.setOnClickListener{
            startActivity(newIntent)
            finish()
        }

        buttonFinalExit.setOnClickListener {
            //moveTaskToBack(true)
            finish()
        }

    }
}
