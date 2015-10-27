package com.itlions.shoppinglist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.itlions.shoppinglist.listener.ProductAddedListener
import com.itlions.shoppinglist.model.Product
import com.itlions.shoppinglist.navigation.Navigator
import com.itlions.shoppinglist.views.CategoryProductsFragment
import com.itlions.shoppinglist.views.SelectCategoryFragment
import com.itlions.shoppinglist.views.SelectedtemsView

/**
 * TODO implement javadoc
 */
class CreateNewListActivity : AppCompatActivity(), ProductAddedListener {

    val currentList: SelectedtemsView by lazy {
        supportFragmentManager.findFragmentById(R.id.fragment_added_products) as SelectedtemsView
    }

    override fun onProductAdded(p: Product) {
        currentList.addProduct(p)
    }

    companion object {
        fun launch(context: Context) = context.startActivity(Intent(context, javaClass<CreateNewListActivity>()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_list)
        Navigator.showFragment(this, SelectCategoryFragment())
    }

    fun goInsideCategory() {
        Navigator.showFragment(this, CategoryProductsFragment(), true)
    }
}