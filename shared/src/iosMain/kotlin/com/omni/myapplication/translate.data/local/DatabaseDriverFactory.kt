package com.omni.myapplication.translate.data.local

import com.omni.myapplication.database.translateDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory{
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(translateDatabase.Schema ,"translate.db")
    }
}