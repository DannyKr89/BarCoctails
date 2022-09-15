package com.dk.barcocktails

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dk.barcocktails.databinding.ItemCocktailBinding

class CocktailAdapter(private val listCocktails: ArrayList<Cocktail>,
                      private val context: Context
) :
    RecyclerView.Adapter<CocktailAdapter.ViewHolder>() {


    class ViewHolder(val binding: ItemCocktailBinding) : RecyclerView.ViewHolder(binding.root) {

        val tvTitle = binding.tvTitle
        val tvDescriptionL = binding.tvDescriptionLeft
        val tvDescriptionR = binding.tvDescriptionRight
        val im = binding.imCocktails
        val cocktailCard = binding.cocktailCard
        val tvMethod = binding.tvMethod
        val tvDishes = binding.tvDishes
        val tvDecoration = binding.tvDecoration
        val tvIce = binding.tvIce


        fun bind(cocktail: Cocktail, context: Context) {
            tvTitle.text = cocktail.titleCocktail
            tvDescriptionL.text = cocktail.descCocktailColOne
            tvDescriptionR.text = cocktail.descCocktailColTwo
            val misc = cocktail.misc.split('$').toTypedArray()
            tvMethod.text = misc[0]
            tvDishes.text = misc[1]
            tvDecoration.text = misc[2]
            tvIce.text = misc[3]
            im.setImageResource(cocktail.image_id)
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