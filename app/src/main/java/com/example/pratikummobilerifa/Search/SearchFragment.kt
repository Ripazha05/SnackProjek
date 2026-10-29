package com.example.pratikummobilerifa.Search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.pratikummobilerifa.R

class SearchFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var searchView: SearchView
    private lateinit var adapter: ArrayAdapter<String>
    private val myList = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = view.findViewById(R.id.listView)
        searchView = view.findViewById(R.id.searchView)

        // Add items
        myList.add("Sofa Minimalis Oslo")
        myList.add("Meja Makan Kayu")
        myList.add("Kursi Goyang Retro")
        myList.add("Lemari Pakaian 3 Pintu")
        myList.add("Rak TV Kayu Jati")
        myList.add("Kasur Spring Bed Nyaman")
        myList.add("Meja Belajar Minimalis")

        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, myList)
        listView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
    }
}
