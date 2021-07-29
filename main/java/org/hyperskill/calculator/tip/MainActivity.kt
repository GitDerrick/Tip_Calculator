package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var billAmount: Double = 0.0
        var tipAmount: Double = 0.0

        edit_text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                billAmount = p0.toString().toDouble()
                updateResult(billAmount, tipAmount)
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        slider.addOnChangeListener { _, value, _ ->
            tipAmount = value.toDouble()
            updateResult(billAmount, tipAmount)
        }
    }

    fun updateResult(billAmount: Double, tipAmount: Double) {
        val tip = billAmount * tipAmount / 100
        if (billAmount != 0.0) {
            text_view.text = "Tip amount: ${"%.2f".format(tip)}"
        } else text_view.text = ""
    }
}