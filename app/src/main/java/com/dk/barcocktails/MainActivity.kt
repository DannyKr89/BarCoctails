package com.dk.barcocktails

import android.content.res.TypedArray
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.RecyclerView
import com.dk.barcocktails.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var list = ArrayList<CocktailModel>()
    private lateinit var rcCocktails: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private lateinit var navDraw: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var title: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navView.setNavigationItemSelectedListener(this)

        title = binding.mainLayout.title
        navDraw = binding.navDraw
        navView = binding.navView
        rcCocktails = binding.mainLayout.rcCocktails
        rcCocktails.adapter = CocktailAdapter(list, this)

        binding.mainLayout.menuBttn.setOnClickListener() {
            navDraw.openDrawer(GravityCompat.START, true)
        }

        onNavigationItemSelected(navView.menu.getItem(0))
    }
    
    private fun fillArray(cocktails: Array<String>, imageArray:IntArray) : ArrayList<CocktailModel> {
        val coctailsArray = ArrayList<CocktailModel>()
        for (cocktal in cocktails.indices){
            var piece = cocktails.get(cocktal).split(',').toTypedArray()
            coctailsArray.add(CocktailModel(imageArray.get(cocktal),piece[0],piece[1],piece[2]))
        }
        return coctailsArray
    }


    fun getImageId(imageArrayId:Int) : IntArray{
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.vermouth_and_bitters -> {
                title.text = item.title
                list = fillArray(resources.getStringArray(R.array.vermouthAndBittersCocktails),getImageId(R.array.imageCocktails))
                rcCocktails.adapter = CocktailAdapter(list, this)
                navDraw.close()
            }
            R.id.whiskey -> {
                title.text = item.title
                list.clear()
                rcCocktails.adapter = CocktailAdapter(list, this)
                navDraw.close()
            }
            R.id.gin -> {
                title.text = item.title
                navDraw.close()
            }
            R.id.rum -> {
                title.text = item.title
                navDraw.close()
            }
            R.id.vodka -> {
                title.text = item.title
                navDraw.close()
            }
            R.id.tequila -> {
                title.text = item.title
                navDraw.close()
            }
            R.id.liquor_and_shots -> {
                title.text = item.title
                navDraw.close()
            }
        }
        return true
    }
}