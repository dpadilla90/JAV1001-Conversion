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
    private val convltocup=4.22
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
                "km to miles" -> userInput?.times(convkmtomiles)
                "mi to km" -> userInput?.times(convmilestokm)
                "cm to in" -> userInput?.times(convcmtoin)
                "in to cm" -> userInput?.times(convintocm)
                "kg to lb" -> userInput?.times(convkgtolb)
                "lb to kg" -> userInput?.times(convlbtokg)
                "g to oz" -> userInput?.times(convgtooz)
                "oz to g" -> userInput?.times(convoztog)
                "l to cup" -> userInput?.times(convltocup)
                "cup to l" -> userInput?.times(convcuptol)
                else -> null
            }

            // Format the output string based on the selected conversion unit
            val outputString = when (conversionSpinner.selectedItem.toString()) {
                "km to miles" -> "The conversion to miles is ${conversionResult ?: ""}"
                "mi to km" -> "The conversion to km is ${conversionResult ?: ""}"
                "cm to in" -> "The conversion to inches is ${conversionResult ?: ""}"
                "in to cm" -> "The conversion to cm is ${conversionResult ?: ""}"
                "kg to lb" -> "The conversion to lb is ${conversionResult ?: ""}"
                "lb to kg" -> "The conversion to kg is ${conversionResult ?: ""}"
                "g to oz" -> "The conversion to oz is ${conversionResult ?: ""}"
                "oz to g" -> "The conversion to g is ${conversionResult ?: ""}"
                "l to cup" -> "The conversion to cup is ${conversionResult ?: ""}"
                "cup to l" -> "The conversion to l is ${conversionResult ?: ""}"
                else -> "Invalid value or conversion"
            }
            // Display the result
            outputTextView.text = outputString
        }
    }








