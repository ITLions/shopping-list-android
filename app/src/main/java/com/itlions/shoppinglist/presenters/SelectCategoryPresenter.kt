package com.itlions.shoppinglist.presenters

import com.itlions.shoppinglist.model.SLDataManager
import com.itlions.shoppinglist.presenters.base.BasePresenter
import com.itlions.shoppinglist.ui.views.SelectCategoryView

/**
 * TODO implement javadoc
 */
class SelectCategoryPresenter(val view: SelectCategoryView) : BasePresenter {

    fun loadCategories() {
        SLDataManager.getCategories(view.getContext()) {
            categoriesList ->
            view.showCategories(categoriesList)
        }
    }
}