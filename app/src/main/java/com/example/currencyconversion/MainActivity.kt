package com.example.currencyconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // set up variables for all of the different textviews and buttons
        val numToConvert = findViewById<EditText>(R.id.idEditTextDecimalToConvert)
        val rbUsToEu = findViewById<RadioButton>(R.id.idRbUsToEu)
        val rbEuToUs = findViewById<RadioButton>(R.id.idRbEuToUs)
        val btnConvert = findViewById<Button>(R.id.idBtnConvert)
        val txtResult = findViewById<TextView>(R.id.idTxtConvertedAmount)

        // set an on click listener for our button
        btnConvert.setOnClickListener {
            // take input from the edit text box for amount to convert and change it to a string
            var convertString = numToConvert.text.toString()
            // create a variable to hold the double value of the input edit text
            var convertIt = 0.00
            // make sure that the edit text has something in it
            if (TextUtils.isEmpty(convertString)){
                // convert our previous string into a double
                numToConvert.error = "Error\nAmount to convert is blank."
            } else {
                convertIt = convertString.toDouble()

            }
            // variables for the conversion rate, a decimal format and a blank variable for our converted number
            val conversionRate = 0.94
            val euroFormat = DecimalFormat("\u20ac ###,##0.00")
            val dolFormat = DecimalFormat("$ ###,##0.00")
            var converted : Double?

            /*
            check which radio button is checked and do math based on which is
            nested if checks if number entered is greater than 10,000 and prompts user to enter a smaller number
            if it is.
             */
            if (rbUsToEu.isChecked){
                if (convertIt <= 10000){
                    converted = convertIt * conversionRate
                    txtResult.text = euroFormat.format(converted)
                } else {
                    Toast.makeText(this@MainActivity, "Dollars must be less than 10,000",Toast.LENGTH_LONG).show()
                }
            }
            if (rbEuToUs.isChecked){
                if (convertIt <= 10000){
                    converted = convertIt / conversionRate
                    txtResult.text = dolFormat.format(converted)
                } else {
                    Toast.makeText(this@MainActivity, "Euros must be less than 10,000",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}