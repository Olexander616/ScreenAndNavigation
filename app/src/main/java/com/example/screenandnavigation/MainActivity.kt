package com.example.screenandnavigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView

    private val launcher = registerForActivityResult(ResultContract()){
        resultTextView.text = it
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myButton = findViewById<Button>(R.id.my_button)
        resultTextView = findViewById<TextView>(R.id.resultTextView)
//       myButton.setOnClickListener{
//            val intetent = Intent(this,SecondActivity::class.java)
          val editText = findViewById<EditText>(R.id.input_name)
//            intetent.putExtra("name_key", editText.text.toString())
//            startActivityForResult(intetent,1)
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if(requestCode == 1){
//            val fruitString = data?.extras?.getString("resalt_fruit") ?:""
//            resultTextView.text= fruitString.toString()
//        }
        myButton.setOnClickListener{
            val name = editText.text.toString()
            launcher.launch(name)
        }
    }
}

class ResultContract: ActivityResultContract<String, String>(){// перше що передаємо, друге який тип отримуємо назад
    override fun createIntent(context: Context, message: String) : Intent {
    val intent = Intent(context, SecondActivity::class.java)
        intent.putExtra("name_key", message)
    return intent
}
    override fun parseResult(resultCode: Int, result: Intent?): String {
        if (resultCode!= Activity.RESULT_OK){
            return "oops"
        }
        return result?.getStringExtra("resalt_fruit")!!
    }
}