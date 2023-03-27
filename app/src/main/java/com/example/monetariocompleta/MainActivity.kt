package com.example.monetariocompleta

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.txtResultado)

        val converte_number = findViewById<Button>(R.id.btnConverter)

        converte_number.setOnClickListener(View.OnClickListener { view ->
            AplicaConversor()
        })

    }

    private fun AplicaConversor() {
        val editField = findViewById<EditText>(R.id.fieldText)
        val value = editField.text.toString()

        val selectedCurrency = findViewById<RadioGroup>(R.id.radioGroup)
        val checked = selectedCurrency.checkedRadioButtonId
        val currency = when (checked) {
            R.id.radio_usd -> "USD"
            R.id.radio_eur -> "EUR"
            else -> "CLP"
        }

       val valorFinal: Double

        if (value.isNotEmpty()) {
            if (currency == "USD"){
                val value = value.toFloat()
                val b:Double = 1.19
                valorFinal = value * b
                Log.d("Pacheco USD", value.toString())

            } else if (currency == "EUR"){
                val value = value.toFloat()
                val b:Double = 1.18
                valorFinal = value * b
                Log.d("Pacheco EUR", value.toString())

            } else {

                val value = value.toFloat()
                val b:Double = 153.64
                valorFinal = value * b
                Log.d("Pacheco CLP", value.toString())
            }

            result.text = currency + ' ' + valorFinal
            result.visibility = View.VISIBLE
        }






    }
}