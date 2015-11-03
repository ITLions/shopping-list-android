package com.itlions.shoppinglist.views

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.itlions.shoppinglist.CreateNewListActivity
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.adapter.CategoriesAdapter
import com.itlions.shoppinglist.adapter.CategoryAdapterAdapter
import com.itlions.shoppinglist.fragment.base.BaseFragment
import com.itlions.shoppinglist.listener.ProductAddedListener
import com.itlions.shoppinglist.model.Category
import com.itlions.shoppinglist.model.Product
import com.itlions.shoppinglist.presenters.CategoryProductsPresenter
import com.itlions.shoppinglist.presenters.SelectCategoryPresenter
import com.itlions.shoppinglist.presenters.SelectItemsPresenter
import com.itlions.shoppinglist.presenters.ProductPresenter
import kotlin.properties.Delegates

/**
 * TODO implement javadoc
 */
interface CategoryProductsView : BaseView{
    fun showProducts(list: List<Product>)
    fun addProduct(p: Product)
}

class CategoryProductsFragment : BaseFragment<ProductPresenter>(), CategoryProductsView {

    val SPAN_COUNT: Int = 3
    var mCategoriesView: RecyclerView by Delegates.notNull<RecyclerView>()
    val mAdapter by lazy {
        CategoryAdapterAdapter(activity)
    }

    override fun showProducts(list: List<Product>) {
        (mCategoriesView.adapter as CategoryAdapterAdapter).initWithProduct(list)
    }

    override fun afterViewInited() {
        presenter.loadCategoryProductList()
    }

    override fun initPresenter() = ProductPresenter(this)

    override fun initView() {
        mCategoriesView = view?.findViewById(R.id.recyclerView) as RecyclerView
        mCategoriesView.layoutManager = GridLayoutManager(activity, SPAN_COUNT)
        mCategoriesView.adapter = mAdapter
        mAdapter.setOnClickListener { view, product ->
            presenter.onProductClicked(activity, product);
        }

    }

    override fun addProduct(p: Product) {
        (activity as ProductAddedListener).onProductAdded(p)
    }

    override fun getLayoutId(): Int = R.layout.content_recycler_view
}