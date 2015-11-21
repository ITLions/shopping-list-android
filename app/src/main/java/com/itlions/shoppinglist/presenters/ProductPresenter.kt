package com.itlions.shoppinglist.presenters

import android.content.Context
import android.content.DialogInterface
import com.itlions.shoppinglist.ui.dialog.DialogHelper
import com.itlions.shoppinglist.model.Product
import com.itlions.shoppinglist.model.SLDataManager
import com.itlions.shoppinglist.presenters.base.BasePresenter
import com.itlions.shoppinglist.ui.views.CategoryProductsView

/**
 * Created by omazhukin on 10/27/2015.
 */
class ProductPresenter(val view: CategoryProductsView) : BasePresenter {
    fun loadCategoryProductList() {
        SLDataManager.getProducts(view.getContext()) {
            productList -> view.showProducts(productList)
        }
    }

    fun onProductClicked(c: Context, p: Product) {
        DialogHelper().showProductDialog(c, p, l = DialogInterface.OnClickListener { dialogInterface, i -> view.addProduct(p) })
    }
}