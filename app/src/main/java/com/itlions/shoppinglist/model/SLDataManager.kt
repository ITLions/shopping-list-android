package com.itlions.shoppinglist.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.itlions.shoppinglist.model.database.Table
import com.itlions.shoppinglist.model.database.database
import org.jetbrains.anko.async
import org.jetbrains.anko.db.select
import org.jetbrains.anko.uiThread
import java.util.*

/**
 * TODO implement javadoc
 */
class SLDataManager {

    companion object {
        /* fun getCategories(context: Context, onQueried: (List<Category>) -> Any) {
               async {
                   context.database.use {
                       select(Table.Category.NAME).exec {
                           var listCategory = ArrayList<Category>()
                           this.moveToFirst()
                           while (!this.isAfterLast) {
                               val category = Category(this.getInt(0), this.getString(1), this.getString(2), this.getString(3))
                               listCategory.add(category)
                               this.moveToNext()
                           }
                           uiThread {
                               onQueried(listCategory);
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
                           var productList = ArrayList<Product>()
                           this.moveToFirst()
                           while (!this.isAfterLast) {
                               val category = Product(this.getInt(0), this.getString(1), this.getString(2), this.getString(3), null, null);
                               productList.add(category)
                               this.moveToNext()
                           }
                           uiThread {
                               onQueried(productList);
                           }
                       }
                   }
               }
           }*/


        fun saveList(context: Context, pl: List<Product>?) {
            async {
                context.database.use {
                    var newProductList = saveProductList()
                    for (newItem in pl!!) {
                        saveListItem(context, getListItem(newItem, newProductList, 0))
                    }
                }
            }
        }

        fun getProductLists(context: Context, onQueried: (List<ProductList>) -> Any) {
            async {
                context.database.use {
                    select(Table.ProductList.NAME).exec {
                        var productList = ArrayList<ProductList>()
                        this.moveToFirst()
                        while (!this.isAfterLast) {
                            val category = ProductList(this.getString(0), this.getString(1), Date(this.getLong(2)), getBoolean(this.getInt(3)))
                            productList.add(category)
                            this.moveToNext()
                        }
                        uiThread {
                            onQueried(productList);
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
                insert(Table.Category.NAME, null, cv)
            }
        }

        fun saveListItem(context: Context, listItem: ListItem) {
            context.database.use {
                var cv = ContentValues()
                cv.put(Table.ListItem.FIELD_ID, getId())
                cv.put(Table.ListItem.FIELD_NAME, listItem.name)
                cv.put(Table.ListItem.FIELD_AMOUNT, listItem.amount)
                cv.put(Table.ListItem.FIELD_CHECKED, getBoolean(listItem.checked))
                cv.put(Table.ListItem.FIELD_PRODUCT, listItem.product.id)
                cv.put(Table.ListItem.FIELD_PRODUCT_LIST, listItem.productList.id)
                insert(Table.ListItem.NAME, null, cv)
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
                cv.put(Table.Product.FIELD_UNIT, p.unit?.id)
                cv.put(Table.Product.FIELD_CATEGORY, p.category?.id)
                insert(Table.Product.NAME, null, cv)
            }
        }

        private fun SQLiteDatabase.saveProductList(): ProductList {
            var newProductList = ProductList(getId(), "Dummy", Date(), false);

            var cv = ContentValues()
            cv.put(Table.ProductList.FIELD_ID, newProductList.id)
            cv.put(Table.ProductList.FIELD_NAME, newProductList.name)
            cv.put(Table.ProductList.FIELD_CREATED_DATE, newProductList.createdDate.time)
            cv.put(Table.ProductList.FIELD_CHECKED, 0)
            insert(Table.ProductList.NAME, null, cv)
            return newProductList
        }

        fun getId(): String {
            return UUID.randomUUID().toString()
        }

        fun getBoolean(b: Boolean): Int {
            if (b) {
                return 1;
            } else {
                return 0;
            }
        }

        fun getBoolean(b: Int): Boolean {
            if (b == 1) return true;
            else return false;
        }

        fun getListItem(p: Product, pl: ProductList, amount: Int): ListItem {
            return ListItem(getId(), p.name, false, p, pl, amount)
        }

        //----------- STUB DATA ------------

        fun getCategories(context: Context, onQueried: (List<Category>) -> Any) {
            var cat1 = Category(getId(), "cat1", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            var cat2 = Category(getId(), "cat2", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            var cat3 = Category(getId(), "cat3", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            var cat4 = Category(getId(), "cat4", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            var cat5 = Category(getId(), "cat5", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            var cat6 = Category(getId(), "cat6", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            var cat7 = Category(getId(), "cat7", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            onQueried(listOf(cat1, cat2, cat3, cat4, cat5, cat6, cat7))
        }

        fun getUnits(context: Context, onQueried: (List<Unit>) -> Any) {
            var unit1 = Unit(getId(), "grams")
            var unit2 = Unit(getId(), "packs")
            onQueried(listOf(unit1, unit2))
        }

        fun getProducts(context: Context, onQueried: (List<Product>) -> Any) {
            var category = Category(getId(), "cat1", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            var units = Unit(getId(), "grams")

            var p1 = Product(getId(), "meat", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p2 = Product(getId(), "milk", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p3 = Product(getId(), "bread", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p4 = Product(getId(), "apples", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p5 = Product(getId(), "bananas", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p6 = Product(getId(), "sweets", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p7 = Product(getId(), "rice", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p8 = Product(getId(), "tomatos", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p9 = Product(getId(), "cheese", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            onQueried(listOf(p1, p2, p3, p4, p5, p6, p7, p8, p9))
        }

        fun getProducts(context: Context, id: String, onQueried: (List<Product>) -> Any) {
            var category = Category(getId(), "cat1", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            var units = Unit(getId(), "grams")

            var p1 = Product(getId(), "meat", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p2 = Product(getId(), "milk", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p3 = Product(getId(), "bread", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p4 = Product(getId(), "apples", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p5 = Product(getId(), "bananas", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p6 = Product(getId(), "sweets", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p7 = Product(getId(), "rice", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p8 = Product(getId(), "tomatos", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            var p9 = Product(getId(), "cheese", "test descr", "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png", category, units);
            onQueried(listOf(p1, p2, p3, p4, p5, p6, p7, p8, p9))
        }
    }
}