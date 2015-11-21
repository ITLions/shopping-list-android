package com.itlions.shoppinglist.presenters

import com.itlions.shoppinglist.model.ProductList
import com.itlions.shoppinglist.model.SLDataManager
import com.itlions.shoppinglist.presenters.base.BasePresenter
import com.itlions.shoppinglist.ui.views.ShoppingListView

interface ShoppingListPresenter : BasePresenter {
    fun onItemClicked(item: ProductList)
    fun onItemChecked(item: ProductList, isChecked: Boolean)
    fun onItemAdd(item: ProductList)
}

class ShoppingListPresenterImpl(val view: ShoppingListView) : ShoppingListPresenter {
    override fun onItemClicked(item: ProductList) {
        throw UnsupportedOperationException()
    }

    override fun onItemChecked(item: ProductList, isChecked: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun onItemAdd(item: ProductList) {
        throw UnsupportedOperationException()
    }

    fun loadShoppingLists() {
        view.showProgress(true)
        SLDataManager.getProductLists(view.getContext()) { productLists ->
            view.showProgress(false)
            view.onListsLoaded(productLists)
        }
    }

}