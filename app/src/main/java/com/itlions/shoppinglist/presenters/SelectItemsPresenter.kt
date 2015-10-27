package com.itlions.shoppinglist.presenters

import com.itlions.shoppinglist.model.Product
import com.itlions.shoppinglist.model.SLDataManager
import com.itlions.shoppinglist.presenters.base.BasePresenter
import com.itlions.shoppinglist.views.SelectedtemsView

/**
 * TODO implement javadoc
 */
class SelectItemsPresenter(val view: SelectedtemsView) : BasePresenter {
    fun loadProductList() {
        view.showSelectedItems(SLDataManager.getProducts())
    }

    fun onProductSelected(p : Product) {

    }

}