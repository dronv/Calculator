package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    //Declaring variables of types Button and TextView
    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnAdd: Button
    private lateinit var btnSub: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button
    private lateinit var btnClear: Button
    private lateinit var btnEqual: Button
    private lateinit var btnDel: Button
    private lateinit var btnDecimal: Button
    private lateinit var inputView: TextView
    private lateinit var resultView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Casting android Widgets to variables
        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        btnClear = findViewById(R.id.btnClear)
        btnEqual= findViewById(R.id.btnEqual)
        btnDel=findViewById(R.id.btnDel)
        inputView = findViewById(R.id.input)
        resultView=findViewById(R.id.resultView)
        btnDecimal= findViewById(R.id.btnDecimal)


//Creating the functionality of the buttons

        //Button listeners for numbers
        btn0.setOnClickListener { view: View ->
           showInput("0",true)
        }
        btn1.setOnClickListener { view: View ->
            showInput("1",true)
        }
        btn2.setOnClickListener { view: View ->
            showInput("2",true)

        }
        btn3.setOnClickListener { view: View ->
            showInput("3",true)
        }
        btn4.setOnClickListener { view: View ->
            showInput("4",true)
        }
        btn5.setOnClickListener { view: View ->
            showInput("5",true)
        }
        btn6.setOnClickListener { view: View ->
            showInput("6",true)
        }
        btn7.setOnClickListener { view: View ->
            showInput("7",true)
        }
        btn8.setOnClickListener { view: View ->
            showInput("8",true)
        }
        btn9.setOnClickListener { view: View ->
            showInput("9",true)
        }


        //Button for decimal
        btnDecimal.setOnClickListener { view:View->
            showInput(".",true)
        }

        //Button listeners for functions
        btnAdd.setOnClickListener { view: View ->
            showInput("+",true)
        }
        btnSub.setOnClickListener { view: View ->
            showInput("-",true)
        }
        btnMultiply.setOnClickListener { view: View ->
            showInput("*",true)
        }
        btnDivide.setOnClickListener { view: View ->
            showInput("/",true)
        }
        //Clear button which clears the result and input numbers from the screen
        btnClear.setOnClickListener { view: View ->
            inputView.setText("")
            resultView.setText("")
        }

        //DEl button clears the last input from the screen
        btnDel.setOnClickListener { view:View->
            val input=inputView.text.toString()
            if(input.isNotEmpty())
            {
                val newInput=input.substring(0,input.length-1)
                inputView.setText(newInput)

            }
            resultView.text=""
        }

        //On pressing the equal button, the expression entered will be evaluated and result will be printed.
       btnEqual.setOnClickListener{view:View->
            val input=inputView.text.toString()  //taking the expression value in a varaiable called input
            val expression=ExpressionBuilder(input).build()    //Calling the ExpressionBuilder() function and taking arguement input to build and save the expression varaible.
            val result=expression.evaluate()   //evaluating the expression according to the operators and saving answer in result
            val longResult= result.toLong()  //if the result is long variable
            if(result==longResult.toDouble()) //if the result is in decimal
            {
                resultView.text=longResult.toString()

            }
            else
            {
                resultView.text=result.toString()
            }
        }
    }

    //Creating a function called showInput which displays all the values of button clicked on the display screen
    fun showInput(string:String,clear:Boolean)
    {
        if(clear)
        {
          resultView.setText("")
          inputView.append(string)
        }
        else
        {
            inputView.append(resultView.text)
            inputView.append(string)
            resultView.text=""
        }
    }
    }




