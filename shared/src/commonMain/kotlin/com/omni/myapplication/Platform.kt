package com.omni.myapplication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform