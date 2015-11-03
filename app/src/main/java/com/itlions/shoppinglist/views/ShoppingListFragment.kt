package com.itlions.shoppinglist.views

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.ListView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.adapter.ShoppingListAdapter
import com.itlions.shoppinglist.fragment.base.BaseFragment
import com.itlions.shoppinglist.model.ProductList
import com.itlions.shoppinglist.navigation.Navigator
import com.itlions.shoppinglist.presenters.ShoppingListPresenterImpl
import kotlin.properties.Delegates

/**
 * Created by Oleg on 18.10.2015.
 */

interface ShoppingListView : BaseView {
    fun onListsLoaded(list: List<ProductList>?)
    fun updateList()
}

class ShoppingListFragment : BaseFragment<ShoppingListPresenterImpl>(), ShoppingListView {

    val mAdapter by lazy {
        ShoppingListAdapter(activity)
    }

    var shoppingList: RecyclerView by Delegates.notNull<RecyclerView>()

    override fun afterViewInited() {
        presenter.loadShoppingLists()
    }
    override fun getLayoutId() = R.layout.content_recycler_view

    override fun onListsLoaded(list: List<ProductList>?) = mAdapter.updateData(list)

    override fun initPresenter() = ShoppingListPresenterImpl(this)

    override fun initView() {
        shoppingList = view?.findViewById(R.id.recyclerView) as RecyclerView
        shoppingList.adapter = mAdapter
        mAdapter.setOnClickListener { view, productList -> Navigator.showProductListFragment(activity as AppCompatActivity, productList) }
    }

    override fun updateList() {
        throw UnsupportedOperationException()
    }
}