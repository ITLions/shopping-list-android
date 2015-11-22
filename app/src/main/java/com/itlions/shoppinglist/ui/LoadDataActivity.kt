package com.itlions.shoppinglist.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.model.Category
import com.itlions.shoppinglist.model.SLDataManager
import com.itlions.shoppinglist.model.network.Service
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread
import kotlin.properties.Delegates

/**
 * TODO implement javadoc
 */
class LoadDataActivity : AppCompatActivity() {
    var log by Delegates.notNull<TextView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_details)
        log = find(R.id.log)
    }

    fun load(view: View) {
        var networkManager = Service()

        async {
            var message: String?;
            var items: List<Category>?
            var resp = networkManager.service.loadCategories(0, 30).execute()
            items = resp.body().content.items
            message = items.toString()

            items.forEach { item -> SLDataManager.saveCategory(view.context, item) }

            uiThread {
                log.text = message
            }
        }
    }
}