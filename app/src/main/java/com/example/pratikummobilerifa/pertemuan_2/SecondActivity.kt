package com.example.pratikummobilerifa.pertemuan_2

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.pratikummobilerifa.R
import com.example.pratikummobilerifa.pertemuan_3.ThirdActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val navAccount = findViewById<LinearLayout>(R.id.navAccount)
        navAccount.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
