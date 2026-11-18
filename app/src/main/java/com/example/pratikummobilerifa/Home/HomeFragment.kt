package com.example.pratikummobilerifa.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pratikummobilerifa.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvProducts = view.findViewById<RecyclerView>(R.id.rvProducts)

        val productList = listOf(
            Product("Sofa Minimalis Oslo", "Rp 4.250.000", "4.8", R.drawable.oslo),
            Product("Meja Makan Kayu Jati", "Rp 5.700.000", "4.9", R.drawable.jati),
            Product("Kursi Goyang Retro", "Rp 1.850.000", "4.7", R.drawable.kursigoyang),
            Product("Lemari Pakaian 3 Pintu", "Rp 3.100.000", "4.8", R.drawable.lemari),
            Product("Rak TV Minimalis", "Rp 1.250.000", "4.6", R.drawable.jati),
            Product("Sofa Santai Modern", "Rp 2.950.000", "4.9", R.drawable.oslo)
        )

        rvProducts?.layoutManager = GridLayoutManager(requireContext(), 2)
        rvProducts?.adapter = ProductAdapter(productList) { _ ->
            val bottomSheet = ProductBottomSheet()
            bottomSheet.show(parentFragmentManager, "ProductBottomSheet")
        }

        val cardRec = view.findViewById<LinearLayout>(R.id.cardRecommendation)
        cardRec?.setOnClickListener {
            val bottomSheet = ProductBottomSheet()
            bottomSheet.show(parentFragmentManager, "ProductBottomSheet")
        }
    }
}
