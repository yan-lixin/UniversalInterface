package com.universalinterface.sample.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.universalinterface.library.FunctionManager
import com.universalinterface.sample.R
import com.universalinterface.sample.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_four.*

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/1
 * Description:
 */
class FragmentFour : BaseFragment() {

    companion object {
        val INTERFACE = FragmentFour::class.java.name
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_four, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentFourText.setOnClickListener {
            val result = FunctionManager.get().invokeFunction(INTERFACE, 222, String::class.java)
            Log.e("Four", result)
        }
    }
}