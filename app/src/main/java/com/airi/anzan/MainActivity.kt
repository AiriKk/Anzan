package com.airi.anzan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rNumber1 = kotlin.random.Random.nextInt(1000)
        val rNumber2 = kotlin.random.Random.nextInt(1000)

        number1.text = rNumber1.toString()
        number2.text = rNumber2.toString()

        val randomOperator = kotlin.random.Random.nextInt(2)
        var operatorText=""
        var correctAnswer = 0

        if(randomOperator == 0){
            operatorText="+"
            sign.text=operatorText
            correctAnswer=rNumber1+rNumber2 }
        else{
            operatorText="-"
            sign.text=operatorText
            correctAnswer=rNumber1-rNumber2 }

        answer.setOnClickListener{
        val yourAnswer = input.text.toString()
        if(yourAnswer.isNotEmpty()){

            val answerPage = Intent(this, AnswerActivity::class.java)
            val questionText = rNumber1.toString() + operatorText + rNumber2.toString() + "="

            answerPage.putExtra("question",questionText)
            answerPage.putExtra("answer",yourAnswer)
            answerPage.putExtra("correct",correctAnswer.toString())

            startActivity(answerPage)
            finish()
        }

        }

    }
}
