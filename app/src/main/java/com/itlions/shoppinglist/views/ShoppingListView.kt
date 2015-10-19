package com.itlions.shoppinglist.views

import android.os.Bundle
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
    fun setShoppingList(list: List<ProductList>?)
    fun updateList()
}

class ShoppingListViewImpl : BaseFragment<ShoppingListPresenterImpl>(), ShoppingListView {

    var shoppingList: ListView by Delegates.notNull<ListView>();

    override fun getLayoutId(): Int {
        return R.layout.fragment_shoping_list;
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadData()
    }

    override fun setShoppingList(list: List<ProductList>?) {
        var adapter = ShoppingLisAdapter(activity);
        adapter.setData(list)
        shoppingList.adapter = adapter
    }

    override fun initPresenter() = ShoppingListPresenterImpl(this)

    override fun initView() {
        shoppingList = view?.findViewById(R.id.shopping_list) as ListView;
    }

    override fun updateList() {
        throw UnsupportedOperationException()
    }
}