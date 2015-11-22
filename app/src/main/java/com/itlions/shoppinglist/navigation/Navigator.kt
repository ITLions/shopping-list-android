package com.itlions.shoppinglist.navigation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.itlions.shoppinglist.ui.CreateNewListActivity
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.model.Product
import com.itlions.shoppinglist.model.ProductList
import com.itlions.shoppinglist.ui.views.CategoryProductsFragment
import com.itlions.shoppinglist.ui.views.ShoppingListFragment
import com.itlions.shoppinglist.ui.views.ViewListFragment

/**
 * Created by omazhukin on 10/19/2015.
 */

public object Navigator {

    fun showFragment(activity: AppCompatActivity, fragment: Fragment) {
        showFragment(activity, fragment, null, false)
    }

    fun showFragment(activity: AppCompatActivity, fragment: Fragment, b: Bundle?, addToStack: Boolean) {
        val fm = activity.supportFragmentManager
        val ft = fm.beginTransaction()
        fragment.arguments = b
        ft.replace(R.id.content, fragment)
        if (addToStack) ft.addToBackStack(null)
        ft.commit()
    }

    fun showShoppingListFragment(activity: AppCompatActivity) {
        showFragment(activity, ShoppingListFragment(), null, false)
    }

    fun showProductListFragment(activity: AppCompatActivity, productList: ProductList) {
        var b = Bundle()
        b.putSerializable(ViewListFragment.BUNDLE.PRODUCT_LIST, productList)
        showFragment(activity, ViewListFragment(), b, true)
    }

    fun showCategoryProductsFragment(activity: AppCompatActivity) {
        showFragment(activity, CategoryProductsFragment(), null, false)
    }

    fun showAddListScreen(context: Context) {
        CreateNewListActivity.launch(context)
    }
}
