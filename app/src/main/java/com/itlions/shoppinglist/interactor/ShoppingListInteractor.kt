package com.itlions.shoppinglist.interactor

import android.content.Context
import com.itlions.shoppinglist.model.ProductList
import com.itlions.shoppinglist.model.SLDataManager
import com.itlions.shoppinglist.model.asyncWithResult

/**
 * Created by Oleg on 18.10.2015.
 */
interface ShoppingListInteractor {
    fun loadShoppingList(result: (List<ProductList>) -> Any)
}

class ShoppingListInteractorImpl(val context: Context) : ShoppingListInteractor {
    override fun loadShoppingList(result: (List<ProductList>) -> Any) {
        context.asyncWithResult({
            Thread.sleep(7000)
            SLDataManager.getProductLists()
        }, result)
    }
}