package com.example.cosmeticdeliveryapp.RcvAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.cosmeticdeliveryapp.R
import com.example.cosmeticdeliveryapp.RcvAdapter.RcvPopular.ProductHolder
import com.example.cosmeticdeliveryapp.databinding.RcvItemPopularBinding
import com.example.cosmeticdeliveryapp.model.ModelCategory
import com.example.cosmeticdeliveryapp.ui.ItemDetail


class RcvPopular: RecyclerView.Adapter<ProductHolder> {
    private lateinit var binding: RcvItemPopularBinding

    private var context: Context
    public var productPArraylist: ArrayList<ModelCategory>

    constructor(context: Context, categopryArraylist: ArrayList<ModelCategory>) {
        this.context = context
        this.productPArraylist = categopryArraylist
    }

    inner class ProductHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var productPop:TextView = binding.productTitle
        var productPp: TextView = binding.productPrice
        var imageP: NetworkImageView = binding.productImage
        var view : CardView = binding.itemPopular
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        binding = RcvItemPopularBinding.inflate(LayoutInflater.from(context), parent, false)

        return ProductHolder(binding.root)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: RcvPopular.ProductHolder, position: Int) {
        val model = productPArraylist[position]
        val categoryType = model.category
        val imageUrl=model.imageUrl
        holder.productPop.text = categoryType
        val imgUri = imageUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(holder.imageP.context)
            .load(imgUri)
            .centerCrop()
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
            .into(holder.imageP)
        holder.view.setOnClickListener {
            gotoDetailItem(model.id)
        }
    }
    private fun gotoDetailItem(idItem:String ){
        val intent = Intent(context, ItemDetail::class.java)
        intent.putExtra("foodId", idItem)

        context.startActivity(intent)
    }
    override fun getItemCount(): Int {
        return productPArraylist.size
    }

}