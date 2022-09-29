package com.dk.barcocktails.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dk.barcocktails.R
import com.dk.barcocktails.adapters.CocktailAdapter
import com.dk.barcocktails.databinding.FragmentWhiskeyBinding
import com.dk.barcocktails.domain.FillRecyclerView

class WhiskeyFragment : Fragment() {
    private val imList = intArrayOf(
    R.drawable.bushmills_3_1,
    R.drawable.bushmils_cola,
    R.drawable.old_fashioned,
    R.drawable.manhattan,
    R.drawable.penicillin,
    R.drawable.fire_breeze,
    R.drawable.apple_jack,
    R.drawable.hello_honey,
    R.drawable.bushmills_sour,
    R.drawable.red_hot_chili_sour,
    R.drawable.mint_julep,
    R.drawable.favorite_singer,
    R.drawable.irish_coffee,
    R.drawable.forever_young
    )

    lateinit var whiskeyBinding: FragmentWhiskeyBinding
    lateinit var rcW: RecyclerView
    lateinit var adapter: CocktailAdapter
    val fillRecyclerView = FillRecyclerView()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        whiskeyBinding = FragmentWhiskeyBinding.inflate(inflater, container, false)
        return whiskeyBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = fillRecyclerView.fillArray(resources.getTextArray(R.array.whiskeyCocktails),
            imList)

        adapter = CocktailAdapter(list)

        rcW = whiskeyBinding.rcW
        rcW.adapter = adapter
    }

}