package com.omni.myapplication.android.di

import android.app.Application
import com.omni.myapplication.database.translateDatabase
import com.omni.myapplication.translate.data.history.SqlDelightHistoryDataSource
import com.omni.myapplication.translate.data.local.DatabaseDriverFactory
import com.omni.myapplication.translate.data.remote.HttpClientFactory
import com.omni.myapplication.translate.data.translate.KtorTranslateClient
import com.omni.myapplication.translate.domain.history.HistoryDataSource
import com.omni.myapplication.translate.domain.translate.Translate
import com.omni.myapplication.translate.domain.translate.TranslateClient
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTranslateUseCase(client: TranslateClient ,historyDataSource: HistoryDataSource ) :Translate{
        return Translate(client, historyDataSource)
    }

    @Provides
    @Singleton
    fun provideTranslateClient(httpClient: HttpClient) :TranslateClient{
        return KtorTranslateClient(httpClient)
    }

    @Provides
    @Singleton
    fun provideHttpClient() :HttpClient{
        return HttpClientFactory().create()
    }

    @Provides
    @Singleton
    fun provideHistoryDataSource(driver: SqlDriver) :HistoryDataSource{
        return SqlDelightHistoryDataSource(translateDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideSqlDriver(application: Application) :SqlDriver{
        return DatabaseDriverFactory(application).create()
    }


}