package com.itlions.shoppinglist.model.database

/**
 * TODO implement javadoc
 */
class Table {
    class ProductList {
        companion object {
            val NAME = "product_list"
            val FIELD_ID = "_id";
            val FIELD_NAME = "name"
            val FIELD_CREATED_DATE = "careated_date"
        }
    }

    class Product {
        companion object {
            val NAME = "product"
            val FIELD_ID = "_id"
            val FIELD_NAME = "name"
            val FIELD_DESCRIPTION = "description"
            val FIELD_ICON = "icon"
            val FIELD_CATEGORY = "category"
            val FIELD_UNIT = "unit"
        }
    }

    class Unit{
        companion object{
            val NAME = "units"
            val FIELD_ID = "_id"
            val FIELD_NAME = "name"
        }
    }
    class Category {
        companion object {
            val NAME = "category"
            val FIELD_ID = "_id"
            val FIELD_NAME = "name"
            val FIELD_DESCRIPTION = "description"
            val FIELD_ICON = "icon"
        }
    }
}