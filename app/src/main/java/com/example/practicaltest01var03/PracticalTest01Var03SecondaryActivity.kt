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

        input4 = findViewById(R.id.input4)
        input4.setText("$in3")

        correctButton.setOnClickListener {
            val resultIntent = Intent(this, PracticalTest01Var03MainActivity::class.java)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        incorrectButton.setOnClickListener {
            val resultIntent = Intent(this, PracticalTest01Var03MainActivity::class.java)
            setResult(Activity.RESULT_CANCELED, resultIntent)
            finish()
        }
    }
}