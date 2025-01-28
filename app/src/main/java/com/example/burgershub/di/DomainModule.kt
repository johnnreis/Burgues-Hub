package com.example.burgershub.di

import com.example.burgershub.data.repository.BurgerRepositoryImpl
import com.example.burgershub.domain.repository.BurgerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DomainModule {

    @Binds
    abstract fun bindsBurgerRepositoryImpl(
        burgerRepositoryImpl: BurgerRepositoryImpl
    ) : BurgerRepository

}