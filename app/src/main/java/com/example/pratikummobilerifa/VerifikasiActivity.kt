package com.example.pratikummobilerifa

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pratikummobilerifa.pertemuan_3.ThirdResultActivity

class VerifikasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_verifikasi)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvValNama = findViewById<TextView>(R.id.tvValNama)
        val tvValEmail = findViewById<TextView>(R.id.tvValEmail)
        val tvValTanggalLahir = findViewById<TextView>(R.id.tvValTanggalLahir)
        val tvValJenisKelamin = findViewById<TextView>(R.id.tvValJenisKelamin)
        val tvValUsername = findViewById<TextView>(R.id.tvValUsername)
        val tvValPassword = findViewById<TextView>(R.id.tvValPassword)
        val tvValConfirmPassword = findViewById<TextView>(R.id.tvValConfirmPassword)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)

        val nama = sharedPref.getString("nama", "") ?: ""
        val email = sharedPref.getString("email", "") ?: ""
        val tanggalLahir = sharedPref.getString("tanggal_lahir", "") ?: ""
        val jenisKelamin = sharedPref.getString("jenis_kelamin", "") ?: ""
        val username = sharedPref.getString("username", "") ?: ""
        val password = sharedPref.getString("password", "") ?: ""
        val confirmPassword = sharedPref.getString("confirm_password", "") ?: ""

        // Tampilkan seluruh isian yang tersimpan di SharedPreferences
        tvValNama.text = if (nama.isEmpty()) "(kosong)" else nama
        tvValEmail.text = if (email.isEmpty()) "(kosong)" else email
        tvValTanggalLahir.text = if (tanggalLahir.isEmpty()) "(kosong)" else tanggalLahir
        tvValJenisKelamin.text = if (jenisKelamin.isEmpty()) "(kosong)" else jenisKelamin
        tvValUsername.text = if (username.isEmpty()) "(kosong)" else username
        tvValPassword.text = if (password.isEmpty()) "(kosong)" else password
        tvValConfirmPassword.text = if (confirmPassword.isEmpty()) "(kosong)" else confirmPassword

        btnSubmit.setOnClickListener {

            if (nama.isEmpty() || email.isEmpty() || tanggalLahir.isEmpty() ||
                jenisKelamin.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()
            ) {
                Toast.makeText(this, "Semua inputan tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 2. Password dan Confirm Password harus sama
            if (password != confirmPassword) {
                Toast.makeText(this, "Password dan Confirm Password harus sama!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Jika berhasil melewati validasi, tampilkan halaman "Registrasi Berhasil"
            val editor = sharedPref.edit()
            editor.putBoolean("isRegistered", true)
            editor.apply()

            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Tombol Kembali untuk kembali ke halaman registrasi
        btnKembali.setOnClickListener {
            finish()
        }
    }
}
