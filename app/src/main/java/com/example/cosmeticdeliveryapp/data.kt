package com.example.cosmeticdeliveryapp

import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.example.cosmeticdeliveryapp.model.ModelCategory


class data {
    lateinit var listCategory:ArrayList<ModelCategory>
    constructor()
    fun getDataCategory():ArrayList<ModelCategory>{
        listCategory= ArrayList()
        var faceItem = ModelCategory("1","Face",111,"abc","R.drawable.face.png")
        listCategory.add(faceItem)
        var eyeItem = ModelCategory("1","Eye",111,"abc","")
        listCategory.add(eyeItem)
        return listCategory
    }
}