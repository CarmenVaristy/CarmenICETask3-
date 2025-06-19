package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Connect the UI elements to variables in code
        //reference GPT
        val guessInput = findViewById<EditText>(R.id.guessInput)
        val guessButton = findViewById<Button>(R.id.guessButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        // Generate a random number from 1 to 10
        //reference GPT
        var randomNumber = Random.nextInt(1, 11)

        guessButton.setOnClickListener {
            val guess = guessInput.text.toString()

            if (guess.isEmpty()) {
                Toast.makeText(this, "Please enter a number!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val guessedNumber = guess.toInt()

            if (guessedNumber == randomNumber) {
                resultText.text = "🎉 You got it! It was $randomNumber"
            } else {
                resultText.text = "❌ Nope! Try again."
            }
        }
    }
}
//Reference (Harvard Style)
//Google Developers. (n.d.). Building your first Android app. Available at: https://developer.android.com/training/basics/firstapp [Accessed 19 June 2025].

//Android Developers. (n.d.). Activities and Intents. Available at: https://developer.android.com/guide/components/activities/intro-activities [Accessed 19 June 2025].

//Vogella. (n.d.). Android Intents - Tutorial. Available at: https://www.vogella.com/tutorials/AndroidIntent/article.html [Accessed 19 June 2025].

//Kotlin Documentation. (n.d.). Collections overview. Available at: https://kotlinlang.org/docs/collections-overview.html [Accessed 19 June 2025].
