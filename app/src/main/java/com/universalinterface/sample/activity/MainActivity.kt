package com.universalinterface.sample.activity

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import com.universalinterface.library.*
import com.universalinterface.sample.R
import com.universalinterface.sample.base.BaseFragment
import com.universalinterface.sample.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mFragments: MutableList<Fragment>
    private var mCurrentFragment: Fragment? = null
    private lateinit var mFragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFragmentManager = supportFragmentManager
        initData()

    }

    private fun initData() {
        mFragments = ArrayList()
        mFragments.add(FragmentOne())
        mFragments.add(FragmentTwo())
        mFragments.add(FragmentThree())
        mFragments.add(FragmentFour())

        val fragmentAdapter = FragmentAdapter(mFragmentManager, mFragments)
        viewPager.adapter = fragmentAdapter

    }

    @SuppressLint("CommitTransaction")
    fun setFunctionManager(tag: String) {
        val fragment = mFragmentManager.findFragmentByTag(tag) as BaseFragment
        val functionManager = FunctionManager.get()
        fragment.setFunctionManager(functionManager
                .addFunction(object : FunctionNoParamNoResult(FragmentOne.INTERFACE) {
                    override fun function() {
                        Log.e("Main", "无参数无返回值")
                    }
                })
                .addFunction(object : FunctionNoParamHasResult<String>(FragmentTwo.INTERFACE) {
                    override fun function(): String {
                        return "333"
                    }

                })
                .addFunction(object : FunctionHasParamNoResult<Int>(FragmentThree.INTERFACE) {
                    override fun function(param: Int) {
                        Log.e("Main", "参数： $param")
                    }

                })
                .addFunction(object : FunctionHasParamHasResult<Int, String>(FragmentFour.INTERFACE) {
                    override fun function(param: Int): String {
                        Log.e("Main ", "参数：$param")
                        return "444"
                    }

                })
        )
    }
}
