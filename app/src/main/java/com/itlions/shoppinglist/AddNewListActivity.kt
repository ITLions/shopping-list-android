package com.itlions.shoppinglist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.itlions.shoppinglist.navigation.Navigator
import com.itlions.shoppinglist.views.AddListFragment

/**
 * TODO implement javadoc
 */
class AddNewListActivity : AppCompatActivity() {

    companion object {
        fun launch(context : Context) = context.startActivity(Intent(context, javaClass<AddNewListActivity>()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_list)
        Navigator.showFragment(this, AddListFragment())
    }
}