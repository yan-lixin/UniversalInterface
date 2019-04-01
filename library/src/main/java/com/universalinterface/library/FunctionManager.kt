package com.universalinterface.library

import android.support.v4.app.FragmentManager
import android.util.Log

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/1
 * Description: 方法管理
 */
class FunctionManager private constructor(){

    companion object {
        private var instance: FunctionManager? = null
            get() {
                if (field == null) {
                    field = FunctionManager()
                }
                return field
            }

        fun get(): FunctionManager {
            return instance!!
        }
    }

    private var noParamNoResultMap: MutableMap<String, FunctionNoParamNoResult>? = null
    private var noParamHasResultMap: MutableMap<String, FunctionNoParamHasResult<Any>>? = null
    private var hasParamNoResultMap: MutableMap<String, FunctionHasParamNoResult<Any>>? = null
    private var hasParamHasResultMap: MutableMap<String, FunctionHasParamHasResult<Any, Any>>? = null

    init {
        noParamNoResultMap = HashMap()
        noParamHasResultMap = HashMap()
        hasParamNoResultMap = HashMap()
        hasParamHasResultMap = HashMap()
    }

    /**
     * 添加没有参数，没有返回值的方法
     */
    fun addFunction(function: FunctionNoParamNoResult): FunctionManager {
        noParamNoResultMap?.put(function.functionName, function)
        return this
    }

    /**
     * 执行没有参数，没有返回值的方法
     */
    fun invokeFunction(functionName: String) {
        if (functionName.isEmpty()) {
            return
        }

        if (noParamNoResultMap != null) {
            val function = noParamNoResultMap?.get(functionName)
            if (function != null) {
                function.function()
            } else {
                throw FunctionNotFoundException("has not this function $functionName")
            }

        }
    }

    /**
     * 添加没有参数，有返回值的方法
     */
    fun addFunction(function: FunctionNoParamHasResult<Any>): FunctionManager {
        noParamHasResultMap?.put(function.functionName, function)
        return this
    }

    /**
     * 执行没有参数，有返回值的方法
     */
    fun <Result> invokeFunction(functionName: String, result: Class<Result>): Result? {
        if (functionName.isEmpty()) {
            return null
        }

        if (noParamHasResultMap != null) {
            val function = noParamHasResultMap?.get(functionName)
            if (function != null) {
                return result.cast(function.function())
            } else {
                throw FunctionNotFoundException("has not this function $functionName")
            }

        }
        return null
    }

    /**
     * 添加有参数，没有返回值的方法
     */
    fun addFunction(function: FunctionHasParamNoResult<Any>): FunctionManager {
        hasParamNoResultMap?.put(function.functionName, function)
        return this
    }

    /**
     * 执行有参数，没有返回值的方法
     */
    fun <Param> invokeFunction(functionName: String, param: Param) {
        if (functionName.isEmpty()) {
            return
        }

        if (hasParamNoResultMap != null) {
            val function = hasParamNoResultMap?.get(functionName)
            if (function != null) {
                function.function(param!!)
            } else {
                throw FunctionNotFoundException("has not this function $functionName")
            }

        }

    }

    /**
     * 添加有参数，有返回值的方法
     */
    fun addFunction(function: FunctionHasParamHasResult<Any, Any>): FunctionManager {
        hasParamHasResultMap?.put(function.functionName, function)
        return this
    }

    /**
     * 执行有参数，有返回值的方法
     */
    fun <Param, Result> invokeFunction(functionName: String, param: Param, result: Class<Result>): Result? {
        if (functionName.isEmpty()) {
            return null
        }

        if (hasParamHasResultMap != null) {
            val function = hasParamHasResultMap?.get(functionName)
            if (function != null) {
                return result.cast(function.function(param!!))
            } else {
                throw FunctionNotFoundException("has not this function $functionName")
            }

        }
        return null
    }

}
