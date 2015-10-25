package com.itlions.shoppinglist.presenters

import com.itlions.shoppinglist.model.SLDataManager
import com.itlions.shoppinglist.views.AddListView

/**
 * TODO implement javadoc
 */
class AddListPresenter(val view : AddListView) : BasePresenter {
    val categories by lazy {
        SLDataManager.getCategories()
    }

    fun loadCategories() {
        view.showCategories(categories)
    }
}