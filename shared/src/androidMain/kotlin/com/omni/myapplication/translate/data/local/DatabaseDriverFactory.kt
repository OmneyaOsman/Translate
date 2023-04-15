package com.omni.myapplication.translate.data.local

import android.content.Context
import com.omni.myapplication.database.translateDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory (private val context: Context){
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(translateDatabase.Schema , context ,"translate.db")
    }
}