package com.nonamer777.madlevel5task2.utils.viewBinding

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

interface IViewBindingHolder<V: ViewBinding> {

    val binding: V?

    fun initBinding(binding: V, fragment: Fragment, onBound: (V.() -> Unit)?): View

    fun requireBinding(block: (V.() -> Unit)?): V
}
