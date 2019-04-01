package com.universalinterface.sample.fragment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/1
 * Description:
 */
class FragmentAdapter(fragmentManager: FragmentManager, var fragments: MutableList<Fragment>): FragmentPagerAdapter(fragmentManager) {
    override fun getItem(p0: Int): Fragment {
        return fragments[p0]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}