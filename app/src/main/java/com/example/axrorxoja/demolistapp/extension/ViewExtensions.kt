package com.example.axrorxoja.demolistapp.extension

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/*
* Created by axrorxoja on 30/10/18
*/

fun View.changeVisibility(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
}

fun ViewGroup.showSnackbar(@StringRes textId: Int) = Snackbar.make(this, textId, Snackbar.LENGTH_SHORT).show()

fun Context.tintDrawable(drawableRes: Int, colorRes: Int): Drawable {
    val wrapDrawable = DrawableCompat.wrap(ContextCompat.getDrawable(this, drawableRes)!!).mutate()
    DrawableCompat.setTint(wrapDrawable, color(colorRes))
    return wrapDrawable
}

fun Context.color(colorRes: Int) = ContextCompat.getColor(this, colorRes)

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, inflater: LayoutInflater) = inflater.inflate(layoutRes, this, false)

fun <T> lazyFast(operation: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { operation() }