package com.itlions.shoppinglist.presenters.helper

import com.itlions.shoppinglist.presenters.base.BasePresenter
import java.util.*
import kotlin.properties.Delegates

/**
 * Created by Oleg on 18.10.2015.
 */
public object PresenterHolder {

    var presenterHolder = HashMap<String, BasePresenter>() ;

    fun putPresenter(name: String, p: BasePresenter) {
        presenterHolder.put(name, p);
    }

    fun getPresenter(name: String): BasePresenter {
        return presenterHolder.get(name) as BasePresenter;
    }

    fun removePresenter(name: String) {
        presenterHolder.remove(name);
    }
}
