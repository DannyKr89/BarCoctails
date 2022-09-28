package com.dk.barcocktails

import android.content.res.Resources
import android.content.res.TypedArray

class FillRecyclerView {

    fun fillArray(cocktails: Array<CharSequence>, intArray: IntArray): ArrayList<Cocktail> {
        val coctailsArray = ArrayList<Cocktail>()
        for (cocktal in cocktails.indices) {
            var piece = cocktails.get(cocktal).split(',').toTypedArray()
            coctailsArray.add(
                Cocktail(
                    piece[0],
                    piece[1],
                    piece[2],
                    piece[3],
                    intArray[cocktal]
                )
            )
        }
        return coctailsArray
    }

    fun getImageId(imageArrayId: Int): IntArray {
        var tArray: TypedArray = Resources.getSystem().obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }

}