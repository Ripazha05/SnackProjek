package com.example.pratikummobilerifa

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pratikummobilerifa.pertemuan_2.SecondActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {

            // Menampilkan pesan di bagian bawah
            Toast.makeText(
                this,
                "Berhasil masuk",
                Toast.LENGTH_SHORT
            ).show()

            // Menunggu sebentar kemudian pindah ke katalog
            Handler(Looper.getMainLooper()).postDelayed({

                val intent = Intent(
                    this,
                    SecondActivity::class.java
                )

                startActivity(intent)

            }, 800)
        }
    }
}