package com.malinikali.calculator.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.malinikali.calculator.R
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var tvFormula:TextView
    private var currentValue = ""
    private var lastNumer = false
    private  var lastOper = false
    private var lastDot = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val btnCE = findViewById<Button>(R.id.btnCE)


         tvFormula =  findViewById(R.id.tvFormula)

        val tvResult = findViewById<TextView>(R.id.tvResult)

        val btnC =  findViewById<Button>(R.id.btnC)
        val btnPN = findViewById<Button>(R.id.btnPN)
        val btnPerc = findViewById<Button>(R.id.btnPerc)
        val btnDiv =  findViewById<Button>(R.id.btnDiv)
        val btnSev =  findViewById<Button>(R.id.btnSev)
        val btnEight = findViewById<Button>(R.id.btnEight)
        val btnNine = findViewById<Button>(R.id.btnNine)
        val btnMult =  findViewById<Button>(R.id.btnMult)
        val btnSub = findViewById<Button>(R.id.btnSubt)
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnOne = findViewById<Button>(R.id.btnOne)
        val btnFour = findViewById<Button>(R.id.btnFour)
        val btnFive= findViewById<Button>(R.id.btnFive)
        val btnSix= findViewById<Button>(R.id.btnSix)
        val btnZero= findViewById<Button>(R.id.btnZero)
        val btnDec= findViewById<Button>(R.id.btnDot)
        btnDec.setOnClickListener {
            val dec = btnDec.text.toString()
            if (tvFormula.text.isEmpty() || lastDot){
                Toast.makeText(this,"Please use required format to proceed", Toast.LENGTH_SHORT).show()

            } else{
                currentValue += dec
                tvFormula.text = currentValue
            }
            lastOper = true
            lastNumer = false
            lastDot = false
        }



        btnCE.setOnClickListener{
            tvResult.text = ""
            tvFormula.text = ""
            lastOper = false
            lastNumer = false
            lastDot = false
        }
        btnC.setOnClickListener {
           currentValue = tvFormula.text.toString()
            if (currentValue.isNotEmpty()){
                tvFormula.text = currentValue.substring(0, currentValue.length - 1);
            }


        }

        val btnEq = findViewById<Button>(R.id.btnEqual)



        btnEq.setOnClickListener{
            if (lastDot && lastNumer) {
                currentValue = tvFormula.text.toString()

                val expression = ExpressionBuilder(currentValue).build()

                val result = expression.evaluate()

                tvResult.text = result.toString()

                lastOper = false
                lastNumer = false
                lastDot = false
            }
            else{
                
            }


        }


    }


    fun addOperand(view: View) {
        val theButton = view as Button
        val operand = theButton.text.toString()
        if (tvFormula.text.isEmpty()){
            Toast.makeText(this,"Please use required format to proceed", Toast.LENGTH_SHORT).show()

        } else{
            currentValue += operand
            tvFormula.text = currentValue
        }
        lastOper = true
        lastNumer = false
        lastDot = false

    }

    fun addDigit(view: View) {
        val theButton = view as Button
        val digit =  theButton.text.toString()
        if(tvFormula.text.toString().isEmpty()){
            currentValue = digit.toString()
            tvFormula.text = currentValue


        }else{
            currentValue += digit.toString()
            tvFormula.text = currentValue
        }
        lastOper = false
        lastNumer = true
        lastDot = false
    }
}