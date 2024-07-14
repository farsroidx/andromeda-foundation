@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package ir.farsroidx.m31

class AndromedaEvent <out T> (private val content: T) {

    var hasBeenHandled = false; private set

    fun getContentIfNotHandled(): T? =
        if (hasBeenHandled) null else { hasBeenHandled = true; content }

    fun peekContent(): T = content
}