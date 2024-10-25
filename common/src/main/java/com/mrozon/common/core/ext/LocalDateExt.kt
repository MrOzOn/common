package com.mrozon.common.core.ext

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun LocalDate.toSimpleFormat(pattern: String = "dd MMM yyyy"): String {
    val format = DateTimeFormatter.ofPattern(pattern)
    return this.format(format)
}