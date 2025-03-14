package com.example.kalkulator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText1 = findViewById<EditText>(R.id.editTextNumber)
        val editText2 = findViewById<EditText>(R.id.editTextNumber2)
        val textView = findViewById<TextView>(R.id.Textview)

        val buttonTambah = findViewById<Button>(R.id.button3)
        val buttonKurang = findViewById<Button>(R.id.button)
        val buttonKali = findViewById<Button>(R.id.button2)
        val buttonBagi = findViewById<Button>(R.id.button4)

        fun getNumbers(): Pair<Double, Double>? {
            val num1 = editText1.text.toString().toDoubleOrNull()
            val num2 = editText2.text.toString().toDoubleOrNull()

            if (num1 == null || num2 == null) {
                textView.text = "Masukkan angka yang valid!"
                return null
            }
            return Pair(num1, num2)
        }

        buttonTambah.setOnClickListener {
            getNumbers()?.let { (num1, num2) ->
                textView.text = "Hasil: ${num1 + num2}"
            }
        }

        buttonKurang.setOnClickListener {
            getNumbers()?.let { (num1, num2) ->
                textView.text = "Hasil: ${num1 - num2}"
            }
        }

        buttonKali.setOnClickListener {
            getNumbers()?.let { (num1, num2) ->
                textView.text = "Hasil: ${num1 * num2}"
            }
        }

        buttonBagi.setOnClickListener {
            getNumbers()?.let { (num1, num2) ->
                if (num2 == 0.0) {
                    textView.text = "Tidak bisa dibagi dengan nol!"
                } else {
                    textView.text = "Hasil: %.2f".format(num1 / num2)
                }
            }
        }
    }
}