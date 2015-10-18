package com.itlions.shoppinglist.views

import android.widget.ListView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.fragment.base.BaseFragment
import kotlin.properties.Delegates

/**
 * Created by Oleg on 18.10.2015.
 */

interface ShoppingListView {
    fun setShoppingList(list: List<Object>)
    fun updateList()
}

class ShoppingListViewImpl : BaseFragment(), ShoppingListView {

    var shoppingList: ListView  by Delegates.notNull<ListView>();

    override fun getLayoutId(): Int {
        return R.layout.fragment_shoping_list;
    }

    override fun setShoppingList(list: List<Object>) {
        //var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values)
        // shoppingList!!.setAdapter(adapter)
    }

    override fun updateList() {
        throw UnsupportedOperationException()
    }

}