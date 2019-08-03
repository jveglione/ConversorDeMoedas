package com.jojo.conversormoedas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mViewHolder = ViewHolder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.mViewHolder.editValue = findViewById(R.id.edit_value)
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar)
        this.mViewHolder.textEuro = findViewById(R.id.text_euro)
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate)
        this.mViewHolder.buttonCalculate!!.setOnClickListener(this)

        this.clearValues()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_calculate) {
            val value = this.mViewHolder.editValue!!.text.toString()
            if ("" == value) {
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show() }
            else {
                val real = java.lang.Double.valueOf(value)

                this.mViewHolder.textDolar!!.text = String.format("%.2f", real / 3.82)
                this.mViewHolder.textEuro!!.text = String.format("%.2f", real / 4.29)
            }
        }
    }

    private fun clearValues() {
        this.mViewHolder.textDolar!!.text = ""
        this.mViewHolder.textEuro!!.text = ""
    }

    private class ViewHolder {
        internal var editValue: EditText? = null
        internal var textDolar: TextView? = null
        internal var textEuro: TextView? = null
        internal var buttonCalculate: Button? = null
    }
}
