package com.itlions.shoppinglist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.model.Category
import com.itlions.shoppinglist.model.ProductList

/**
 * Created by omazhukin on 10/19/2015.
 */

class ShoppingLisAdapter(private val context: Context) : BaseAdapter() {

    private var itemsList: List<ProductList>? = null
    private val lInflater: LayoutInflater
    var listener : ((View, ProductList) -> Unit)? = null

    init {
        lInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return if (itemsList == null) 0 else itemsList!!.size()
    }

    fun setOnClickListener(listener : (View, ProductList) -> Unit) {
        this.listener = listener
    }

    override fun getItem(position: Int): ProductList {
        return itemsList!!.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView

        val viewHolder: ViewHolder

        if (convertView == null) {
            convertView = lInflater.inflate(R.layout.item_shopping_list, parent, false)

            // well set up the ViewHolder
            viewHolder = ViewHolder()
            viewHolder.title = convertView!!.findViewById(R.id.txt_list_title) as TextView
            viewHolder.checkBox = convertView.findViewById(R.id.list_checkbox) as CheckBox

            // store the holder with the view.
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }

        val productList = getItem(position)

        viewHolder.title?.text = productList.name
        //viewHolder.checkBox.setChecked(productList.getChecked());

        convertView?.setOnClickListener {
            listener?.invoke(convertView as View, productList!!)
        }

        return convertView
    }

    fun setData(productList: List<ProductList>?) {
        itemsList = productList;
        notifyDataSetChanged()
    }

    internal inner class ViewHolder {
        var title: TextView? = null
        var checkBox: CheckBox? = null
    }
}