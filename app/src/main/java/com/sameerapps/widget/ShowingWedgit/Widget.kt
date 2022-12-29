package com.sameerapps.widget.ShowingWedgit

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.graphics.Bitmap
import android.widget.RemoteViews
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.AppWidgetTarget
import com.bumptech.glide.request.transition.Transition

class Widget: AppWidgetProvider() {


    override fun onUpdate(
        context: Context, appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray?
    ) {
        val thisWidget = ComponentName(
           context,
          Widget::class.java
       )
        val remoteViews = RemoteViews(
                context.packageName,
                R.layout.widget_layout
            )
        val awt: AppWidgetTarget = object : AppWidgetTarget(context.applicationContext, R.id.update, remoteViews,thisWidget) {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                super.onResourceReady(resource, transition)
            }
        }

        var options = RequestOptions().
        override(300, 300).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background)

        Glide.with(context.applicationContext).asBitmap().load(R.drawable.pic).apply(options).into(awt)

    }

}