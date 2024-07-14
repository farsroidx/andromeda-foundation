@file:Suppress("unused")

package ir.farsroidx.m31

import android.os.Build
import androidx.annotation.RequiresApi

class AndromedaException : RuntimeException {

    constructor()
        : super()

    constructor(message: String?)
        : super(message)

    constructor(cause: Throwable?)
        : super(cause)

    constructor(message: String?, cause: Throwable?)
        : super(message, cause)

    @RequiresApi(Build.VERSION_CODES.N)
    constructor(
        message: String?, cause: Throwable?, enableSuppression: Boolean, writableStackTrace: Boolean
    ) : super(message, cause, enableSuppression, writableStackTrace)

}