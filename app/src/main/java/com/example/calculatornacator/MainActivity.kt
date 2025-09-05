package com.example.calculatornacator // Add your package name here

import androidx.activity.ComponentActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : ComponentActivity() {
    private lateinit var number1EditText: EditText
    private lateinit var number2EditText: EditText
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var divideButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1EditText = findViewById<EditText>(R.id.number1_edit_text)
        number2EditText = findViewById<EditText>(R.id.number2_edit_text)
        addButton = findViewById<Button>(R.id.add_button)
        subtractButton = findViewById<Button>(R.id.subtract_button)
        multiplyButton = findViewById<Button>(R.id.multiply_button)
        divideButton = findViewById<Button>(R.id.divide_button) // Fixed typo: dwide -> divide
        resultTextView = findViewById<TextView>(R.id.result_text_view)

        addButton.setOnClickListener { calculate('+') }
        subtractButton.setOnClickListener { calculate('-') }
        multiplyButton.setOnClickListener { calculate('*') }
        divideButton.setOnClickListener { calculate('/') }
    }

    private fun calculate(operation: Char) {
        val num1Str = number1EditText.text.toString()
        val num2Str = number2EditText.text.toString()

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            resultTextView.text = "Please enter both numbers"
            return
        }

        try {
            // Parse input values
            val num1 = num1Str.toDouble()
            val num2 = num2Str.toDouble()
            val result: Double

            when (operation) {
                '+' -> result = num1 + num2
                '-' -> result = num1 - num2
                '*' -> result = num1 * num2
                '/' -> {
                    if (num2 == 0.0) {
                        resultTextView.text = "Cannot divide by zero"
                        return
                    }
                    result = num1 / num2
                }
                else -> {
                    resultTextView.text = "Invalid operation"
                    return
                }
            }

            // Display result
            resultTextView.text = "Result: $result"

        } catch (e: NumberFormatException) {
            resultTextView.text = "Invalid number format"
        }
    }
}