package com.example.cosmeticdeliveryapp.RcvAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.cosmeticdeliveryapp.R
import com.example.cosmeticdeliveryapp.databinding.RcvItemCategoryBinding
import com.example.cosmeticdeliveryapp.model.ModelCategory


class RcvCategories: RecyclerView.Adapter<RcvCategories.CategoryHolder> {
    private lateinit var binding:RcvItemCategoryBinding

    private var context: Context
    public var categopryArraylist: ArrayList<ModelCategory>

    constructor(context: Context, categopryArraylist: ArrayList<ModelCategory>) {
        this.context = context
        this.categopryArraylist = categopryArraylist
    }

    inner class CategoryHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var categoryTv:TextView = binding.itemFace
        var categoryIv: ImageView = binding.imageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        binding = RcvItemCategoryBinding.inflate(LayoutInflater.from(context), parent, false)

        return CategoryHolder(binding.root)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val model = categopryArraylist[position]
        val categoryType = model.category
        val imageUrl=model.imageUrl
        holder.categoryTv.text = categoryType
        val imgUri = imageUrl.toUri().buildUpon().scheme("https").build()
            Glide.with(holder.categoryIv.context)
            .load(imgUri)
            .centerCrop()
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
            .into(holder.categoryIv)
    }

    override fun getItemCount(): Int {
        return categopryArraylist.size
    }


}