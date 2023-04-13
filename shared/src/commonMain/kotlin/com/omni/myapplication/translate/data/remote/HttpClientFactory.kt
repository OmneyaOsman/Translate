package com.omni.myapplication.translate.data.remote

import io.ktor.client.*

expect class HttpClientFactory {
    fun create(): HttpClient
}