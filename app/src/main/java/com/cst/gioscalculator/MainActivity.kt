package com.cst.gioscalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun clickedButton(view: View) {
        val operand = view.tag.toString()

        if (editText1.text.isNotEmpty() && editText2.text.isNotEmpty()) {
            try {
                val firstNum: Int = editText1.text.toString().toInt()
                val secondNum: Int = editText2.text.toString().toInt()

                val res: () -> Int = when (operand) {
                    "-" -> { { firstNum - secondNum } }
                    "+" -> { { firstNum + secondNum } }
                    "*" -> { { firstNum * secondNum } }
                    "/" -> { { firstNum / secondNum } }
                    else -> return
                }
                val intent = Intent(this, Result::class.java)
                startActivity(intent.apply {
                    putExtra("Result", "$firstNum $operand $secondNum = ${res()}")
                })
            } catch (e: Exception) {
                Toast.makeText(this, "Error : ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
            }

        } else {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
        }
    }

}