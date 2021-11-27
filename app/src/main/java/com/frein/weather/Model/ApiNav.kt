package com.frein.weather.Model

import org.json.JSONObject

interface ApiNav {
    fun getStringJson(townName: String): String?
    fun parseJsonToArr(jsonStr: String): ArrayList<String>
}