package com.example.pratikummobilerifa.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.pratikummobilerifa.R
import com.example.pratikummobilerifa.pertemuan_2.SecondActivity

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Akun Saya"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val navHome = findViewById<LinearLayout>(R.id.navHome)
        navHome.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }

        val btnTentang = findViewById<LinearLayout>(R.id.btnTentangAplikasi)
        btnTentang.setOnClickListener {
            val intent = Intent(this, WebActivity::class.java)
            startActivity(intent)
        }
    }
}
