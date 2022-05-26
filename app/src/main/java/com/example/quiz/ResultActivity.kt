package com.example.quiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //
        // VARIABLES
        //
        val congratulationsText : TextView = findViewById(R.id.congratulationsText)
        val scoreText : TextView = findViewById(R.id.scoreText)
        val finishButton : Button = findViewById(R.id.finishButton)

        val usernameResult : String? = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswers : Int = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestions : Int = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        congratulationsText.text = "Congratulations, $usernameResult"
        scoreText.text = "${correctAnswers}/${totalQuestions}"

        finishButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}