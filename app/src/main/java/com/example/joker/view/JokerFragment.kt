package com.example.joker.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.joker.R
import com.example.joker.model.Joke
import com.example.joker.presentation.JokePresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class JokerFragment : Fragment() {

    private lateinit var progress: ProgressBar
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView

    private lateinit var presenter: JokePresenter


    companion object {
        val CATEGORY_KEY = "category"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = JokePresenter(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryName = arguments?.getString(CATEGORY_KEY)

        activity?.findViewById<Toolbar>(R.id.toolbar)?.title = categoryName!!

        progress = view.findViewById(R.id.progress_bar)
        textView = view.findViewById(R.id.txt_joker)

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener{
            presenter.findBy(categoryName)
        }

        presenter.findBy(categoryName)
    }

    fun showJoker(joke: Joke) {
        textView.text = joke.text
    }

    fun showProgress(){
        progress.visibility = View.VISIBLE
    }

    fun hideProgress(){
        progress.visibility = View.GONE
    }

    fun showFailure(message:String){
        Toast.makeText(requireContext(),message,Toast.LENGTH_LONG).show()
    }
}