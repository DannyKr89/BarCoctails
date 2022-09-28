package com.dk.barcocktails

import android.content.res.Resources
import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.dk.barcocktails.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private var listFraments = listOf<Fragment>(VermouthAndBittersFragment(),WhiskeyFragment())
    lateinit var vp: ViewPager2
    lateinit var tabLayout: TabLayout
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vp = binding.viewPager
        tabLayout = binding.tabLayout

        vp.adapter = VpAdapter(this,listFraments)

        TabLayoutMediator(tabLayout,vp){tab,pos  ->
            
        }.attach()

    }








    /*   override fun onNavigationItemSelected(item: MenuItem): Boolean {
           when (item.itemId) {
               R.id.vermouth_and_bitters -> {
                   title.text = item.title
                   list = fillArray(
                       resources.getTextArray(R.array.vermouthAndBittersCocktails),
                       getImageId(R.array.imageCocktailsVermouthAndBitters)
                   )
                   rcCocktails.adapter = CocktailAdapter(list, this)
                   navDraw.close()
               }
               R.id.whiskey -> {
                   title.text = item.title
                   list = fillArray(
                       resources.getTextArray(R.array.whiskeyCocktails),
                       getImageId(R.array.imageCocktailsWhiskey)
                   )
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
                   list = fillArray(
                       resources.getTextArray(R.array.tequilaCocktails),
                       getImageId(R.array.imageCocktailsTequila)
                   )
                   rcCocktails.adapter = CocktailAdapter(list, this)
                   navDraw.close()
               }
               R.id.liquor_and_shots -> {
                   title.text = item.title
                   navDraw.close()
               }
           }
           return true
       }*/
}