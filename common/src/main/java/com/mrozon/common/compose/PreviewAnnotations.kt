package com.mrozon.common.compose

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "Light", showBackground = true, locale = "en")
@Preview(
    name = "Dark",
    showBackground = true,
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
annotation class ThemePreviews

@Preview(fontScale = 1.0f, name = "Default (100%)")
@Preview(fontScale = 0.85f, name = "Small (85%) ")
@Preview(fontScale = 1.15f, name = "Large (115%)")
@Preview(fontScale = 1.3f, name = "Largest (130%) ")
annotation class FontScalePreview

@Preview(locale = "en", name = "English")
@Preview(locale = "ru", name = "Russian")
@Preview(locale = "uk", name = "Ukraine")
annotation class MultiLanguagePreview

@Preview(name = "Phone", device = "spec:width=411dp,height=891dp")
@Preview(name = "Phone Land", device = "spec:width=891dp,height=411dp")
@Preview(name = "Foldable", device = "spec:width=673.5dp,height=841dp,dpi=480")
@Preview(name = "Tablet", device = "spec:width=1280dp,height=800dp,dpi=480")
@Preview(name = "Desktop", device = "spec:width=1920dp,height=1080dp,dpi=480")
annotation class DevicesPreviews
