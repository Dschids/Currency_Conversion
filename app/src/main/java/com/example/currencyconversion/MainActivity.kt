package com.example.currencyconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val edtTextNumToConvert = findViewById<EditText>(R.id.idEditTextDecimalToConvert)
        val rbUsToEu = findViewById<RadioButton>(R.id.idRbUsToEu)
        val rbEuToUs = findViewById<RadioButton>(R.id.idRbEuToUs)
        val btnConvert = findViewById<Button>(R.id.idBtnConvert)
        val txtResult = findViewById<TextView>(R.id.idTxtConvertedAmount)

        val convertIt = edtTextNumToConvert.text.toString().toDouble()
        val conversionRate = 0.94
        val decim = DecimalFormat("###,###.00")
        var converted : Double?


        btnConvert.setOnClickListener {
            if (rbUsToEu.isChecked){
                if (convertIt <= 10000){
                    converted = convertIt * conversionRate
                    var euros = decim.format(converted) + " Euros"
                    txtResult.text = euros
                } else {
                    Toast.makeText(this@MainActivity, "Dollars must be less than 10,000",Toast.LENGTH_LONG).show()
                }
            }
            if (rbEuToUs.isChecked){
                if (convertIt <= 10000){
                    converted = convertIt / conversionRate
                    var dollars = decim.format(converted) + " Dollars"
                    txtResult.text = dollars
                } else {
                    Toast.makeText(this@MainActivity, "Euros must be less than 10,000",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}