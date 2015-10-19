package com.itlions.shoppinglist.views

import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.widget.ListView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.adapter.ShoppingLisAdapter
import com.itlions.shoppinglist.fragment.base.BaseFragment
import com.itlions.shoppinglist.model.ProductList
import com.itlions.shoppinglist.presenters.ShoppingListPresenterImpl
import kotlin.properties.Delegates

/**
 * Created by Oleg on 18.10.2015.
 */

interface ShoppingListView {
    fun setShoppingList(list: List<ProductList>)
    fun updateList()
}

class ShoppingListViewImpl : BaseFragment(), ShoppingListView {

    var shoppingList: ListView  by Delegates.notNull<ListView>();

    override fun getLayoutId(): Int {
        return R.layout.fragment_shoping_list;
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun setShoppingList(list: List<ProductList>) {
        var adapter = ShoppingLisAdapter(getActivity());
        adapter.setData(list)
        shoppingList!!.setAdapter(adapter)
    }

    override fun initPresenter() {
        val shoppingListPresenter = ShoppingListPresenterImpl()
        shoppingListPresenter.setView(this)
    }

    override fun initView() {
        shoppingList = view?.findViewById(R.id.shopping_list) as ListView;
    }

    override fun updateList() {
        throw UnsupportedOperationException()
    }
}