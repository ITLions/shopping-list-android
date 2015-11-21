package com.itlions.shoppinglist.ui.views

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.model.ProductList
import com.itlions.shoppinglist.navigation.Navigator
import com.itlions.shoppinglist.presenters.ShoppingListPresenterImpl
import com.itlions.shoppinglist.ui.adapter.ShoppingListAdapter
import kotlin.properties.Delegates

/**
 * Created by Oleg on 18.10.2015.
 */

interface ShoppingListView : BaseProgressView {
    fun onListsLoaded(list: List<ProductList>?): Any
    fun updateList()
}

class ShoppingListFragment : BaseFragment<ShoppingListPresenterImpl>(), ShoppingListView {

    override fun showError(message: String) {
    }

    override fun showProgress(show: Boolean) {
        if ( show ) {
            progressBar.visibility = View.VISIBLE
            shoppingList.visibility = View.INVISIBLE
        } else {
            progressBar.visibility = View.VISIBLE
            shoppingList.visibility = View.INVISIBLE
        }
    }

    val mAdapter by lazy {
        ShoppingListAdapter(activity)
    }

    var shoppingList: RecyclerView by Delegates.notNull<RecyclerView>()
    var progressBar: ProgressBar by Delegates.notNull<ProgressBar>()

    override fun afterViewInited() {
        presenter.loadShoppingLists()
    }

    override fun getLayoutId() = R.layout.content_recycler_view

    override fun onListsLoaded(list: List<ProductList>?) {
        mAdapter.updateData(list)
    }

    override fun initPresenter() = ShoppingListPresenterImpl(this)

    override fun initView() {
        shoppingList = view?.findViewById(R.id.recyclerView) as RecyclerView
        shoppingList.adapter = mAdapter
        progressBar = view?.findViewById(R.id.progressBar) as ProgressBar
        mAdapter.setOnClickListener { view, productList -> Navigator.showProductListFragment(activity as AppCompatActivity, productList) }
    }

    override fun updateList() {
        throw UnsupportedOperationException()
    }
}