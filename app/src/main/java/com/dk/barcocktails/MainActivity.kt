package com.dk.barcocktails

import android.content.res.TypedArray
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var navDraw: DrawerLayout? = null
    private var title: TextView? = null
    private var list : ArrayList<CocktailModel>? = null
    private var rcCocktails: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<NavigationView>(R.id.nav_view).setNavigationItemSelectedListener(this)
        list = ArrayList<CocktailModel>()

        title = findViewById(R.id.title)

        navDraw =findViewById(R.id.navDraw)

        findViewById<ImageButton>(R.id.menuBttn).setOnClickListener() {
            navDraw?.openDrawer(GravityCompat.START, true)
        }

        list = (fillArray(resources.getStringArray(R.array.vermouthAndBittersCocktails),getImageId(R.array.imageCocktails))!!)
        rcCocktails = findViewById<RecyclerView>(R.id.rcCocktails)
        rcCocktails?.adapter = CocktailAdapter(list!!, this)

    }
    
    fun fillArray(cocktails: Array<String>, imageArray:IntArray) : ArrayList<CocktailModel> {
        var coctailsArray = ArrayList<CocktailModel>()
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
            R.id.all_cocktails -> {
                title?.text = item.title
                navDraw?.close()
            }
            R.id.vermouth_and_bitters -> {
                list = fillArray(resources.getStringArray(R.array.vermouthAndBittersCocktails),getImageId(R.array.imageCocktails))!!
                rcCocktails?.adapter = CocktailAdapter(list!!, this)
                title?.text = item.title
                navDraw?.close()
            }
            R.id.whiskey -> {
                title?.text = item.title
                navDraw?.close()
            }
            R.id.gin -> {
                title?.text = item.title
                navDraw?.close()
            }
            R.id.rum -> {
                title?.text = item.title
                navDraw?.close()
            }
            R.id.vodka -> {
                title?.text = item.title
                navDraw?.close()
            }
            R.id.tequila -> {
                title?.text = item.title
                navDraw?.close()
            }
            R.id.liquor_and_shots -> {
                title?.text = item.title
                navDraw?.close()
            }
        }
        return true
    }
}