package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
        // VARIABLES
        //
        val startBtn : Button = findViewById(R.id.startBtn)
        val clearBtn : Button = findViewById(R.id.clearBtn)
        val nameField : EditText = findViewById(R.id.nameField)

        // CLEAR BUTTON IMPLEMENTATION
        clearBtn.setOnClickListener{
            nameField.setText("")
        }

        // SEND BUTTON IMPLEMENTATION
        startBtn.setOnClickListener{
            if (nameField.text.isEmpty()){
                Toast.makeText(this, "Oops, insert your name", Toast.LENGTH_LONG).show()
            }else{
                // CHANGE ACTIVITY
                val intent = Intent(
                    this,
                    QuizQuestionsActivity::class.java
                )
                intent.putExtra(Constants.USER_NAME, nameField.text.toString())
                startActivity(intent)
            }
        }
    }
}