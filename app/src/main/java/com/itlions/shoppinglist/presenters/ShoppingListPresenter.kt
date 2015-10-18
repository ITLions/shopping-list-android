package com.itlions.shoppinglist.presenters

import com.itlions.shoppinglist.models.ShoppingListModel
import com.itlions.shoppinglist.views.ShoppingListView

/**
 * Created by Oleg on 18.10.2015.
 */

interface ShoppingListPresenter : BasePresenter {
    fun setView(view: ShoppingListView)
}

class ShoppingListPresenterImpl : ShoppingListPresenter {

    var baseView: ShoppingListView? = null;
    var model: ShoppingListModel? = null;
    var shoppingLists: List<Object>? = null;

    override fun setView(view: ShoppingListView) {
        baseView = view;
    }

    override fun create() {
        shoppingLists = model!!.getShoppingList()
        baseView!!.setShoppingList(shoppingLists as List<Object>)
    }

}