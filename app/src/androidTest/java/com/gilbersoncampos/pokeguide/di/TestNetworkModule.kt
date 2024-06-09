package com.gilbersoncampos.pokeguide.di

import com.gilbersoncampos.pokeguide.data.network.datasource.NetworkDataSource
import com.gilbersoncampos.pokeguide.data.network.datasource.NetworkDataSourceImpl
import com.gilbersoncampos.pokeguide.testing.datasource.FakeNetworkDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [NetworkModule::class]
)
object TestNetworkModule {
    @Provides
    fun provideApiHelper(apiHelper: FakeNetworkDataSourceImpl): NetworkDataSource =
        apiHelper
}