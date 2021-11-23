package com.frein.weather.Model

import android.provider.BaseColumns

object FeedReaderContract {
    // Table contents are grouped together in an anonymous object.
    object FeedEntry : BaseColumns {
        const val TABLE_NAME = "town_list"
        const val COLUMN_NAME_TOWN = "town_name"
    }
}