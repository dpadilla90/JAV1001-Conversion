package com.example.conversion_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var inputEditText: EditText
    private lateinit var conversionSpinner: Spinner
    private lateinit var convertButton: Button
    private lateinit var outputTextView: TextView

    // Creating variables to store conversion values
    private val convkmtomiles = 0.62
    private val convmilestokm = 1.61
    private val convcmtoin= 0.39
    private val convintocm=2.54
    private val convkgtolb=2.2
    private val convlbtokg=0.45
    private val convgtooz=0.04
    private val convoztog=28.35
    private val convltocup=4.17
    private val convcuptol=0.24

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        inputEditText = findViewById(R.id.inputEditText)
        conversionSpinner = findViewById(R.id.conversionSpinner)
        convertButton = findViewById(R.id.convertButton)
        outputTextView = findViewById(R.id.outputTextView)

                // Set click listener for convertButton
                convertButton.setOnClickListener {
            performConversion()
        }


    }
            private fun performConversion() {
            // Retrieve user input value
            val userInput = inputEditText.text.toString().toDoubleOrNull()


                // Perform the conversion based on the selected conversion unit and display the result
            val conversionResult = when (conversionSpinner.selectedItem.toString()) {
                "km" -> userInput?.times(convkmtomiles)
                "mi" -> userInput?.times(convmilestokm)
                "cm" -> userInput?.times(convcmtoin)
                "in" -> userInput?.times(convintocm)
                "kg" -> userInput?.times(convkgtolb)
                "lb" -> userInput?.times(convlbtokg)
                "g" -> userInput?.times(convgtooz)
                "oz" -> userInput?.times(convoztog)
                "l" -> userInput?.times(convltocup)
                "cup" -> userInput?.times(convcuptol)
                else -> null
            }
            //Display the result
            outputTextView.text = conversionResult?.toString() ?: "Invalid value or conversion"
        }
    }








