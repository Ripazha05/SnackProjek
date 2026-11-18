package com.example.pratikummobilerifa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity : AppCompatActivity() {

    private var currentStep = 0

    private val titles = arrayOf(
        "Koleksi Perabot Terlengkap",
        "Promo & Diskon Spesial",
        "Pengiriman Cepat & Garansi"
    )

    private val descriptions = arrayOf(
        "Temukan berbagai perabot rumah tangga berkualitas tinggi dengan harga terbaik.",
        "Dapatkan potongan harga hingga 50% dan voucher menarik setiap harinya.",
        "Pesanan Anda dijamin aman dan dikirim langsung ke depan pintu rumah Anda."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val tvTitle = findViewById<TextView>(R.id.tvOnboardingTitle)
        val tvDesc = findViewById<TextView>(R.id.tvOnboardingDescription)
        val btnNext = findViewById<Button>(R.id.btnNextOnboarding)
        val btnSkip = findViewById<TextView>(R.id.btnSkipOnboarding)

        fun updateStep() {
            tvTitle.text = titles[currentStep]
            tvDesc.text = descriptions[currentStep]
            btnNext.text = if (currentStep == titles.size - 1) "Mulai Sekarang" else "Lanjut"
        }

        updateStep()

        btnNext.setOnClickListener {
            if (currentStep < titles.size - 1) {
                currentStep++
                updateStep()
            } else {
                finishOnboarding()
            }
        }

        btnSkip.setOnClickListener {
            finishOnboarding()
        }
    }

    private fun finishOnboarding() {
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        sharedPref.edit().putBoolean("isCompletedOnboarding", true).apply()

        val isLogin = sharedPref.getBoolean("isLogin", false)
        val targetClass = if (isLogin) BaseActivity::class.java else MainActivity::class.java
        val intent = Intent(this, targetClass)
        startActivity(intent)
        finish()
    }
}
