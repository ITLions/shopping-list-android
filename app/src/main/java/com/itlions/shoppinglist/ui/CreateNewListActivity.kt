package com.itlions.shoppinglist.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.listener.ProductAddedListener
import com.itlions.shoppinglist.model.Product
import com.itlions.shoppinglist.navigation.Navigator
import com.itlions.shoppinglist.ui.views.CategoryProductsFragment
import com.itlions.shoppinglist.ui.views.SelectCategoryFragment
import com.itlions.shoppinglist.ui.views.SelectedItemsView

/**
 * TODO implement javadoc
 */
class CreateNewListActivity : AppCompatActivity(), ProductAddedListener {

    val currentList: SelectedItemsView by lazy {
        supportFragmentManager.findFragmentById(R.id.fragment_added_products) as SelectedItemsView
    }

    override fun onProductAdded(p: Product) {
        currentList.addProduct(p)
    }

    override fun onListAdded() {
        currentList.saveList()
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
        Navigator.showCategoryProductsFragment(this)
    }
}