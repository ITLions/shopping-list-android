package com.itlions.shoppinglist.models

import com.itlions.shoppinglist.model.ProductList
import com.itlions.shoppinglist.model.SLDataManager

/**
 * Created by Oleg on 18.10.2015.
 */

interface ShoppingListModel {
    fun getShoppingList(): List<ProductList>
}

class ShoppingListModelImpl : ShoppingListModel {

    override fun getShoppingList(): List<ProductList> {
        return SLDataManager.getProductLists();
    }
}