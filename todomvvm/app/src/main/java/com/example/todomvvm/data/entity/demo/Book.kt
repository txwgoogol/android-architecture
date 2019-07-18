package com.example.todomvvm.data.entity.demo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "book",
    foreignKeys = [ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["user_id"])],
    indices = []
)
class Book {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var title: String = ""
    @ColumnInfo(name = "user_id")
    var userId: Long = 0

}