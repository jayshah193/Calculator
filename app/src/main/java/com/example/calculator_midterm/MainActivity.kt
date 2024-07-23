package com.example.calculator_midterm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var firstNumber: EditText
    private lateinit var secondNumber: EditText
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var divideButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNumber = findViewById(R.id.firstNumber)
        secondNumber = findViewById(R.id.secondNumber)
        addButton = findViewById(R.id.addButton)
        subtractButton = findViewById(R.id.subtractButton)
        multiplyButton = findViewById(R.id.multiplyButton)
        divideButton = findViewById(R.id.divideButton)
        resultTextView = findViewById(R.id.resultTextView)

        addButton.setOnClickListener { performOperation("add") }
        subtractButton.setOnClickListener { performOperation("subtract") }
        multiplyButton.setOnClickListener { performOperation("multiply") }
        divideButton.setOnClickListener { performOperation("divide") }
    }

    private fun performOperation(operation: String) {
        val num1 = firstNumber.text.toString().toDoubleOrNull()
        val num2 = secondNumber.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            resultTextView.text = "Please enter valid numbers"
            return
        }

        val result = when (operation) {
            "add" -> num1 + num2
            "subtract" -> num1 - num2
            "multiply" -> num1 * num2
            "divide" -> {
                if (num2 == 0.0) {
                    resultTextView.text = "Cannot divide by zero"
                    return
                } else {
                    num1 / num2
                }
            }
            else -> 0.0
        }

        resultTextView.text = "Result: $result"
    }
}

fun main() {
    println("Enter first number:")
    val num1 = readLine()!!.toDouble()
    println("Enter second number:")
    val num2 = readLine()!!.toDouble()

    println("Choose an operation: +, -, , /")
    val operation = readLine()

    val result = when (operation) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "" -> num1 * num2
        "/" -> num1 / num2
        else -> {
            println("Invalid operation")
            return
        }
    }

    println("The result of the operation is: $result")
}