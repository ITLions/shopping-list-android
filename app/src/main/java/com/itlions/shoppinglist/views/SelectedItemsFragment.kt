package com.itlions.shoppinglist.views

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.adapter.AddedProductAdapter
import com.itlions.shoppinglist.fragment.base.BaseFragment
import com.itlions.shoppinglist.model.Product
import com.itlions.shoppinglist.model.SLDataManager
import com.itlions.shoppinglist.presenters.SelectItemsPresenter
import kotlin.properties.Delegates

/**
 * TODO implement javadoc
 */
interface SelectItemsView {
    fun showSelectedItems(list : List<Product>)
}

class SelectedItemsFragment : BaseFragment<SelectItemsPresenter>(), SelectItemsView {
    var mAddedProductsList : RecyclerView by Delegates.notNull<RecyclerView>()
    val mAdapter by lazy {
        AddedProductAdapter(activity)
    }


    override fun getLayoutId() = R.layout.content_selected_products_list

    override fun initPresenter(): SelectItemsPresenter = SelectItemsPresenter(this)

    override fun initView() {
        mAddedProductsList = view?.findViewById(R.id.recyclerView) as RecyclerView
        mAddedProductsList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mAddedProductsList.adapter = mAdapter
    }

    override fun afterViewInited() {
        presenter.loadProductList()
    }

    override fun showSelectedItems(list: List<Product>) {
        mAdapter.initWithItem(list)
    }

}