package com.itlions.shoppinglist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.itlions.shoppinglist.navigation.Navigator
import com.itlions.shoppinglist.views.CategoryProductsFragment
import com.itlions.shoppinglist.views.SelectCategoryFragment

/**
 * TODO implement javadoc
 */
class CreateNewListActivity : AppCompatActivity() {

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