package com.polstat.ukmesport.retrofit

import com.polstat.ukmesport.auth.AuthHelper
import com.polstat.ukmesport.auth.AuthHelperImpl
import com.polstat.ukmesport.auth.MainHelper
import com.polstat.ukmesport.auth.MainHelperImpl
import com.polstat.ukmesport.auth.SessionCache
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkingModule {
    val BASE_URL = "https://a538-101-255-119-38.ngrok-free.app/api/"

    @Provides
    fun OkHttpClient(): OkHttpClient {
        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
    }

    @Provides
    fun provideApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @Provides
    fun provideAuthHelper(authApi: AuthApi, sessionCache: SessionCache): AuthHelper {
        return AuthHelperImpl(authApi, sessionCache)
    }

    @Provides
    fun provideMainApi(retrofit: Retrofit): MainApi{
        return retrofit.create(MainApi::class.java)
    }

    @Provides
    fun provideMainHelper(mainApi: MainApi): MainHelper{
        return MainHelperImpl(mainApi)
    }


}
