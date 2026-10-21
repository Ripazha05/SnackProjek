package com.example.pratikummobilerifa

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {

            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putBoolean("isLogin", true)
            editor.putString("username", "Ripaaulia")
            editor.apply()

            Toast.makeText(
                this,
                "Berhasil masuk",
                Toast.LENGTH_SHORT
            ).show()

            Handler(Looper.getMainLooper()).postDelayed({

                val intent = Intent(
                    this,
                    BaseActivity::class.java
                )
                startActivity(intent)
                finish()

            }, 800)
        }
    }
}
