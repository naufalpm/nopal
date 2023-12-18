package com.polstat.ukmesport.retrofit

import android.content.Context
import android.content.SharedPreferences
import com.polstat.ukmesport.auth.SessionCache
import com.polstat.ukmesport.auth.SessionCacheImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun getSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("UKMESPORT", Context.MODE_PRIVATE)
    }

    @Provides
    fun provideSessionCache(sharedPreferences: SharedPreferences): SessionCache {
        return SessionCacheImpl(sharedPreferences)
    }
}
