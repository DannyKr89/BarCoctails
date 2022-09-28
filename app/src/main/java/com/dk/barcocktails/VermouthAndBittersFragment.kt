package com.dk.barcocktails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dk.barcocktails.databinding.FragmentVermouthAndBittersBinding

class VermouthAndBittersFragment : Fragment() {
    private val imList = intArrayOf(
        R.drawable.veneta_spritzer,
        R.drawable.pear_spritzer,
        R.drawable.martini_fiero_tonic,
        R.drawable.martini_bianca_tonic,
        R.drawable.honey_sangria,
        R.drawable.pink_sangria,
        R.drawable.mishka_sour,
        R.drawable.glentwine,
        R.drawable.ic_menu
    )

    lateinit var bittersBinding: FragmentVermouthAndBittersBinding
    lateinit var rcVaB: RecyclerView
    lateinit var adapter: CocktailAdapter
    val fillRecyclerView = FillRecyclerView()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bittersBinding = FragmentVermouthAndBittersBinding.inflate(inflater, container, false)
        return bittersBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = fillRecyclerView.fillArray(resources.getTextArray(R.array.vermouthAndBittersCocktails),
            imList)

        adapter = CocktailAdapter(list, requireContext())

        rcVaB = bittersBinding.rcVaB
        rcVaB.adapter = adapter

    }

}