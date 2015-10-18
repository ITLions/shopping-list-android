package com.itlions.shoppinglist.model

import android.app.Activity
import android.content.Context
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import java.io.FileOutputStream

/**
 * TODO implement javadoc
 */
fun Activity.asyncWithResult<T>(task: () -> T, after: (T) -> Any) {
    var result: T
    async {
        result = task()
        uiThread {
            after(result)
        }
    }
}

fun Context.copyDatabaseFromAssets(fromFile: String, toFile: String) {
    var inSt = assets.open(fromFile)
    var outFile = getDatabasePath(toFile)
    var out = FileOutputStream(outFile)
    inSt.copyTo(out)
    inSt.close()
    out.close()
}
