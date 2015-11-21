package com.itlions.shoppinglist.presenters

import com.itlions.shoppinglist.model.Product
import com.itlions.shoppinglist.model.SLDataManager
import com.itlions.shoppinglist.presenters.base.BasePresenter
import com.itlions.shoppinglist.ui.views.SelectedtemsView

/**
 * TODO implement javadoc
 */
class SelectItemsPresenter(val view: SelectedtemsView) : BasePresenter {
    fun loadProductList() {
        SLDataManager.getProducts(view.getContext(), { productList ->
            view.showSelectedItems(productList)
        })

    }

    fun onProductSelected(p: Product) {

    }

}