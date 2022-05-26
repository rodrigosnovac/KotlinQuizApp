package com.example.quiz

object Constants {

    //
    // CONSTANTS
    //
    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    // STORE ALL QUESTIONS AND RETURN AN ARRAY
    fun getAllQuestions() : ArrayList<Question>{

        val questionsList = ArrayList<Question>()

        val question1 = Question(
            1,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_argentina,
            1,
            "Argentina",
            "Australia",
            "Brazil",
            "United States",
        )
        questionsList.add(question1)

        val question2 = Question(
            2,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_australia,
            2,
            "United Kingdom",
            "Australia",
            "Brazil",
            "United States",
        )
        questionsList.add(question2)

        val question3 = Question(
            3,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_belgium,
            4,
            "France",
            "Germany",
            "Brazil",
            "Belgium",
        )
        questionsList.add(question3)

        val question4 = Question(
            4,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_brazil,
            3,
            "England",
            "Australia",
            "Brazil",
            "United States",
        )
        questionsList.add(question4)

        val question5 = Question(
            5,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_denmark,
            1,
            "Denmark",
            "Australia",
            "Brazil",
            "Fiji",
        )
        questionsList.add(question5)

        val question6 = Question(
            6,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_fiji,
            4,
            "Germany",
            "Argentina",
            "Kuwait",
            "Fiji",
        )
        questionsList.add(question6)

        val question7 = Question(
            7,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_germany,
            3,
            "Belgium",
            "India",
            "Germany",
            "Brazil",
        )
        questionsList.add(question7)

        val question8 = Question(
            8,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_india,
            2,
            "Ireland",
            "India",
            "New Zealand",
            "Belgium",
        )
        questionsList.add(question8)

        val question9 = Question(
            9,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_kuwait,
            2,
            "Iran",
            "Kuwait",
            "New Zealand",
            "Belgium",
        )
        questionsList.add(question9)

        val question10 = Question(
            10,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_new_zealand,
            4,
            "Brazil",
            "Fiji",
            "United Kingdom",
            "New Zealand",
        )
        questionsList.add(question10)

        return questionsList
    }
}