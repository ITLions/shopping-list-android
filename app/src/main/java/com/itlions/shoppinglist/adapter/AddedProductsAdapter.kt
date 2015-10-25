package com.itlions.shoppinglist.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.model.Product
import com.squareup.picasso.Picasso
import org.jetbrains.anko.layoutInflater

/**
 * TODO implement javadoc
 */
class AddedProductAdapter(val context : Context) : RecyclerView.Adapter<AddedProductAdapter.VH>() {

    var products : List<Product>? = null
    val layoutInflater : LayoutInflater = context.layoutInflater

    override fun getItemCount(): Int = products?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH? {
        val view = layoutInflater.inflate(R.layout.item_main, parent)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH?, position: Int) {
        val product = products?.get(position)
        Picasso.with(context).load(product?.icon).into(holder?.background)
        holder?.title?.text = product?.name
    }

    fun initWithItem(products : List<Product>) {
        this.products = products;
    }

    inner class VH(val v : View) : RecyclerView.ViewHolder(v) {
        val background = itemView.findViewById(R.id.img_item_background) as ImageView
        val title = itemView.findViewById(R.id.txt_item_name) as TextView
    }
}