package com.mrozon.common.core.ext

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.toSimpleDate(pattern: String = "yyyy-MM-dd"): Date {
    return SimpleDateFormat(pattern, Locale.getDefault()).parse(this)!!
}