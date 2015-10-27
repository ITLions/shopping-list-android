package com.itlions.shoppinglist.navigation

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.itlions.shoppinglist.CreateNewListActivity
import com.itlions.shoppinglist.R

/**
 * Created by omazhukin on 10/19/2015.
 */

public object Navigator {

    fun showFragment(activity: AppCompatActivity, fragment: Fragment) {
        showFragment(activity, fragment, false)
    }

    fun showFragment(activity: AppCompatActivity, fragment: Fragment, addToStack : Boolean) {
        val fm = activity.supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.content, fragment)
        if(addToStack) ft.addToBackStack(null)
        ft.commit()
    }

    fun showAddListScreen(context: Context) {
        CreateNewListActivity.launch(context)
    }
}
