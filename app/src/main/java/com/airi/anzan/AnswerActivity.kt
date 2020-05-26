package com.airi.anzan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_answer.*
import java.util.*

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val displayQuestion = intent.getStringExtra("question")
        val yourAnswer = intent.getStringExtra("answer")
        val correctAnswer = intent.getStringExtra("correct")

        question.text = displayQuestion
        answer.text = yourAnswer

        if(yourAnswer == correctAnswer){
            judgement.setImageResource(R.drawable.correct_image)
            randy.setImageResource(R.drawable.randy_happy_image)
        }
        else {
            judgement.setImageResource(R.drawable.miss_image)
            randy.setImageResource(R.drawable.randy_sad_image)
        }
            back.setOnClickListener {
                val questionPage = Intent(this,MainActivity::class.java)
                startActivity(questionPage)
                finish()
            }
    }
}