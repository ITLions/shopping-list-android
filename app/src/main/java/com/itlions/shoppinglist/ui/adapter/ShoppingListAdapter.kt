package com.itlions.shoppinglist.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.model.ProductList
import kotlin.properties.Delegates

/**
 * Created by omazhukin on 10/19/2015.
 */

class ShoppingListAdapter(private val context: Context) : RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {


    private var itemsList: List<ProductList>? = null
    private val lInflater: LayoutInflater
    var listener: ((View, ProductList) -> Unit)? = null

    init {
        lInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun onBindViewHolder(holder: ShoppingListAdapter.ViewHolder?, position: Int) {
        var productList = getItem(position)
        holder?.title?.text = productList.name
        holder?.itemView?.setOnClickListener { view ->
            listener?.invoke(view, productList)
        }
    }

    override fun getItemCount() = if (itemsList == null)  0 else itemsList!!.size()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ShoppingListAdapter.ViewHolder {
        var convertView = lInflater.inflate(R.layout.item_shopping_list, parent, false)
        return ViewHolder(convertView)
    }

    fun setOnClickListener(listener: (View, ProductList) -> Unit) {
        this.listener = listener
    }

    fun getItem(position: Int): ProductList {
        return itemsList!!.get(position)
    }

    fun updateData(productList: List<ProductList>?) {
        itemsList = productList;
        notifyDataSetChanged()
    }

    inner class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView by Delegates.notNull<TextView>()
        var checkBox: CheckBox by Delegates.notNull<CheckBox>()

        init {
            title = view.findViewById(R.id.txt_list_title) as TextView
            checkBox = view.findViewById(R.id.list_checkbox) as CheckBox
        }
    }
}
