package ru.teslateam.quiz

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.quiz_answer.*
import kotlin.system.exitProcess

class AnswerActivity : AppCompatActivity() {

    val TOTAL_COUNT = "total_count"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_answer)

        val resultNum: Int = intent.getIntExtra("result",7)
        textResultNumberAnswer.text = "$resultNum/10"

        val newIntent = Intent(this, QuestionActivity::class.java)


        buttonReStart.setOnClickListener{
            startActivity(newIntent)
        }

        buttonFinalExit.setOnClickListener {
            moveTaskToBack(true)
            exitProcess(-1)
        }

    }
}
