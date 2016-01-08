package com.itlions.shoppinglist.ui.views.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itlions.shoppinglist.presenters.base.BasePresenter
import com.itlions.shoppinglist.ui.views.base.BaseView

/**
 * Created by Oleg on 18.10.2015.
 */
abstract class BaseFragment<T : BasePresenter>() : Fragment(), BaseView {

    val presenter : T by lazy {
        initPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(getLayoutId(), container, false);
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        initView()
        afterViewInited()
    }

    override fun getContext(): Context {
        return activity;
    }

    abstract fun getLayoutId() : Int

    abstract fun initPresenter() : T

    abstract fun initView()

    abstract fun afterViewInited()
}