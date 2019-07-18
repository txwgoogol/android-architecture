package com.example.todomvvm.data.entity.demo

import android.graphics.Bitmap
import androidx.room.*

@Entity(
    tableName = "user",
    foreignKeys = [],
    indices = [Index(value = ["first_name","last_name"],unique = false)]
)
class User {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    @ColumnInfo(name = "first_name")
    var firstName: String = ""
    @ColumnInfo(name = "last_name")
    var lastName: String = ""
    @Ignore
    var picture: Bitmap? = null

}