package com.itlions.shoppinglist.dialog

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Spinner
import com.itlions.shoppinglist.R
import com.itlions.shoppinglist.model.Product
import org.jetbrains.anko.AlertDialogBuilder

/**
 * Created by omazhukin on 10/27/2015.
 */
class DialogHelper {

    fun showProductDialog(c: Context, p: Product, l : DialogInterface.OnClickListener) {
        var builder = AlertDialog.Builder(c);
        builder.setTitle("Set Product Units");
        builder.setPositiveButton(android.R.string.ok, l)
        builder.setNegativeButton(android.R.string.cancel, null)

        var units = c.resources.getStringArray(R.array.units)
        var inflater = (c as Activity).layoutInflater;
        var view = inflater?.inflate(R.layout.dialog_add_product, null)
        var spinner = view?.findViewById(R.id.spinner) as Spinner
        var unitsValue = view?.findViewById(R.id.editText)
        var adapter = ArrayAdapter<String>(c, android.R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter
        builder.setView(view)
        builder.create().show()
    }
}
