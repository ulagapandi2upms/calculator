package com.kathir.calculator.calculator

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.kathir.calculator.R
import kotlinx.android.synthetic.main.view_calculator_output.view.*

class CalculatorOutputView(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet), Calculator {

    private val TAG = "CalculatorOutputView"

    init {

        orientation = VERTICAL

        gravity = Gravity.CENTER_VERTICAL

        LayoutInflater.from(context).inflate(R.layout.view_calculator_output, this, true)
    }

    fun clickNumPad(id:Int) {
        CalculatorImpl.numpadClicked(id)
    }
    fun handleOperation(operation: String) {
        CalculatorImpl.handleOperation(operation)
    }

    fun removeItem() {
        CalculatorImpl.handleClear()
    }

    fun clear() {
        CalculatorImpl.handleReset()
    }

    fun solve() {
        CalculatorImpl.handleEquals()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        CalculatorImpl.attach(this, context)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        CalculatorImpl.detach()
    }

    override fun showNewResult(value: String, context: Context?) {
        calculator_result.text = value
    }
    override fun showNewFormula(value: String, context: Context?) {
        calculator_formula.text = value
    }


}