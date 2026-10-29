package com.example.pratikummobilerifa.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.example.pratikummobilerifa.R

class ProductBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.bottom_sheet_layout, container, false)

        val button1 = v.findViewById<Button>(R.id.button_1)
        val button2 = v.findViewById<Button>(R.id.button_2)

        button1.setOnClickListener {
            Toast.makeText(activity, "Produk ditambahkan ke keranjang", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        button2.setOnClickListener {
            Toast.makeText(activity, "Melanjutkan ke pembelian", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        return v
    }
}
