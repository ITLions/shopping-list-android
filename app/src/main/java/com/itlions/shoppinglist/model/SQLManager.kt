package com.itlions.shoppinglist.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper

/**
 * TODO change name after importin external database
 */
class SQLManager(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "temp_name", null, 1) {

    companion object {
        private var instance: SQLManager? = null

        fun getInstance(ctx: Context): SQLManager {
            if (instance == null) {
                instance = SQLManager(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables (more info about that is below)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
    }
}

// Access property for Context
val Context.database: SQLManager
    get() = SQLManager.getInstance(getApplicationContext())