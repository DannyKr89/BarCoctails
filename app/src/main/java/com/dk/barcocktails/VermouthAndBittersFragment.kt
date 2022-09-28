package com.dk.barcocktails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dk.barcocktails.databinding.FragmentVermouthAndBittersBinding

class VermouthAndBittersFragment : Fragment() {
    lateinit var bittersBinding: FragmentVermouthAndBittersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bittersBinding = FragmentVermouthAndBittersBinding.inflate(inflater, container, false)
        return bittersBinding.root
    }

}