package com.example.screenandnavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruct)

        val name_text = intent.extras?.getString("name_key") ?: ""
        val textMessage = findViewById<TextView>(R.id.massege_textView)
        textMessage.text = name_text
        val appleButton = findViewById<Button>(R.id.apple_button)
        val bananButton = findViewById<Button>(R.id.banana_button)

        appleButton.setOnClickListener{
            val intent = Intent()
            intent.putExtra("resalt_fruit", "Apple")
            setResult(RESULT_OK,intent)
            finish()
        }
        bananButton.setOnClickListener{
            val intent = Intent()
            intent.putExtra("resalt_fruit", "Banana")
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}