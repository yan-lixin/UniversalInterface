package com.universalinterface.sample.base

import android.content.Context
import android.support.v4.app.Fragment
import android.util.Log
import com.universalinterface.library.FunctionManager
import com.universalinterface.sample.activity.MainActivity

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/1
 * Description:
 */
abstract class BaseFragment: Fragment() {

    protected var mFunctionManager: FunctionManager? = null

    private lateinit var mBaseActivity: MainActivity

    fun setFunctionManager(functionManager: FunctionManager) {
        this.mFunctionManager = functionManager
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainActivity) {
            mBaseActivity = context
            mBaseActivity.setFunctionManager(tag!!)
        }
    }
}