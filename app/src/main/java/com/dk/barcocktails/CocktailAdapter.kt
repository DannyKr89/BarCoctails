package com.dk.barcocktails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CocktailAdapter(listCocktails: ArrayList<CocktailModel>, context: Context) :
    RecyclerView.Adapter<CocktailAdapter.ViewHolder>() {
    val listCocktails = listCocktails
    val context = context


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvDescriptionL = view.findViewById<TextView>(R.id.tvDescriptionLeft)
        val tvDescriptionR = view.findViewById<TextView>(R.id.tvDescriptionRight)
        val im = view.findViewById<ImageView>(R.id.imCocktails)
        val cocktailCard = view.findViewById<CardView>(R.id.cocktailCard)

        fun bind(cocktailModel: CocktailModel, context: Context) {
            tvTitle.text = cocktailModel.titleCocktail
            tvDescriptionL.text = cocktailModel.descCocktailColOne
            tvDescriptionR.text = cocktailModel.descCocktailColTwo
            im.setImageResource(cocktailModel.image_id)
            cocktailCard.setOnClickListener(){
                Toast.makeText(context,"pressed ${tvTitle.text}", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_cocktail, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var cocktailModel = listCocktails.get(position)
        holder.bind(cocktailModel, context)
    }

    override fun getItemCount(): Int {
        return listCocktails.size
    }
}