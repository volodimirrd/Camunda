package com.jsp.camunda.repository.remote.rest.retrofit

import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {
    const val CONNECT_TIMEOUT_S = 60L
    private const val READ_TIMEOUT_S = 60L

    fun createRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getClient(): OkHttpClient {
        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 1

        val builder = OkHttpClient.Builder()

        builder.connectTimeout(CONNECT_TIMEOUT_S, TimeUnit.SECONDS)
        builder.readTimeout(READ_TIMEOUT_S, TimeUnit.SECONDS)
        builder.dispatcher(dispatcher)
        builder.addInterceptor(loggingInterceptor())
        return builder.build()
    }

    private fun loggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}