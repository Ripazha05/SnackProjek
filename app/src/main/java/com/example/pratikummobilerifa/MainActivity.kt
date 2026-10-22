package com.example.pratikummobilerifa

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val etUsername = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnDaftar = findViewById<Button>(R.id.btnDaftar)

        btnLogin.setOnClickListener {
            val inputUsername = etUsername.text.toString().trim()
            val inputPassword = etPassword.text.toString().trim()

            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(this, "Username dan password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            val spUsername = sharedPref.getString("username", "") ?: ""
            val spPassword = sharedPref.getString("password", "") ?: ""

            // Rule 1: Jika username = password -> Boleh Login
            val isRule1Valid = inputUsername == inputPassword

            // Rule 2: Jika username = username di SharedPreferences dan password = password di SharedPreferences -> Boleh Login
            val isRule2Valid = spUsername.isNotEmpty() && inputUsername == spUsername && inputPassword == spPassword

            if (isRule1Valid || isRule2Valid) {
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username", if (isRule2Valid) spUsername else inputUsername)
                editor.apply()

                Toast.makeText(this, "Berhasil masuk", Toast.LENGTH_SHORT).show()

                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, BaseActivity::class.java)
                    startActivity(intent)
                    finish()
                }, 800)
            } else {
                Toast.makeText(this, "Username atau password salah!", Toast.LENGTH_SHORT).show()
            }
        }

        btnDaftar.setOnClickListener {
            val intent = Intent(this, DaftarActivity::class.java)
            startActivity(intent)
        }
    }
}
