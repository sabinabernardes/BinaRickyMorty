package com.bina.home.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.bina.home.data.RepositoryRickAndMortyImpl
import com.bina.home.data.datasource.RickAndMortyListCharacterDataSource
import com.bina.home.data.datasource.RickAndMortyListCharacterDataSourceImpl
import com.bina.home.data.mapper.ListCharactersMapper
import com.bina.home.domain.repository.RepositoryRickAndMorty
import com.bina.home.domain.useCase.ListCharactersUseCase
import com.bina.home.presentation.ListCharactersViewModel
import com.bina.home.presentation.viewModel.ListCharactersUiMapper
import com.bina.home.utils.RetrofitService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal class ListCharactersModule : FeatureModule() {

    @RequiresApi(Build.VERSION_CODES.N)
    public override val dataModule = module {
        factory { RetrofitService.service }

        factory<RickAndMortyListCharacterDataSource> {
            RickAndMortyListCharacterDataSourceImpl(
                apiService = get()
            )
        }

        factory<RepositoryRickAndMorty> {
            RepositoryRickAndMortyImpl(
                serviceDataSource = get(), listCharactersMapper = get()
            )
        }
        factory { ListCharactersMapper() }
    }

    public override val domainModule = module {
        factory { ListCharactersUseCase(repository = get()) }
    }

    public override val presentationModule = module {
        factory { ListCharactersUiMapper() }
        viewModel {
            ListCharactersViewModel(
                listCharactersUseCase = get(),
                get()
            )
        }
    }
}

val homeFeatureModule = ListCharactersModule().run {
    listOf(
        dataModule,
        domainModule,
        presentationModule
    )
}