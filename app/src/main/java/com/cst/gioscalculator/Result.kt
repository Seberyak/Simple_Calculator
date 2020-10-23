package com.cst.gioscalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getStringExtra("Result")
        val resultId = findViewById<TextView>(R.id.result)
        resultId.apply {
            text = result
        }
    }

}