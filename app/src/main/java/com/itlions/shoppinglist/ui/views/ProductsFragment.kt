package com.itlions.shoppinglist.ui.views

import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.listener.ProductAddedListener
import com.itlions.shoppinglist.model.Product
import com.itlions.shoppinglist.presenters.ProductPresenter
import com.itlions.shoppinglist.ui.adapter.ProductAdapter
import com.itlions.shoppinglist.ui.views.base.BaseFragment
import com.itlions.shoppinglist.ui.views.base.BaseView
import kotlin.properties.Delegates

/**
 * TODO implement javadoc
 */
interface CategoryProductsView : BaseView {
    fun showProducts(list: List<Product>)
    fun addProduct(p: Product, amount: Int)
}

class CategoryProductsFragment : BaseFragment<ProductPresenter>(), CategoryProductsView {

    val SPAN_COUNT: Int = 3
    var mFab: FloatingActionButton by Delegates.notNull<FloatingActionButton>()
    var mCategoriesView: RecyclerView by Delegates.notNull<RecyclerView>()
    val mAdapter by lazy {
        ProductAdapter(activity)
    }

    override fun showProducts(list: List<Product>) {
        (mCategoriesView.adapter as ProductAdapter).initWithProducts(list)
    }

    override fun afterViewInited() {
        presenter.loadCategoryProductList()
    }

    override fun initPresenter() = ProductPresenter(this)

    override fun initView() {
        mFab = view?.findViewById(R.id.fab) as FloatingActionButton
        mCategoriesView = view?.findViewById(R.id.recyclerView) as RecyclerView
        mCategoriesView.layoutManager = GridLayoutManager(activity, SPAN_COUNT)
        mCategoriesView.adapter = mAdapter
        mAdapter.setOnClickListener { view, product ->
            presenter.onProductClicked(activity, product);
        }
        mFab.setOnClickListener {
            activity.onBackPressed()
        }
    }

    override fun addProduct(p: Product, amount: Int) {
        (activity as ProductAddedListener).onProductAdded(p)
    }

    override fun getLayoutId(): Int = R.layout.content_recycler_view
}