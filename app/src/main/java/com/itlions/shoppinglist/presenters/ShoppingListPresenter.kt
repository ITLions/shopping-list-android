package com.itlions.shoppinglist.presenters

import com.itlions.shoppinglist.model.ProductList
import com.itlions.shoppinglist.models.ShoppingListModel
import com.itlions.shoppinglist.models.ShoppingListModelImpl
import com.itlions.shoppinglist.views.ShoppingListView

/**
 * Created by Oleg on 18.10.2015.
 */

interface ShoppingListPresenter : BasePresenter {
    fun setView(view: ShoppingListView)
    fun onItemClicked(item : ProductList)
    fun onItemChecked(item : ProductList, isChecked : Boolean)
    fun onItemAdd(item: ProductList)
}

class ShoppingListPresenterImpl : ShoppingListPresenter {

    var baseView: ShoppingListView? = null;
    var model: ShoppingListModel? = null;
    var shoppingLists: List<ProductList>? = null;

    override fun setView(view: ShoppingListView) {
        baseView = view;
        create()
    }

    override fun create() {
        model = ShoppingListModelImpl()
        shoppingLists = model!!.getShoppingList()
        baseView!!.setShoppingList(shoppingLists as List<ProductList>)
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