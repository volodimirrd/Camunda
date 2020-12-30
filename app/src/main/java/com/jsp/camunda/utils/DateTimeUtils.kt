package com.jsp.camunda.utils

import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {
    private val DATE_TIME_FORMAT_FOR_SERVER= "yyyy-MM-dd'T'HH:mm:ss.SSSZ"

    private fun getLocale(): Locale {
        return  Locale.ENGLISH
    }

    @JvmStatic
    fun getDateWithTime(dateTime: String?) : String {
        val date = getDate(dateTime)
        return date?.let { getDateWithTime(it) }?: ""
    }

    fun getDate(dateTime: String?): Date?{
        val dateFormat = SimpleDateFormat(DATE_TIME_FORMAT_FOR_SERVER, getLocale())
        return dateTime?.let { dateFormat.parse(it) }
    }

    @JvmStatic
    fun getDateWithTime(date: Date?): String {
        val dateFormat = SimpleDateFormat("MM/dd/yyyy HH:mm", getLocale())
        return date?.let { dateFormat.format(it) }?:""
    }
}