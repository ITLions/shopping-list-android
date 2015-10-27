package com.itlions.shoppinglist.views

import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.fragment.base.BaseFragment
import com.itlions.shoppinglist.presenters.CategoryProductsPresenter

/**
 * TODO implement javadoc
 */
class CategoryProductsFragment : BaseFragment<CategoryProductsPresenter>() {
    override fun getLayoutId() = R.layout.content_recycler_view

    override fun initPresenter() = CategoryProductsPresenter()
    override fun initView() {

    }

    override fun afterViewInited() {

    }

}