package com.example.joker.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.joker.R
import com.example.joker.data.CategoryRemoteDataSource
import com.example.joker.model.Category
import com.example.joker.presentation.HomePresenter
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

    private lateinit var presenter:HomePresenter
    private lateinit var adapter:GroupieAdapter
    private lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataSource = CategoryRemoteDataSource()
        presenter = HomePresenter(this,dataSource)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    fun showProgress(){
        progress.visibility = View.VISIBLE
    }

    fun hideProgress(){
        progress.visibility = View.GONE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvMain = view.findViewById<RecyclerView>(R.id.rv_main)
        rvMain.layoutManager = LinearLayoutManager(requireContext())
        progress = view.findViewById(R.id.progress_bar)

        presenter.findAllCategories()

        adapter = GroupieAdapter()
        rvMain.adapter = adapter

    }

    fun onError(message:String){

    }

    fun showCategories(categories:List<Category>){
        adapter.addAll(categories.map {
            CategoryItem(it)
        })
        adapter.notifyDataSetChanged()

    }
}