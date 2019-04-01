package com.universalinterface.sample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.universalinterface.library.FunctionManager
import com.universalinterface.sample.R
import com.universalinterface.sample.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_three.*

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/1
 * Description:
 */
class FragmentThree : BaseFragment() {

    companion object {
        val INTERFACE = FragmentThree::class.java.name
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentThreeText.setOnClickListener {
            FunctionManager.get().invokeFunction(INTERFACE, 111)
        }
    }
}