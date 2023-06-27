package com.example.conversion_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Length conversion variables
    private lateinit var lengthInputEditText: EditText
    private lateinit var lengthConversionSpinner: Spinner
    private lateinit var lengthConvertButton: Button
    private lateinit var lengthOutputTextView: TextView

    // Volume conversion variables
    private lateinit var volumeInputEditText: EditText
    private lateinit var volumeConversionSpinner: Spinner
    private lateinit var volumeConvertButton: Button
    private lateinit var volumeOutputTextView: TextView

    // Weight conversion variables
    private lateinit var weightInputEditText: EditText
    private lateinit var weightConversionSpinner: Spinner
    private lateinit var weightConvertButton: Button
    private lateinit var weightOutputTextView: TextView

    // Creating variables to store conversion values
    private val convkmtomiles = 0.62
    private val convmilestokm = 1.61
    private val convcmtoin = 0.39
    private val convintocm = 2.54
    private val convkgtolb = 2.2
    private val convlbtokg = 0.45
    private val convgtooz = 0.04
    private val convoztog = 28.35
    private val convltocup = 4.22
    private val convcuptol = 0.24
    private val convltogal = 0.26
    private val convgaltol = 3.78

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views for length conversions
        lengthConversionSpinner = findViewById(R.id.lengthConversionSpinner)
        lengthConvertButton = findViewById(R.id.lengthConvertButton)
        lengthOutputTextView = findViewById(R.id.lengthOutputTextView)
        lengthInputEditText = findViewById(R.id.lengthInputEditText)

        // Set click listener for lengthConvertButton
        lengthConvertButton.setOnClickListener {
            performLengthConversion()
        }

        // Initialize views for volume conversions
        volumeConversionSpinner = findViewById(R.id.volumeConversionSpinner)
        volumeConvertButton = findViewById(R.id.volumeConvertButton)
        volumeOutputTextView = findViewById(R.id.volumeOutputTextView)
        volumeInputEditText = findViewById(R.id.volumeInputEditText)

        // Set click listener for volumeConvertButton
        volumeConvertButton.setOnClickListener {
            performVolumeConversion()
        }

        // Initialize views for weight conversions
        weightConversionSpinner = findViewById(R.id.weightConversionSpinner)
        weightConvertButton = findViewById(R.id.weightConvertButton)
        weightOutputTextView = findViewById(R.id.weightOutputTextView)
        weightInputEditText = findViewById(R.id.weightInputEditText)

        // Set click listener for weightConvertButton
        weightConvertButton.setOnClickListener {
            performWeightConversion()
        }
    }

    private fun performLengthConversion() {
        val userInput = lengthInputEditText.text.toString().toDoubleOrNull()

        val conversionResult = when (lengthConversionSpinner.selectedItem.toString()) {
            "km to miles" -> userInput?.times(convkmtomiles)
            "mi to km" -> userInput?.times(convmilestokm)
            "cm to in" -> userInput?.times(convcmtoin)
            "in to cm" -> userInput?.times(convintocm)
            else -> null
        }

        val outputString = when (lengthConversionSpinner.selectedItem.toString()) {
            "km to miles" -> "The conversion to miles is ${conversionResult ?: ""}"
            "mi to km" -> "The conversion to kilometers is ${conversionResult ?: ""}"
            "cm to in" -> "The conversion to inches is ${conversionResult ?: ""}"
            "in to cm" -> "The conversion to centimeters is ${conversionResult ?: ""}"
            else -> "Invalid value or conversion"
        }

        lengthOutputTextView.text = outputString
    }

    private fun performVolumeConversion() {
        val userInput = volumeInputEditText.text.toString().toDoubleOrNull()

        val conversionResult = when (volumeConversionSpinner.selectedItem.toString()) {
            // Define the volume conversion cases and calculation logic
            // Example cases:
            "l to cup" -> userInput?.times(convltocup)
            "cup to l" -> userInput?.times(convcuptol)
            "l to gal" -> userInput?.times(convltogal)
            "gal to l" -> userInput?.times(convgaltol)
            else -> null
        }

        val outputString = when (volumeConversionSpinner.selectedItem.toString()) {
            // Define the output strings for each conversion case
            // Example cases:
            "l to cup" -> "The conversion to cup is ${conversionResult ?: ""}"
            "cup to l" -> "The conversion to liters is ${conversionResult ?: ""}"
            "l to gal" -> "The conversion to gallons is ${conversionResult ?: ""}"
            "gal to l" -> "The conversion to liters is ${conversionResult ?: ""}"
            else -> "Invalid value or conversion"
        }

        volumeOutputTextView.text = outputString
    }

    private fun performWeightConversion() {
        val userInput = weightInputEditText.text.toString().toDoubleOrNull()

        val conversionResult = when (weightConversionSpinner.selectedItem.toString()) {
            // Define the weight conversion cases and calculation logic
            // Example cases:
            "kg to lb" -> userInput?.times(convkgtolb)
            "lb to kg" -> userInput?.times(convlbtokg)
            "g to oz" -> userInput?.times(convgtooz)
            "oz to g" -> userInput?.times(convoztog)
            else -> null
        }

        val outputString = when (weightConversionSpinner.selectedItem.toString()) {
            // Define the output strings for each conversion case
            // Example cases:
            "kg to lb" -> "The conversion to pounds is ${conversionResult ?: ""}"
            "lb to kg" -> "The conversion to kilograms is ${conversionResult ?: ""}"
            "g to oz" -> "The conversion to ounces is ${conversionResult ?: ""}"
            "oz to g" -> "The conversion to grams is ${conversionResult ?: ""}"
            else -> "Invalid value or conversion"
        }

        weightOutputTextView.text = outputString
    }
}





