package com.sameerapps.widget.ShowingWedgit

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // you can check app widget is loaded or not by using shared prefernce
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mAppWidgetManager = getSystemService(AppWidgetManager::class.java)
            val myProvider = ComponentName(this, Widget::class.java)
            val b = Bundle()
            b.putString("ggg", "ggg")
            if (mAppWidgetManager.isRequestPinAppWidgetSupported) {
                val pinnedWidgetCallbackIntent =
                    Intent(this, Widget::class.java)
                val successCallback = PendingIntent.getBroadcast(
                    this, 0,
                    pinnedWidgetCallbackIntent, PendingIntent.FLAG_IMMUTABLE
                )
                mAppWidgetManager.requestPinAppWidget(myProvider, b, successCallback)
            }
        }

    }


}