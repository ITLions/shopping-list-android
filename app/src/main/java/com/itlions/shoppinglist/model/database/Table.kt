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
            val FIELD_CHECKED = "checked"
        }
    }

    class ListItem {
        companion object {
            val NAME = "list_item"
            val FIELD_ID = "_id"
            val FIELD_NAME = "name"
            val FIELD_CHECKED = "checked"
            val FIELD_PRODUCT = "product_id"
            val FIELD_PRODUCT_LIST = "product_list_id"
            val FIELD_AMOUNT = "amount"
        }
    }

    class Product {
        companion object {
            val NAME = "product"
            val FIELD_ID = "_id"
            val FIELD_NAME = "name"
            val FIELD_DESCRIPTION = "description"
            val FIELD_ICON = "icon"
            val FIELD_CATEGORY = "category_id"
            val FIELD_UNIT = "unit_id"
        }
    }

    class Unit {
        companion object {
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