package com.itlions.shoppinglist.presenters

import com.itlions.shoppinglist.model.ProductList
import com.itlions.shoppinglist.models.ShoppingListModel
import com.itlions.shoppinglist.models.ShoppingListModelImpl
import com.itlions.shoppinglist.views.ShoppingListView

/**
 * Created by Oleg on 18.10.2015.
 */

interface ShoppingListPresenter : BasePresenter {
    fun onItemClicked(item: ProductList)
    fun onItemChecked(item: ProductList, isChecked: Boolean)
    fun onItemAdd(item: ProductList)
}

class ShoppingListPresenterImpl(val view: ShoppingListView) : ShoppingListPresenter {

    val model: ShoppingListModel by lazy {
        ShoppingListModelImpl()
    }
    val shoppingLists: List<ProductList>? by lazy {
        model.getShoppingList();
    }

    override fun loadData() {
        view.setShoppingList(shoppingLists ?: null)
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