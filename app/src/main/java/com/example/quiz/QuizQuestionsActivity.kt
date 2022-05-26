package com.example.quiz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    //
    // VARIABLES
    //
    private var myCurrentPosition : Int = 1
    private var myQuestionsList : ArrayList<Question>? = null
    private var mySelectedOption : Int = 0
    //// putExtra() stuff
    private var myUserName : String? = null
    private var myCorrectAnswers : Int = 0
    //// layout elements
    private var progressBar : ProgressBar? = null
    private var progressText : TextView? = null
    private var questionTitle : TextView? = null
    private var flagImage : ImageView? = null
    private var submitBtn : Button? = null
    //// options
    private var optionA : TextView? = null
    private var optionB : TextView? = null
    private var optionC : TextView? = null
    private var optionD : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        //
        // VARIABLES
        //
        progressBar = findViewById(R.id.progressBar)
        progressText = findViewById(R.id.progressNum)
        questionTitle = findViewById(R.id.questionTitle)
        flagImage = findViewById(R.id.flagImage)
        submitBtn = findViewById(R.id.submitButton)
        //// from MainActivity
        myUserName = intent.getStringExtra(Constants.USER_NAME)
        //// options
        optionA = findViewById(R.id.optionA)
        optionB = findViewById(R.id.optionB)
        optionC = findViewById(R.id.optionC)
        optionD = findViewById(R.id.optionD)

        // onClickListener
        optionA?.setOnClickListener(this)
        optionB?.setOnClickListener(this)
        optionC?.setOnClickListener(this)
        optionD?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)


        myQuestionsList = Constants.getAllQuestions()
        setQuestion()
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        val question : Question = myQuestionsList!![myCurrentPosition - 1] // !! = make sure it wont be empty
        // set options
        defaultOptionsView()

        if (myCurrentPosition == myQuestionsList!!.size){
            submitBtn?.text = "Finish"
        }else{
            submitBtn?.text = "Submit"
        }

        // set progress bar
        progressBar?.progress = myCurrentPosition
        progressText?.text = "${myCurrentPosition}/${myQuestionsList!!.size}"
        // set question
        questionTitle?.text = question.question
        flagImage?.setImageResource(question.image)
        optionA?.text = question.optionA
        optionB?.text = question.optionB
        optionC?.text = question.optionC
        optionD?.text = question.optionD
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        optionA?.let{
            options.add(0, it)
        }
        optionB?.let{
            options.add(1, it)
        }
        optionC?.let{
            options.add(2, it)
        }
        optionD?.let{
            options.add(3, it)
        }

        for (option in options) {
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        when (view?.id){
            R.id.optionA -> {
                optionA?.let{
                    selectedOptionView(it, 1)
                }
            }
            R.id.optionB -> {
                optionB?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.optionC -> {
                optionC?.let{
                    selectedOptionView(it, 3)
                }
            }
            R.id.optionD -> {
                optionD?.let{
                    selectedOptionView(it, 4)
                }
            }
            R.id.submitButton -> {
                if (mySelectedOption == 0) {
                    myCurrentPosition++
                    when{
                        myCurrentPosition <= myQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(
                                this@QuizQuestionsActivity,
                                ResultActivity::class.java
                            )
                            intent.putExtra(Constants.USER_NAME, myUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, myCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, myQuestionsList?.size)
                            // finish game
                            startActivity(intent)
                            finish()
                        }
                    }
                }else {
                    val question = myQuestionsList?.get(myCurrentPosition - 1)

                    // if wrong option
                    if (mySelectedOption != question!!.correctAnswer) {
                        answerView(mySelectedOption, R.drawable.wrong_option_border_bg)
                    }else{
                        myCorrectAnswers++
                    }
                    // show correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (myCurrentPosition == myQuestionsList!!.size){
                        submitBtn?.text = "Finish"
                    }else{
                        submitBtn?.text = "Next Question"
                    }

                    mySelectedOption = 0
                }
            }
        }
    }

    private fun selectedOptionView(tv : TextView, selectedOptionNum : Int){

        // set default border to not clicked options
        defaultOptionsView()

        mySelectedOption = selectedOptionNum

        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    private fun answerView(answer : Int, drawableView : Int){
        when (answer){
            1 -> {
                optionA?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                optionB?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                optionC?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                optionD?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}
