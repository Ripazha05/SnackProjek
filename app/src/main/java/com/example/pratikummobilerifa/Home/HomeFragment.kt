package com.example.pratikummobilerifa.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
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

        val card1 = view.findViewById<LinearLayout>(R.id.cardProduct1)
        val card2 = view.findViewById<LinearLayout>(R.id.cardProduct2)
        val cardRec = view.findViewById<LinearLayout>(R.id.cardRecommendation)

        card1?.setOnClickListener {
            val bottomSheet = ProductBottomSheet()
            bottomSheet.show(parentFragmentManager, "ProductBottomSheet")
        }

        card2?.setOnClickListener {
            val bottomSheet = ProductBottomSheet()
            bottomSheet.show(parentFragmentManager, "ProductBottomSheet")
        }

        cardRec?.setOnClickListener {
            val bottomSheet = ProductBottomSheet()
            bottomSheet.show(parentFragmentManager, "ProductBottomSheet")
        }
    }
}
