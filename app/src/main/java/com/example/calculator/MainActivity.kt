package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var currentNumber = StringBuilder()
    private var firstNumber: Double? = null
    private var isOperationPending = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        resultTextView = findViewById(R.id.resultTextView)
        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val buttonPlus = findViewById<Button>(R.id.buttonPlus)
        val buttonClear = findViewById<Button>(R.id.buttonClear)


        val numberButtons = listOf(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9)
        numberButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                if (isOperationPending) {
                    currentNumber.clear()
                    isOperationPending = false
                }
                currentNumber.append(index.toString())
                resultTextView.text = currentNumber.toString()
            }
        }


        buttonPlus.setOnClickListener {
            if (currentNumber.isNotEmpty()) {
                if (firstNumber == null) {
                    firstNumber = currentNumber.toString().toDouble()
                    isOperationPending = true
                } else {
                    val secondNumber = currentNumber.toString().toDouble()
                    val result = firstNumber!! + secondNumber
                    resultTextView.text = result.toString()
                    firstNumber = result
                    isOperationPending = true
                }
            }
        }

        buttonClear.setOnClickListener {
            currentNumber.clear()
            firstNumber = null
            isOperationPending = false
            resultTextView.text = "0"
        }
    }
}





