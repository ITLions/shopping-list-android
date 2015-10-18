package com.itlions.shoppinglist.model

import android.app.Activity
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

/**
 * TODO implement javadoc
 */
fun Activity.asyncWithResult<T>(task : () -> T?, after : (T?) -> Any) {
    var result : T?
    async {
        result = task()
        uiThread {
            after(result)
        }
    }
}
