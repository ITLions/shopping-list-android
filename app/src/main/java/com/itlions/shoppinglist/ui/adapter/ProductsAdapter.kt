package com.itlions.shoppinglist.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.model.Product
import com.itlions.shoppinglist.ui.utils.LetterTileProvider
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.layoutInflater
import java.util.*

/**
 * TODO implement javadoc
 */
class ProductAdapter(val context: Context) : RecyclerView.Adapter<ProductAdapter.VH>() {

    val layoutInflater: LayoutInflater = context.layoutInflater

    var products: List<Product> = ArrayList<Product>()
    var letterColorProvider = LetterTileProvider(context)
    var listener: ((View, Product) -> Unit)? = null

    override fun getItemCount(): Int = products?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH? {
        val view = layoutInflater.inflate(R.layout.item_main, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH?, position: Int) {
        val product = products?.get(position)
        holder?.title?.text = product?.name
        holder?.background?.backgroundColor = letterColorProvider.pickColor(product?.name)
        holder?.itemView?.setOnClickListener {
            listener?.invoke(holder?.itemView, product!!)
        }
    }

    fun setOnClickListener(listener: (View, Product) -> Unit) {
        this.listener = listener
    }

    fun initWithProducts(products: List<Product>) {
        this.products = products;
    }

    fun addProduct(p: Product) {
        (products as ArrayList).add(p);
        notifyDataSetChanged()
    }

    fun deleteProduct(position: Int) {
        (products as ArrayList).removeAt(position);
        notifyItemChanged(position)
    }

    inner class VH(val v: View) : RecyclerView.ViewHolder(v) {
        val background = itemView.findViewById(R.id.img_item_background) as ImageView
        val title = itemView.findViewById(R.id.txt_item_name) as TextView
    }
}