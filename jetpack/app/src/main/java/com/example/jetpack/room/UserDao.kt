package com.example.jetpack.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE (:first_name) AND last_name LIKE (:last_name)")
    fun findByName(first_name: String, last_name: String): User

    @Insert
    fun insertAll(vararg user: User)

    @Delete
    fun delete(user: User)

}