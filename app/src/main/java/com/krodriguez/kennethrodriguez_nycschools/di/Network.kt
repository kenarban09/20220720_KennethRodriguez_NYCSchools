package com.krodriguez.kennethrodriguez_nycschools.di

import com.krodriguez.kennethrodriguez_nycschools.res.API
import com.krodriguez.kennethrodriguez_nycschools.res.SchoolRepo
import com.krodriguez.kennethrodriguez_nycschools.res.SchoolRepoImp
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * I used hilt to made the app more scalable and testable,
 * Hilt is build on top of dagger so can run in Java and kotlin
 * Benefits:
 * compile-time correctness,
 * runtime performance
 */

@Module
@InstallIn(SingletonComponent::class)
class Network {

    @Provides
    fun providesGson(): Gson = Gson()

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

    @Provides
    fun providesServiceApi(okHttpClient: OkHttpClient, gson: Gson): API =
        Retrofit.Builder()
            .baseUrl(API.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
            .create(API::class.java)

    @Provides
    fun providesIOScheduler(): Scheduler = Schedulers.io()

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable =
        CompositeDisposable()

    @Provides
    fun providesRepository(apiIServiceApi: API): SchoolRepo =
        SchoolRepoImp(apiIServiceApi)
}
