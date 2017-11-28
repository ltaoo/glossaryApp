package com.example.kotlin.glossaryapplication

/**
 * Created by ltaoo on 2017/11/28.
 */
//data class WeatherinfoModel (
//    val city: String,
//    val cityid: String
//)
//
//data class Response (
//        val weatherinfo: WeatherinfoModel
//)
data class WeatherinfoModel constructor(val weatherinfo: WeatherinfoBean) {
    data class WeatherinfoBean(
            val city: String,
            val cityid: String
    )
}