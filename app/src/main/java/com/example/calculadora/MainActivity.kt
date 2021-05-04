package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val resultadotext = findViewById<TextView>(R.id.resultadotext)
        val clearbtn = findViewById(R.id.clearbtn) as Button

        val btn0 = findViewById(R.id.btn0) as Button
        val btn1 = findViewById(R.id.btn1) as Button
        val btn2 = findViewById(R.id.btn2) as Button
        val btn3 = findViewById(R.id.btn3) as Button
        val btn4 = findViewById(R.id.btn4) as Button
        val btn5 = findViewById(R.id.btn5) as Button
        val btn6 = findViewById(R.id.btn6) as Button
        val btn7 = findViewById(R.id.btn7) as Button
        val btn8 = findViewById(R.id.btn8) as Button
        val btn9 = findViewById(R.id.btn9) as Button

        val divisionbtn = findViewById(R.id.divisionbtn) as Button
        val sumabtn = findViewById(R.id.sumabtn) as Button
        val restabtn = findViewById(R.id.restabtn) as Button
        val btnpunto = findViewById(R.id.btnpunto) as Button
        val multibtn = findViewById(R.id.multibtn) as Button

        val equalbtn = findViewById(R.id.equalbtn) as Button



        btn0.setOnClickListener{numeroPresionado("0")}
        btn1.setOnClickListener{numeroPresionado("1")}
        btn2.setOnClickListener{numeroPresionado("2")}
        btn3.setOnClickListener{numeroPresionado("3")}
        btn4.setOnClickListener{numeroPresionado("4")}
        btn5.setOnClickListener{numeroPresionado("5")}
        btn6.setOnClickListener{numeroPresionado("6")}
        btn7.setOnClickListener{numeroPresionado("7")}
        btn8.setOnClickListener{numeroPresionado("8")}
        btn9.setOnClickListener{numeroPresionado("9")}

        sumabtn.setOnClickListener{operacionPresionada(SUMA)}
        divisionbtn.setOnClickListener{operacionPresionada(DIVISION)}
        multibtn.setOnClickListener{operacionPresionada(MULTIPLICACION)}
        restabtn.setOnClickListener{operacionPresionada(RESTA)}

        clearbtn.setOnClickListener{
            num1 = 0.0
            num2 = 0.0
            resultadotext.text = ""
            operacion = NO_OPERACION
        }

        equalbtn.setOnClickListener{
            var resultado = when(operacion) {
                SUMA -> num1 + num2
                RESTA -> num1-num2
                MULTIPLICACION -> num1*num2
                DIVISION -> num1/num2
                else -> 0
            }

            resultadotext.text = resultado.toString()
        }
    }

    private fun numeroPresionado(digito: String) {

        val resultadotext = findViewById<TextView>(R.id.resultadotext)

        val resultado = resultadotext.text.toString()

        resultadotext.setText(resultado + digito)

        if(operacion == NO_OPERACION) {
            num1 = resultadotext.text.toString().toDouble()

        } else {
            num2 = resultadotext.text.toString().toDouble()
        }
    }

    private fun operacionPresionada(operacion: Int) {
        val resultadotext = findViewById<TextView>(R.id.resultadotext)
        this.operacion = operacion

        resultadotext.text = ""
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERACION = 0
    }

}