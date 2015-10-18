package com.itlions.shoppinglist.models

/**
 * Created by Oleg on 18.10.2015.
 */

interface ShoppingListModel {
    fun getShoppingList(): List<Object>
}

class ShoppingListModelImpl : ShoppingListModel {

    override fun getShoppingList(): List<Object> {
        //TODO
        throw UnsupportedOperationException()
    }
}