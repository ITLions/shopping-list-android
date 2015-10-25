package com.itlions.shoppinglist.views

import android.support.v7.widget.RecyclerView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.fragment.base.BaseFragment
import com.itlions.shoppinglist.model.Category
import com.itlions.shoppinglist.presenters.AddListPresenter
import org.jetbrains.anko.find
import kotlin.properties.Delegates

/**
 * TODO implement javadoc
 */

interface AddListView {
    fun showCategories(list : List<Category>)
}

class AddListFragment : BaseFragment<AddListPresenter>(), AddListView {
    override fun showCategories(list: List<Category>) {

    }

    override fun afterViewInited() {
        presenter.loadCategories()
    }

    var mAddedProductsList : RecyclerView by Delegates.notNull<RecyclerView>()
    var mCategoriesView : RecyclerView by Delegates.notNull<RecyclerView>()


    override fun initPresenter() = AddListPresenter(this)

    override fun initView() {
        mAddedProductsList = view?.findViewById(R.id.rv_added_products) as RecyclerView
        mCategoriesView = view?.findViewById(R.id.rv_categories) as RecyclerView
    }

    override fun getLayoutId(): Int  = R.layout.content_add_list

}