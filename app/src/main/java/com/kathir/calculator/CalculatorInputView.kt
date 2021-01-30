package com.kathir.calculator

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_calculator_input.view.*


class CalculatorInputView(context: Context, attributeSet: AttributeSet?) :
    RelativeLayout(context, attributeSet) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_calculator_input, this, true)


        attributeSet?.run {
            val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CalculatorInputView)

            val textResource = typedArray.getString(R.styleable.CalculatorInputView_item_text)
            val iconResource =
                typedArray.getResourceId(R.styleable.CalculatorInputView_item_icon, -1)

            when {
                iconResource != -1 -> {
                    input_element_text.visibility = GONE
                    input_element_image.apply {
                        visibility = VISIBLE
                        setImageResource(iconResource)
                    }
//                    input_element_View.setBackgroundResource(R.drawable.bg_operator)
                }
                !textResource.isNullOrEmpty() -> {
                    input_element_image.visibility = GONE
                    input_element_text.apply {
                        visibility = VISIBLE
                        text = textResource
                    }
//                    input_element_View.setBackgroundResource(R.drawable.bg_number_keyboard)
                }
                else -> {
                    input_element_text.visibility = GONE
                    input_element_image.visibility = GONE
                }
            }

            typedArray.recycle()

        }

    }

    override fun setOnClickListener(l: OnClickListener?) {
        input_element_click.setOnClickListener(l)
    }

    override fun setOnLongClickListener(l: OnLongClickListener?) {
        input_element_click.setOnLongClickListener(l)
    }
}