package com.bina.details.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.bina.details.data.api.RetrofitService
import com.bina.details.data.datasouce.DetailsDataSource
import com.bina.details.data.datasouce.DetailsDataSourceImpl
import com.bina.details.data.repository.DetailsRepositoryImpl
import com.bina.details.domain.repository.DetailsRepository
import com.bina.details.domain.usecase.GetCharacterDetailsUseCase
import com.bina.details.presentation.mapper.CharacterDetailsUiMapper
import com.bina.details.presentation.viewmodel.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal class DetailsModule {

    @RequiresApi(Build.VERSION_CODES.N)
    val dataModule = module {
        factory { RetrofitService.service }

        factory<DetailsDataSource> { DetailsDataSourceImpl(get()) }
        factory<DetailsRepository> { DetailsRepositoryImpl(get()) }
    }

    val domainModule = module {
        factory { GetCharacterDetailsUseCase(get()) }
    }

    val presentationModule = module {
        factory { CharacterDetailsUiMapper() }
        viewModel { DetailsViewModel(get(), get()) }
    }
}

val detailsFeatureModule = DetailsModule().run {
    listOf(
        dataModule,
        domainModule,
        presentationModule
    )
}
