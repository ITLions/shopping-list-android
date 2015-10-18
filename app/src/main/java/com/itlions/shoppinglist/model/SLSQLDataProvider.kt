package com.itlions.shoppinglist.model

import android.content.Context
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

/**
 * TODO implement javadoc
 */
class SLSQLDataProvider(context: Context) : SLDataProvider {

    var mContext: Context

    init {
        mContext = context
    }

    override fun getCategories(): List<Category> {
        throw UnsupportedOperationException()
    }

    override fun getProductLists(): List<ProductList>? {
        var productLists : List<ProductList>? = null
        mContext.database.use {
            productLists = select("product_list").parseList(classParser<ProductList>())
        }
        return productLists
    }


    override fun saveProductList(list: ProductList) {
        throw UnsupportedOperationException()
    }

    override fun getProductListForCategories(id: Int): List<Product> {
        throw UnsupportedOperationException()
    }
}