package com.universalinterface.sample.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.universalinterface.sample.R
import com.universalinterface.sample.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_one.*

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/1
 * Description:
 */
class FragmentOne : BaseFragment() {

    companion object {
        val INTERFACE = FragmentOne::class.java.name
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentOneText.setOnClickListener {
            mFunctionManager?.invokeFunction(INTERFACE)
        }
    }
}