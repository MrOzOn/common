package com.mrozon.common.core.ext

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.annotation.StringRes
import timber.log.Timber

fun Context.openPrivacyPolicy(@StringRes urlRes: Int) {
    val i = Intent(Intent.ACTION_VIEW)
    i.data = Uri.parse(this.getString(urlRes))
    this.startActivity(i)
}

fun Context.rateApp() {
    try {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(APP_MARKET_LINK + packageName)
            )
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        )
    } catch (e: ActivityNotFoundException) {
        Timber.e(e)
    }
}

fun Context.sendEmailToDeveloper(@StringRes appNameRes: Int, email: String) {
    val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:$email")
        putExtra(Intent.EXTRA_SUBJECT, this@sendEmailToDeveloper.getString(appNameRes))
    }
    this.startActivity(Intent.createChooser(emailIntent, ""))
}

fun Context.getAppVersion(): String {
    return try {
        val pInfo = packageManager.getPackageInfo(packageName, 0)
        pInfo.versionName
    } catch (e: PackageManager.NameNotFoundException) {
        Timber.e(e, "PackageManager.NameNotFoundException")
        ""
    }
}

private const val APP_MARKET_LINK = "market://details?id="