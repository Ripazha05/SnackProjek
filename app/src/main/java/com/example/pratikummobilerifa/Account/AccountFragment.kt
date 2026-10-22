package com.example.pratikummobilerifa.Account

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pratikummobilerifa.MainActivity
import com.example.pratikummobilerifa.R
import com.example.pratikummobilerifa.pertemuan_3.DeveloperActivity
import com.example.pratikummobilerifa.pertemuan_3.WebActivity

class AccountFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        val btnTentang = view.findViewById<View>(R.id.btnTentangAplikasi)
        btnTentang?.setOnClickListener {
            val intent = Intent(requireContext(), WebActivity::class.java)
            startActivity(intent)
        }

        val btnDeveloper = view.findViewById<View>(R.id.btnProfilDeveloper)
        btnDeveloper?.setOnClickListener {
            val intent = Intent(requireContext(), DeveloperActivity::class.java)
            startActivity(intent)
        }

        val btnLogout = view.findViewById<View>(R.id.btnLogoutAccount)
        btnLogout?.setOnClickListener {
            val sharedPref = requireActivity().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        return view
    }
}
