package com.universalinterface.library

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/1
 * Description: 无参数有返回值
 */
abstract class FunctionNoParamHasResult<out Result>(var functionName: String): Function(functionName) {

    abstract fun function(): Result
}