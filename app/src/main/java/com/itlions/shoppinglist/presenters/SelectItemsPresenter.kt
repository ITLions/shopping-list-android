package com.itlions.shoppinglist.presenters

import com.itlions.shoppinglist.model.SLDataManager
import com.itlions.shoppinglist.views.SelectItemsView

/**
 * TODO implement javadoc
 */
class SelectItemsPresenter(val view : SelectItemsView) : BasePresenter {
    fun loadProductList() {
        view.showSelectedItems(SLDataManager.getProducts())
    }

}