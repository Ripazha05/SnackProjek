package com.example.pratikummobilerifa

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.pratikummobilerifa.Account.AccountFragment
import com.example.pratikummobilerifa.Category.CategoryFragment
import com.example.pratikummobilerifa.Home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Beranda diklik", Toast.LENGTH_SHORT).show()
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_category -> {
                    Toast.makeText(this, "Kategori diklik", Toast.LENGTH_SHORT).show()
                    loadFragment(CategoryFragment())
                    true
                }
                R.id.nav_account -> {
                    Toast.makeText(this, "Akun diklik", Toast.LENGTH_SHORT).show()
                    loadFragment(AccountFragment())
                    true
                }
                else -> false
            }
        }

        if (savedInstanceState == null) {
            bottomNavView.selectedItemId = R.id.nav_home
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
