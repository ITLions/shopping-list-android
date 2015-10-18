package com.itlions.shoppinglist.model

/**
 * TODO implement javadoc
 */
interface SLDataProvider {
    fun getProductListForCategories(id : Int) : List<Product>
    fun getCategories() : List<Category>
    fun getProductLists() : List<ProductList>
    fun saveProductList(list : ProductList)
}