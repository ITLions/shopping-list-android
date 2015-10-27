package com.itlions.shoppinglist.presenters

import com.itlions.shoppinglist.model.SLDataManager
import com.itlions.shoppinglist.presenters.base.BasePresenter
import com.itlions.shoppinglist.views.SelectCategoryView

/**
 * TODO implement javadoc
 */
class SelectCategoryPresenter(val view : SelectCategoryView) : BasePresenter {
    val categories by lazy {
        SLDataManager.getCategories()
    }

    fun loadCategories() {
        view.showCategories(categories)
    }
}