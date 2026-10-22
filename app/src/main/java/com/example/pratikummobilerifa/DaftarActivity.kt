package com.example.pratikummobilerifa

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class DaftarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_daftar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNama = findViewById<EditText>(R.id.etNama)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etTanggalLahir = findViewById<EditText>(R.id.etTanggalLahir)
        val rgJenisKelamin = findViewById<RadioGroup>(R.id.rgJenisKelamin)
        val rbLaki = findViewById<RadioButton>(R.id.rbLaki)
        val rbPerempuan = findViewById<RadioButton>(R.id.rbPerempuan)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val btnSelanjutnya = findViewById<Button>(R.id.btnSelanjutnya)

        val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)

        etNama.setText(sharedPref.getString("nama", ""))
        etEmail.setText(sharedPref.getString("email", ""))
        etTanggalLahir.setText(sharedPref.getString("tanggal_lahir", ""))
        etUsername.setText(sharedPref.getString("username", ""))
        etPassword.setText(sharedPref.getString("password", ""))
        etConfirmPassword.setText(sharedPref.getString("confirm_password", ""))

        val savedGender = sharedPref.getString("jenis_kelamin", "")
        if (savedGender == "Laki-Laki") {
            rbLaki.isChecked = true
        } else if (savedGender == "Perempuan") {
            rbPerempuan.isChecked = true
        }

        // DatePicker untuk Tanggal Lahir
        etTanggalLahir.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    etTanggalLahir.setText(formattedDate)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }


        btnSelanjutnya.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val tanggalLahir = etTanggalLahir.text.toString().trim()
            val selectedGenderId = rgJenisKelamin.checkedRadioButtonId
            val jenisKelamin = when (selectedGenderId) {
                R.id.rbLaki -> "Laki-Laki"
                R.id.rbPerempuan -> "Perempuan"
                else -> ""
            }
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            val editor = sharedPref.edit()
            editor.putString("nama", nama)
            editor.putString("email", email)
            editor.putString("tanggal_lahir", tanggalLahir)
            editor.putString("jenis_kelamin", jenisKelamin)
            editor.putString("username", username)
            editor.putString("password", password)
            editor.putString("confirm_password", confirmPassword)
            editor.apply()

            val intent = Intent(this, VerifikasiActivity::class.java)
            startActivity(intent)
        }
    }
}
