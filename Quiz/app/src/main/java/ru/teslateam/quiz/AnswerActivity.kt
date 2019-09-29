package ru.teslateam.quiz

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.quiz_answer.*
import kotlin.system.exitProcess

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_answer)

        //View

        val resultNum: Int = intent.getIntExtra("result",7)
        textResultNumberAnswer.text = "$resultNum/10"
        when (resultNum) {
            in 1..4 -> textAnswerResult.text="Вы точно шпион далеков"
            in 5..8 -> textAnswerResult.text="Неплохо для компаньона"
            in 9..10 -> textAnswerResult.text="Вы воплощение Доктора?"
        }

        //Controller

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
