package com.itlions.shoppinglist.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.model.Category
import com.itlions.shoppinglist.ui.utils.LetterTileProvider
import com.squareup.picasso.Picasso
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.layoutInflater
import kotlin.properties.Delegates

/**
 * TODO implement javadoc
 */
class CategoriesAdapter(val context : Context) : RecyclerView.Adapter<CategoriesAdapter.VH>(){

    val layoutInflater = context.layoutInflater
    var letterColorProvider = LetterTileProvider(context)
    var categories : List<Category>? = null
    var listener : ((View, Category) -> Unit)? = null

    fun initWithCategories(list : List<Category>) {
        categories = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: VH?, position: Int) {
        val product = categories?.get(position)
        holder?.background?.backgroundColor = letterColorProvider.pickColor(product?.name)
        holder?.title?.text = product?.name
        holder?.itemView?.setOnClickListener {
            listener?.invoke(holder?.itemView, product!!)
        }
    }

    fun setOnClickListener(listener : (View, Category) -> Unit) {
        this.listener = listener
    }

    override fun getItemCount(): Int = categories?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH? {
        val view = layoutInflater.inflate(R.layout.item_main, parent, false)
        return VH(view)
    }

    inner class VH(val v : View) : RecyclerView.ViewHolder(v) {
        val background = itemView.findViewById(R.id.img_item_background) as ImageView
        val title = itemView.findViewById(R.id.txt_item_name) as TextView
    }
}