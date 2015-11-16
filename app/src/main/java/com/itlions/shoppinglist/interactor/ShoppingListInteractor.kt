package com.itlions.shoppinglist.interactor

import android.content.Context
import com.itlions.shoppinglist.model.ProductList
import com.itlions.shoppinglist.model.SLDataManager

/**
 * Created by Oleg on 18.10.2015.
 */
interface ShoppingListInteractor {
    fun loadShoppingList(result: (List<ProductList>) -> Any)
}

class ShoppingListInteractorImpl(val context: Context) : ShoppingListInteractor {
    override fun loadShoppingList(result: (List<ProductList>) -> Any) {
        SLDataManager.getProductLists(context) { result }
    }
}