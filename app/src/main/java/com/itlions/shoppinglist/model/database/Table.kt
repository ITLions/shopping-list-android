package com.itlions.shoppinglist.model.database

/**
 * TODO implement javadoc
 */
class Table {
    class ProductList {
        companion object {
            val NAME = "product_list"
            val FIELD_ID = "id";
            val FIELD_NAME = "name"
            val FIELD_CREATED_DATE = "careated_date"
        }
    }

    class Product {
        companion object {
            val NAME = "product"
            val FIELD_ID = "id"
            val FIELD_NAME = "name"
            val FIELD_DESCRIPTION = "description"
            val FIELD_ICON = "icon"
            val FIELD_CATEGORY = "category"
            val FIELD_UNIT = "unit"
        }
    }
}