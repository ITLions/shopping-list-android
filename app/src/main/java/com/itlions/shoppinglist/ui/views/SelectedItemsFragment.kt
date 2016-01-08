package com.itlions.shoppinglist.ui.views

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.model.Product
import com.itlions.shoppinglist.model.SLDataManager
import com.itlions.shoppinglist.presenters.SelectItemsPresenter
import com.itlions.shoppinglist.ui.adapter.ProductAdapter
import com.itlions.shoppinglist.ui.views.base.BaseFragment
import com.itlions.shoppinglist.ui.views.base.BaseView
import kotlin.properties.Delegates

/**
 * TODO implement javadoc
 */
interface SelectedItemsView : BaseView {
    fun addProduct(p: Product)
    fun saveList()
}

class SelectedItemsFragment : BaseFragment<SelectItemsPresenter>(), SelectedItemsView {

    var mAddedProductsList: RecyclerView by Delegates.notNull<RecyclerView>()
    val mAdapter by lazy {
        ProductAdapter(activity)
    }

    override fun getLayoutId() = R.layout.content_selected_products_list

    override fun initPresenter(): SelectItemsPresenter = SelectItemsPresenter(this)

    override fun initView() {
        mAddedProductsList = view?.findViewById(R.id.recyclerView) as RecyclerView
        mAddedProductsList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mAddedProductsList.adapter = mAdapter
    }

    override fun afterViewInited() {

    }

    override fun addProduct(p: Product) {
        mAdapter.addProduct(p)
    }

    override fun saveList() {
        if (mAdapter.products.size > 0) {
            SLDataManager.saveList(activity, mAdapter.products)
        }
        activity.finish()
    }
}