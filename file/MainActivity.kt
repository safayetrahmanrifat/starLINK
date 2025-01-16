package com.example.quizapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Questions, options, and answers
    private val questions = arrayOf(
        "What is the capital of France?",
        "What is 2 + 2?",
        "Who wrote 'Hamlet'?",
        "What is the largest planet in our solar system?"
    )

    private val options = arrayOf(
        arrayOf("Berlin", "Madrid", "Paris", "Rome"),
        arrayOf("3", "4", "5", "6"),
        arrayOf("Shakespeare", "Hemingway", "Dickens", "Tolkien"),
        arrayOf("Earth", "Mars", "Jupiter", "Saturn")
    )

    private val answers = arrayOf("Paris", "4", "Shakespeare", "Jupiter")

    private var currentQuestionIndex = 0
    private var score = 0
    private var rewards = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI elements
        val questionText: TextView = findViewById(R.id.questionText)
        val option1: Button = findViewById(R.id.option1)
        val option2: Button = findViewById(R.id.option2)
        val option3: Button = findViewById(R.id.option3)
        val option4: Button = findViewById(R.id.option4)
        val scoreText: TextView = findViewById(R.id.scoreText)
        val rewardsText: TextView = findViewById(R.id.rewardsText)

        // Function to load a question
        fun loadQuestion() {
            questionText.text = questions[currentQuestionIndex]
            option1.text = options[currentQuestionIndex][0]
            option2.text = options[currentQuestionIndex][1]
            option3.text = options[currentQuestionIndex][2]
            option4.text = options[currentQuestionIndex][3]
        }

        // Function to check the answer
        fun checkAnswer(selectedOption: String) {
            if (selectedOption == answers[currentQuestionIndex]) {
                score += 10
                rewards += 5
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show()
            }

            scoreText.text = "Score: $score"
            rewardsText.text = "Coins: $rewards"

            // Load the next question
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                loadQuestion()
            } else {
                Toast.makeText(this, "Quiz Finished!", Toast.LENGTH_LONG).show()
            }
        }

        // Set click listeners for options
        option1.setOnClickListener { checkAnswer(option1.text.toString()) }
        option2.setOnClickListener { checkAnswer(option2.text.toString()) }
        option3.setOnClickListener { checkAnswer(option3.text.toString()) }
        option4.setOnClickListener { checkAnswer(option4.text.toString()) }

        // Load the first question
        loadQuestion()
    }
}
