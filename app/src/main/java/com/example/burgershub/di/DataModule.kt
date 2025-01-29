package com.example.burgershub.di

import com.example.burgershub.data.api.ServiceAPI
import com.example.burgershub.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providesServiceAPI(
        serviceProvider: ServiceProvider
    ) : ServiceAPI {
        return serviceProvider.createService(ServiceAPI::class.java)
    }

}