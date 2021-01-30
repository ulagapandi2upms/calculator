package com.kathir.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kathir.calculator.calculator.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        key_0.setOnClickListener { output_layout.clickNumPad(0) }
        key_1.setOnClickListener { output_layout.clickNumPad(1) }
        key_2.setOnClickListener { output_layout.clickNumPad(2) }
        key_3.setOnClickListener { output_layout.clickNumPad(3) }
        key_4.setOnClickListener { output_layout.clickNumPad(4) }
        key_5.setOnClickListener { output_layout.clickNumPad(5) }
        key_6.setOnClickListener { output_layout.clickNumPad(6) }
        key_7.setOnClickListener { output_layout.clickNumPad(7) }
        key_8.setOnClickListener { output_layout.clickNumPad(8) }
        key_9.setOnClickListener { output_layout.clickNumPad(9) }
        key_decimal.setOnClickListener { output_layout.clickNumPad(10) }

        key_backspace.setOnClickListener { output_layout.removeItem() }
        key_backspace.setOnLongClickListener {
            output_layout.clear()
            true
        }

        key_delete.setOnClickListener { output_layout.clear() }
        key_equal.setOnClickListener { output_layout.solve() }

        key_plus.setOnClickListener { output_layout.handleOperation(PLUS) }
        key_minus.setOnClickListener { output_layout.handleOperation(MINUS) }
        key_multiplication.setOnClickListener { output_layout.handleOperation(MULTIPLY) }
        key_division.setOnClickListener { output_layout.handleOperation(DIVIDE) }
        key_percentage.setOnClickListener { output_layout.handleOperation(PERCENT) }
    }

}