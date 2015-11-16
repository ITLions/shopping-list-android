package com.itlions.shoppinglist.presenters

import com.itlions.shoppinglist.model.Product
import com.itlions.shoppinglist.model.ProductList
import com.itlions.shoppinglist.model.SLDataManager
import com.itlions.shoppinglist.presenters.base.BasePresenter
import com.itlions.shoppinglist.ui.views.SelectedtemsView
import com.itlions.shoppinglist.ui.views.ViewListView

/**
 * Created by omazhukin on 10/28/2015.
 */

class ViewListPresenter(val view: ViewListView) : BasePresenter {

    fun loadProductList(productList : ProductList)  {
        view.showProductList(SLDataManager.getProducts())
    }
}