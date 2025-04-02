package com.mx.thtec.rickmotytest.util

import androidx.room.TypeConverter
import com.mx.thtec.rickmotytest.data.model.Origin
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun fromOrigin(origin: Origin): String {
        return Gson().toJson(origin)
    }

    @TypeConverter
    fun toOrigin(originString: String): Origin {
        return Gson().fromJson(originString, Origin::class.java)
    }
}