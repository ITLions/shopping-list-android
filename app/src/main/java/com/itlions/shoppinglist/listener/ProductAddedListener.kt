package com.itlions.shoppinglist.listener

import com.itlions.shoppinglist.model.Product

/**
 * Created by omazhukin on 10/27/2015.
 */
interface ProductAddedListener {
    fun onProductAdded(p : Product)
}