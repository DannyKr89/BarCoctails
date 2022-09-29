package com.dk.barcocktails.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dk.barcocktails.databinding.FragmentWhiskeyBinding

class WhiskeyFragment : Fragment() {
    lateinit var whiskeyBinding: FragmentWhiskeyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        whiskeyBinding = FragmentWhiskeyBinding.inflate(inflater, container, false)
        return whiskeyBinding.root
    }

}