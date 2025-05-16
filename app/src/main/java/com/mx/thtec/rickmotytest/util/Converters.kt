package com.mx.thtec.rickmotytest.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mx.thtec.rickmotytest.data.model.Location


class Converters {

    @TypeConverter
    fun fromLocation(location: Location): String {
        return Gson().toJson(location)
    }

    @TypeConverter
    fun toLocation(locationString: String): Location {
        val locationType = object : TypeToken<Location>() {}.type
        return Gson().fromJson(locationString, locationType)
    }
}
