package com.example.assignment1imad5112

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        // Declaring the variables
        val textView2 = findViewById<TextView>(R.id.textView2)
        val editTextDay = findViewById<EditText>(R.id.editTextDay)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val buttonRecommend = findViewById<Button>(R.id.buttonRecommend)
        val buttonReset = findViewById<Button>(R.id.buttonReset) // Reset Button

        // The button will display meal suggestions when the user enters the time of the day
        buttonRecommend.setOnClickListener {
            val day = editTextDay.text.toString().trim().lowercase()
            var meal = ""

            if (day == "breakfast") {
                meal = "Eggs and bacon with toast"
            } else if (day == "mid-morning snack") {
                meal = "Yoghurt"
            } else if (day == "lunch") {
                meal = "Chicken Pizza"
            } else if (day == "afternoon snack") {
                meal = "Fruit Salad"
            } else if (day == "dinner") {
                meal = "Chicken and Mushroom Pasta"
            } else if (day == "dessert") {
                meal = "Creme Brulee"
            } else {
                meal = "Invalid time of day! Please enter a valid time of day"
            }
            textViewResult.text = meal

            // Reset Button Logic
            buttonReset.setOnClickListener {
                editTextDay.text.clear() // Clear input field
                textViewResult.text = "" } // Clear result
        }
    }
}


