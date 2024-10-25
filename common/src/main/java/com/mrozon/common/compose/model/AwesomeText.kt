package com.mrozon.common.compose.model

import androidx.annotation.Keep
import androidx.annotation.StringRes

@Keep
sealed class AwesomeText {
    @Keep
    data class Resource(@StringRes val resId: Int) : AwesomeText()

    @Keep
    data class ResourceParams(
        @StringRes val value: Int,
        val args:List<Any>
    ) : AwesomeText()

    @Keep
    data class PlainText(val rawText: String) : AwesomeText()
}