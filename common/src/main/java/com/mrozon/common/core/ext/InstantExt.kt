package com.mrozon.common.core.ext

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.toLocalDateTime


@OptIn(FormatStringsInDatetimeFormats::class)
fun Instant.toSimpleFormat(pattern: String = "dd MMM yyyy"): String {
    val created = this.toLocalDateTime(TimeZone.currentSystemDefault())
    return created.format(LocalDateTime.Format { byUnicodePattern(pattern) })
}