package ru.teslateam.quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.teslateam.quiz.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Controller

        buttonStart.setOnClickListener{
            val newIntent = Intent(this, QuestionActivity::class.java)
            startActivity(newIntent)
            finish()
        }

        buttonExit.setOnClickListener{
           finish()
        }


    }
}
