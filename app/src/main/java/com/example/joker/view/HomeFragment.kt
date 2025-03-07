package com.example.joker.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.joker.R
import com.example.joker.model.Category
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvMain = view.findViewById<RecyclerView>(R.id.rv_main)
        rvMain.layoutManager = LinearLayoutManager(requireContext())

        val adapter = GroupieAdapter()
        rvMain.adapter = adapter


        adapter.add(CategoryItem(Category("Category 1", 0xFFEB5A3C)))
        adapter.add(CategoryItem(Category("Category 2", 0xFFDF9755)))
        adapter.add(CategoryItem(Category("Category 3", 0xFFE7D283)))
        adapter.add(CategoryItem(Category("Category 4", 0xFFEDF4C2)))

        adapter.notifyDataSetChanged()

    }
}