package com.itlions.shoppinglist.model.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * TODO implement javadoc
 */
class SLDatabase(ctx: Context, dbName: String) : ManagedSQLiteOpenHelper(ctx, dbName, null, 1) {

    companion object {

        var instance: SLDatabase? = null

        fun import(ctx: Context, dbName: String) {
            instance = SLDatabase(ctx, dbName);
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables (more info about that is below)
        instance?.use {
            createTable(Table.Product.NAME,
                    true,
                    Table.Product.FIELD_ID to INTEGER + PRIMARY_KEY + UNIQUE,
                    Table.Product.FIELD_NAME to TEXT,
                    Table.Product.FIELD_DESCRIPTION to TEXT,
                    Table.Product.FIELD_ICON to TEXT,
                    Table.Product.FIELD_UNIT to INTEGER,
                    Table.Product.FIELD_CATEGORY to INTEGER)
            createTable(
                    Table.Unit.NAME,
                    true,
                    Table.Unit.FIELD_ID to INTEGER + PRIMARY_KEY + UNIQUE,
                    Table.Unit.FIELD_NAME to TEXT)
            createTable(
                    Table.Category.NAME,
                    true,
                    Table.Category.FIELD_ID to INTEGER + PRIMARY_KEY + UNIQUE,
                    Table.Category.FIELD_NAME to TEXT,
                    Table.Category.FIELD_DESCRIPTION to TEXT,
                    Table.Category.FIELD_ICON to TEXT)
            createTable(
                    Table.ProductList.NAME,
                    true,
                    Table.ProductList.FIELD_ID to INTEGER + PRIMARY_KEY + UNIQUE,
                    Table.ProductList.FIELD_NAME to TEXT,
                    Table.ProductList.FIELD_CREATED_DATE to INTEGER)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
    }
}

// Access property for Context
val Context.database: SLDatabase
    get() = SLDatabase.instance!!