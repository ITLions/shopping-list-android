package com.itlions.shoppinglist.model.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper

/**
 * TODO implement javadoc
 */
class SLDatabase(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "temp_name", null, 1) {

    companion object {

        private var instance: SLDatabase? = null

        fun getInstance(ctx: Context): SLDatabase {
            if (instance == null) {
                instance = SLDatabase(ctx.applicationContext)
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
val Context.database: SLDatabase
    get() = SLDatabase.getInstance(applicationContext)