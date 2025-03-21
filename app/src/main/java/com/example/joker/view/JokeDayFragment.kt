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
import com.example.joker.presentation.JokeDayPresenter
import com.squareup.picasso.Picasso

class JokeDayFragment:Fragment() {

    private lateinit var progress: ProgressBar
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView

    private lateinit var presenter: JokeDayPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = JokeDayPresenter(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frgment_joke_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.findViewById<Toolbar>(R.id.toolbar)?.title = getString(R.string.menu_joke_day)

        progress = view.findViewById(R.id.progress_bar)
        textView = view.findViewById(R.id.txt_joker)
        imageView = view.findViewById(R.id.img_joke)


        presenter.findRandom()
    }

    fun showJoker(joke: Joke) {
        textView.text = joke.text
        Picasso.get().load((joke.iconUrl)).into(imageView)
    }

    fun showProgress(){
        progress.visibility = View.VISIBLE
    }

    fun hideProgress(){
        progress.visibility = View.GONE
    }

    fun showFailure(message:String){
        Toast.makeText(requireContext(),message, Toast.LENGTH_LONG).show()
    }
}