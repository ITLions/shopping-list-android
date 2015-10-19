package com.itlions.shoppinglist.fragment.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Oleg on 18.10.2015.
 */

abstract class BaseFragment() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(getLayoutId(), container, false);
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        initView()
        initPresenter()
    }

    abstract fun getLayoutId() : Int

    abstract fun initPresenter()

    abstract fun initView()
}