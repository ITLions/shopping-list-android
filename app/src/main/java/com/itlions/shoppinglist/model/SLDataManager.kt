package com.itlions.shoppinglist.model

import java.util.*


/**
 * TODO implement javadoc
 */
class SLDataManager {

    companion object {
        fun getProductLists(): List<ProductList> {

            var one = ProductList(1, "test1", Date())
            var two = ProductList(1, "test2", Date());
            var three = ProductList(1, "test3", Date());
            var four = ProductList(1, "test4", Date());
            var five = ProductList(1, "test5", Date());
            return listOf(one, two, three, four, five);
        }

        fun getCategories(): List<Category> {
            var cat1 = Category(1, "cat1", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            var cat2 = Category(2, "cat2", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            var cat3 = Category(3, "cat3", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            var cat4 = Category(4, "cat4", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            var cat5 = Category(5, "cat5", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            var cat6 = Category(6, "cat6", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            var cat7 = Category(7, "cat7", "here is some description", "http://1.bp.blogspot.com/-x2r6k2Fkiy4/VezqQ474YqI/AAAAAAAAF5U/X2I4w0tQf3o/s1600/1363834.jpg");
            return listOf(cat1, cat2, cat3, cat4, cat5, cat6, cat7)
        }

        fun getUnits(): List<Unit> {
            var unit1 = Unit(1, "grams")
            var unit2 = Unit(2, "packs")
            return listOf(unit1, unit2)
        }

        fun getProducts(): MutableList<Product> {
            var categories = getCategories()
            var units = getUnits()
            var p1 = Product(1, "meat", "test descr",
                    "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png",
                    categories.get(0), units.get(0));
            var p2 = Product(1, "milk", "test descr",
                    "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png",
                    categories.get(0), units.get(0));
            var p3 = Product(1, "bread", "test descr",
                    "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png",
                    categories.get(0), units.get(0));
            var p4 = Product(1, "apples", "test descr",
                    "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png",
                    categories.get(0), units.get(0));
            var p5 = Product(1, "bananas", "test descr",
                    "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png",
                    categories.get(0), units.get(0));
            var p6 = Product(1, "sweets", "test descr",
                    "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png",
                    categories.get(0), units.get(0));
            var p66 = Product(1, "rice", "test descr",
                    "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png",
                    categories.get(0), units.get(0));

            var p7 = Product(1, "tomatos", "test descr",
                    "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png",
                    categories.get(0), units.get(0));
            var p8 = Product(1, "cheese", "test descr",
                    "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/glossy-black-icons-food-beverage/056941-glossy-black-icon-food-beverage-knife-fork2.png",
                    categories.get(0), units.get(0));
            return arrayListOf (p1, p2, p3, p4, p5, p6, p66, p7, p8)
        }
    }
}