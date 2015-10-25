package com.itlions.shoppinglist.navigation

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.itlions.shoppinglist.AddNewListActivity
import com.itlions.shoppinglist.R

/**
 * Created by omazhukin on 10/19/2015.
 */

public object Navigator {

    fun showFragment(activity: AppCompatActivity, fragment: Fragment) {
        val fm = activity.supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.content, fragment).commit();
    }

    fun showAddListScreen(context: Context) {
        AddNewListActivity.launch(context)
    }
}
