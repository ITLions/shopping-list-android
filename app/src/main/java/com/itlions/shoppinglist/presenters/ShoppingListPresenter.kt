package com.itlions.shoppinglist.presenters

import com.itlions.shoppinglist.interactor.ShoppingListInteractor
import com.itlions.shoppinglist.interactor.ShoppingListInteractorImpl
import com.itlions.shoppinglist.model.ProductList
import com.itlions.shoppinglist.presenters.base.BasePresenter
import com.itlions.shoppinglist.ui.views.ShoppingListView

interface ShoppingListPresenter : BasePresenter {
    fun onItemClicked(item: ProductList)
    fun onItemChecked(item: ProductList, isChecked: Boolean)
    fun onItemAdd(item: ProductList)
}

class ShoppingListPresenterImpl(val view: ShoppingListView) : ShoppingListPresenter {

    val interactor: ShoppingListInteractor by lazy {
        ShoppingListInteractorImpl(view.getContext())
    }

    fun loadShoppingLists() {
        interactor.loadShoppingList { productLists ->
            view.onListsLoaded(productLists)
        }
    }

    override fun onItemClicked(item: ProductList) {
        throw UnsupportedOperationException()
    }

    override fun onItemChecked(item: ProductList, isChecked: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun onItemAdd(item: ProductList) {
        throw UnsupportedOperationException()
    }
}