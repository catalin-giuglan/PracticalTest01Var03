package com.example.practicaltest01var03

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Toast
import android.widget.Button
import android.content.Intent
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import androidx.activity.result.contract.ActivityResultContracts
import kotlin.text.set

class PracticalTest01Var03MainActivity : AppCompatActivity() {

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        input3 = findViewById(R.id.input3)

        val activityResultsLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val message = result.data?.getStringExtra("result")
                    if (message != null) {
                        Toast.makeText(this, "The result is $message", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        val navigateToSecondaryActivityButton = findViewById<Button>(R.id.set)
        navigateToSecondaryActivityButton.setOnClickListener {
            val intent = Intent(this, PracticalTest01Var03SecondaryActivity::class.java)
            intent.putExtra("input1", Integer.valueOf(input1.text.toString()))
            intent.putExtra("input2", Integer.valueOf(input2.text.toString()))
            intent.putExtra("input3", Integer.valueOf(input3.text.toString()))
            activityResultsLauncher.launch(intent)
        }

        val plus = findViewById<Button>(R.id.plus)
        plus.setOnClickListener {
            val num1 = input1.text.toString().toIntOrNull()
            val num2 = input2.text.toString().toIntOrNull()

            if (num1 != null && num2 != null) {
                input3.setText(num1.toString() + "+" + num2.toString())
            } else {
                input3.setText("+")
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }

        val minus = findViewById<Button>(R.id.minus)
        minus.setOnClickListener {
            val num1 = input1.text.toString().toIntOrNull()
            val num2 = input2.text.toString().toIntOrNull()

            if (num1 != null && num2 != null) {
                input3.setText(num1.toString() + "-" + num2.toString())
            } else {
                input3.setText("-")
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        val intent = Intent(applicationContext, PracticalTest01Var03MainActivity::class.java)
        applicationContext.stopService(intent)
        super.onDestroy()
    }
}