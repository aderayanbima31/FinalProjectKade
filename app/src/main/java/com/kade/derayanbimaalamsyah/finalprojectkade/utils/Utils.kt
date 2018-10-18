package com.kade.derayanbimaalamsyah.finalprojectkade.utils

import android.content.Context
import android.view.View
import com.kade.derayanbimaalamsyah.finalprojectkade.model.database.FootballDbHelper


fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

val Context.db: FootballDbHelper
    get() = FootballDbHelper.getInstance(applicationContext)