package com.itlions.shoppinglist.model

import java.io.Serializable
import java.util.*


/**
 * TODO implement javadoc
 */
data class Category(var id : String, var name : String, var description : String, var icon : String)
data class Unit(var id : String, var name : String)
data class Product(var id : String, var name : String, var description : String, var icon : String, var category: Category?, var unit: Unit?)
data class ListItem(var id: String, var name : String, var checked : Boolean, var product: Product, var productList : ProductList, var amount : Int)
data class ProductList(var id: String, var name : String, var createdDate : Date) : Serializable