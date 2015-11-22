package com.itlions.shoppinglist.model

import android.content.ContentValues
import android.content.Context
import com.itlions.shoppinglist.model.database.Table
import com.itlions.shoppinglist.model.database.database
import org.jetbrains.anko.async
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.select
import org.jetbrains.anko.uiThread
import timber.log.Timber


/**
 * TODO implement javadoc
 */
class SLDataManager {

    companion object {
        fun getProductLists(context: Context, onQueried: (List<ProductList>) -> Any) {
            async {
                context.database.use {
                    select(Table.ProductList.NAME).exec {
                        val parser = classParser<ProductList>()
                        var result = parseList(parser)
                        uiThread {
                            onQueried(result)
                        }
                    }
                }
            }
        }

        fun getCategories(context: Context, onQueried: (List<Category>) -> Any) {
            async {
                context.database.use {
                    select(Table.Category.NAME).exec {
                        val parser = classParser<Category>()
                        var result = parseList(parser)
                        uiThread {
                            onQueried(result)
                        }
                    }
                }
            }
        }


        fun getUnits(context: Context, onQueried: (List<Unit>) -> Any) {
            async {
                context.database.use {
                    select(Table.Unit.NAME).exec {
                        val parser = classParser<Unit>()
                        var result = parseList(parser)
                        uiThread {
                            onQueried(result)
                        }
                    }
                }
            }
        }


        fun getProducts(context: Context, onQueried: (List<Product>) -> Any) {
            async {
                context.database.use {
                    select(Table.Product.NAME).exec {
                        val parser = classParser<Product>()
                        var result = parseList(parser)
                        uiThread {
                            onQueried(result)
                        }
                    }
                }
            }
        }

        fun saveCategory(context: Context, category: Category) {
            context.database.use {
                var cv = ContentValues()
                cv.put(Table.Category.FIELD_ID, category.id)
                cv.put(Table.Category.FIELD_NAME, category.name)
                cv.put(Table.Category.FIELD_DESCRIPTION, category.description)
                cv.put(Table.Category.FIELD_ICON, category.icon)
                val i = insert(Table.Category.NAME, null, cv)
                Timber.d("$i")
            }
        }

        fun saveUnit(context: Context, unit: Unit) {
            context.database.use {
                var cv = ContentValues()
                cv.put(Table.Unit.FIELD_ID, unit.id)
                cv.put(Table.Unit.FIELD_NAME, unit.name)
                insert(Table.Unit.NAME, null, cv)
            }
        }

        fun saveProduct(context: Context, p: Product) {
            context.database.use {
                var cv = ContentValues()
                cv.put(Table.Product.FIELD_ID, p.id)
                cv.put(Table.Product.FIELD_NAME, p.name)
                cv.put(Table.Product.FIELD_DESCRIPTION, p.description)
                cv.put(Table.Product.FIELD_ICON, p.icon)
                cv.put(Table.Product.FIELD_UNIT, p.unit.id)
                cv.put(Table.Product.FIELD_CATEGORY, p.category.id)
                insert(Table.Product.NAME, null, cv)
            }
        }

        fun saveProductList(context: Context, pl: ProductList) {
            context.database.use {
                var cv = ContentValues()
                cv.put(Table.ProductList.FIELD_ID, pl.id)
                cv.put(Table.ProductList.FIELD_NAME, pl.name)
                cv.put(Table.ProductList.FIELD_CREATED_DATE, pl.createdDate.time)
                insert(Table.ProductList.NAME, null, cv)
            }
        }
    }
}