package com.itlions.shoppinglist.ui.views

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.ui.adapter.CategoryAdapterAdapter
import com.itlions.shoppinglist.ui.adapter.ProductAdapter
import com.itlions.shoppinglist.ui.views.BaseFragment
import com.itlions.shoppinglist.model.Product
import com.itlions.shoppinglist.model.ProductList
import com.itlions.shoppinglist.navigation.Navigator
import com.itlions.shoppinglist.presenters.SelectItemsPresenter
import com.itlions.shoppinglist.presenters.ViewListPresenter
import kotlin.properties.Delegates

/**
 * Created by omazhukin on 10/28/2015.
 */

interface ViewListView : BaseView {
    fun showProductList(productList: List<Product>)
}

class ViewListFragment : BaseFragment<ViewListPresenter>(), ViewListView {

    object BUNDLE {
        val PRODUCT_LIST = "list_id"
    }

    val SPAN_COUNT: Int = 3
    var mProductsList: RecyclerView by Delegates.notNull<RecyclerView>()
    val mAdapter by lazy {
        ProductAdapter(activity)
    }

    override fun getLayoutId() = R.layout.content_recycler_view

    override fun initPresenter(): ViewListPresenter = ViewListPresenter(this)

    override fun initView() {
        mProductsList = view?.findViewById(R.id.recyclerView) as RecyclerView
        mProductsList.layoutManager = GridLayoutManager(activity, SPAN_COUNT)
        mProductsList.adapter = mAdapter
    }

    override fun showProductList(productList: List<Product>) {
        mAdapter.initWithProducts(productList as MutableList<Product>)
    }

    override fun afterViewInited() {
        presenter.loadProductList(arguments.getSerializable(BUNDLE.PRODUCT_LIST) as ProductList)
    }
}