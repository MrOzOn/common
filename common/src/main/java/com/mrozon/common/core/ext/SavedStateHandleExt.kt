package com.mrozon.common.core.ext

import androidx.annotation.Keep
import androidx.lifecycle.SavedStateHandle

@Keep
fun SavedStateHandle.showParams(): String =
    this.keys().joinToString { key -> "$key=${this.get<Any>(key)}" }