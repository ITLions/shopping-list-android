package com.itlions.shoppinglist.ui.views

import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.listener.ProductAddedListener
import com.itlions.shoppinglist.model.Category
import com.itlions.shoppinglist.presenters.SelectCategoryPresenter
import com.itlions.shoppinglist.ui.CreateNewListActivity
import com.itlions.shoppinglist.ui.adapter.CategoriesAdapter
import com.itlions.shoppinglist.ui.views.base.BaseFragment
import com.itlions.shoppinglist.ui.views.base.BaseView
import kotlin.properties.Delegates

/**
 * TODO implement javadoc
 */

interface SelectCategoryView : BaseView {
    fun showCategories(list: List<Category>)
}

class SelectCategoryFragment : BaseFragment<SelectCategoryPresenter>(), SelectCategoryView {

    var mFab: FloatingActionButton by Delegates.notNull<FloatingActionButton>()
    var mCategoriesView: RecyclerView by Delegates.notNull<RecyclerView>()

    val SPAN_COUNT: Int = 3
    val mAdapter by lazy {
        CategoriesAdapter(activity)
    }

    override fun showCategories(list: List<Category>) {
        (mCategoriesView.adapter as CategoriesAdapter).initWithCategories(list)
    }

    override fun afterViewInited() {
        presenter.loadCategories()
    }

    override fun initPresenter() = SelectCategoryPresenter(this)

    override fun initView() {
        mFab = view?.findViewById(R.id.fab) as FloatingActionButton
        mCategoriesView = view?.findViewById(R.id.recyclerView) as RecyclerView
        mCategoriesView.layoutManager = GridLayoutManager(activity, SPAN_COUNT)
        mCategoriesView.adapter = mAdapter
        mAdapter.setOnClickListener { view, category ->
            (activity as CreateNewListActivity).goInsideCategory()
        }
        mFab.setOnClickListener {
            (activity as ProductAddedListener).onListAdded()
        }
    }

    override fun getLayoutId(): Int = R.layout.content_recycler_view

}