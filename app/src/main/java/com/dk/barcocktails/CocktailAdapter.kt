package com.dk.barcocktails

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dk.barcocktails.databinding.ItemCocktailBinding

class CocktailAdapter(private val listCocktails: ArrayList<CocktailModel>,
                      private val context: Context
) :
    RecyclerView.Adapter<CocktailAdapter.ViewHolder>() {


    class ViewHolder(val binding: ItemCocktailBinding) : RecyclerView.ViewHolder(binding.root) {

        val tvTitle = binding.tvTitle
        val tvDescriptionL = binding.tvDescriptionLeft
        val tvDescriptionR = binding.tvDescriptionRight
        val im = binding.imCocktails
        val cocktailCard = binding.cocktailCard


        fun bind(cocktailModel: CocktailModel, context: Context) {
            tvTitle.text = cocktailModel.titleCocktail
            tvDescriptionL.text = cocktailModel.descCocktailColOne
            tvDescriptionR.text = cocktailModel.descCocktailColTwo
            im.setImageResource(cocktailModel.image_id)
            cocktailCard.setOnClickListener() {
                Toast.makeText(context, "pressed ${tvTitle.text}", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCocktailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var cocktailModel = listCocktails.get(position)
        holder.bind(cocktailModel, context)
    }

    override fun getItemCount(): Int {
        return listCocktails.size
    }
}