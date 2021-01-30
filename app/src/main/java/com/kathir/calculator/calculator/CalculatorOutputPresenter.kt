package com.kathir.calculator.calculator

import bsh.Interpreter
import java.lang.Exception

object CalculatorOutputPresenterDemo {

    private var myView :CalculatorOutputViewInterfaceView? = null

    private var currentEquation:String = ""

    private var currentOutcome:String = ""

    private val interpreter = Interpreter()

    private var prevEquation = ""
    private var decimalCount = 0
    private var isOperatorAdded = false

//
//    fun attach(view: CalculatorOutputView) {
//        myView = view
//    }
//
//    fun detach() {
//        myView = null
//    }

    fun add(item:String) {
        if(isAddItemValid(item)) {
            currentEquation = currentEquation.plus(item)
            updateEquation()
            calculateOutcome()
            updateOutcome()
        }
    }

    private fun isAddItemValid(item: String): Boolean  = true

    private fun calculateOutcome() {

        if(currentEquation.isNotEmpty()) {
            try {
                interpreter.eval("result = $currentEquation")
                val result = interpreter.get("result")

                if(result != null && (result is Int || result is Double)) {
                    currentOutcome = result.toString()
                }
            }catch (e:Exception){
                currentOutcome = ""
            }
        } else {
            currentOutcome = ""
        }
    }

    fun remove() {
        currentEquation = when {
            currentEquation.length > 1 -> currentEquation.substring(0, currentEquation.length -1)
            else -> ""
        }
        updateEquation()
        calculateOutcome()
        updateOutcome()
    }

    fun clear() {
        currentEquation = ""
        currentOutcome = ""
        updateEquation()
        updateOutcome()
    }

    fun solve() {
        if(currentOutcome.isNotEmpty()) {
            currentEquation = currentOutcome
            currentOutcome = ""
        }
        updateEquation()
        updateOutcome()
    }

    private fun updateEquation() {
        myView?.setEquation(currentEquation)
    }

    private fun updateOutcome() {
        myView?.setOutcome(currentOutcome)
    }
}