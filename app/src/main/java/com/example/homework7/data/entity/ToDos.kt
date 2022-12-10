package com.example.homework7.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "toDos")
data class ToDos (@PrimaryKey(autoGenerate = true)
                  @ColumnInfo(name = "id")@NotNull var id : Int,
                  @ColumnInfo(name = "name")@NotNull var name : String): java.io.Serializable{
}