package com.universalinterface.sample.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.universalinterface.sample.R
import com.universalinterface.sample.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_two.*

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/1
 * Description:
 */
class FragmentTwo : BaseFragment() {

    companion object {
        val INTERFACE = FragmentTwo::class.java.name
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentTwoText.setOnClickListener {
            val result = mFunctionManager?.invokeFunction(INTERFACE, String::class.java)
            Log.e("Two", "返回值：$result")
        }
    }
}