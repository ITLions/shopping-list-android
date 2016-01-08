package com.itlions.shoppinglist.ui.views.base

/**
 * TODO implement javadoc
 */
interface BaseProgressView : BaseView {
    fun showProgress(show : Boolean)
    fun showError(message : String)

}