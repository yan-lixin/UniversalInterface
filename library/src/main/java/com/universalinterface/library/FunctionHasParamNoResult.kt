package com.universalinterface.library

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/1
 * Description: 有参数无返回值
 */
abstract class FunctionHasParamNoResult<out Param>(var functionName: String): Function(functionName) {

    abstract fun function(param: @UnsafeVariance Param)
}