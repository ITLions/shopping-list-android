package com.itlions.shoppinglist.views

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.adapter.CategoryAdapterAdapter
import com.itlions.shoppinglist.adapter.ProductAdapter
import com.itlions.shoppinglist.fragment.base.BaseFragment
import com.itlions.shoppinglist.model.Product
import com.itlions.shoppinglist.model.SLDataManager
import com.itlions.shoppinglist.presenters.SelectItemsPresenter
import kotlin.properties.Delegates

/**
 * TODO implement javadoc
 */
interface SelectedtemsView {
    fun showSelectedItems(list: MutableList<Product>)
    fun addProduct(p: Product)
}

class SelectedItemsFragment : BaseFragment<SelectItemsPresenter>(), SelectedtemsView {

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
        presenter.loadProductList()
    }

    override fun showSelectedItems(list: MutableList<Product>) {
        mAdapter.initWithProducts(list)
    }

    override fun addProduct(p: Product) {
        mAdapter.addProduct(p)
    }
}