package com.example.practicaltest01var03

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class PracticalTest01Var03SecondaryActivity : AppCompatActivity() {
    private lateinit var input4: TextView
    private lateinit var correctButton: Button
    private lateinit var incorrectButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_secondary)

        val in1 = intent.getStringExtra("input1")
        val in2 = intent.getStringExtra("input2")
        val in3 = intent.getStringExtra("input3")

        input4 = findViewById(R.id.input4)
        correctButton = findViewById(R.id.corect)
        incorrectButton = findViewById(R.id.incorect)

        val op = intent.getStringExtra("operator")

        val v1 : String?
        val v2 : String?

        if (op == "+") {
            v1 = in3?.split("+")[0]
            v2 = in3?.split("+")[1]
        } else {
            v1 = in3?.split("-")[0]
            v2 = in3?.split("-")[1]
        }

        if (in1 != null && in2 != null) {
            if (op == "+") {
                input4.setText(in3 + " = " + (in1.toInt() + in2.toInt()))
            } else if (op == "-") {
                input4.setText(in3 + " = " + (in1.toInt() - in2.toInt()))
            }
        }
    }
}