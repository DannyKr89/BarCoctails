package com.dk.barcocktails.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dk.barcocktails.R
import com.dk.barcocktails.adapters.CocktailAdapter
import com.dk.barcocktails.databinding.FragmentTequilaBinding
import com.dk.barcocktails.domain.FillRecyclerView

class TequilaFragment : Fragment() {
    private val imList = intArrayOf(
        R.drawable.margarita,
        R.drawable.flirting_margarita,
        R.drawable.michelada,
        R.drawable.tequila_sunrise
    )

    lateinit var tequilaBinding: FragmentTequilaBinding
    lateinit var rcT: RecyclerView
    lateinit var adapter: CocktailAdapter
    val fillRecyclerView = FillRecyclerView()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tequilaBinding = FragmentTequilaBinding.inflate(layoutInflater, container, false)
        return tequilaBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = fillRecyclerView.fillArray(resources.getTextArray(R.array.tequilaCocktails),
            imList)

        adapter = CocktailAdapter(list)

        rcT = tequilaBinding.rcT
        rcT.adapter = adapter
    }
}