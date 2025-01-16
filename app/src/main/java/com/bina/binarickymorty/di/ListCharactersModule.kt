package com.bina.binarickymorty.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.bina.binarickymorty.data.RepositoryRickAndMortyImpl
import com.bina.binarickymorty.data.datasource.RickAndMortyListCharacterDataSource
import com.bina.binarickymorty.data.datasource.RickAndMortyListCharacterDataSourceImpl
import com.bina.binarickymorty.data.mapper.ListCharactersMapper
import com.bina.binarickymorty.domain.repository.RepositoryRickAndMorty
import com.bina.binarickymorty.domain.useCase.ListCharactersUseCase
import com.bina.binarickymorty.presentation.ListCharactersUiModel
import com.bina.binarickymorty.presentation.ListCharactersViewModel
import com.bina.binarickymorty.presentation.viewModel.ListCharactersUiMapper
import com.bina.binarickymorty.utils.RetrofitService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal class ListCharactersModule : FeatureModule() {

    @RequiresApi(Build.VERSION_CODES.N)
    override val dataModule = module {
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

    override val domainModule = module {
        factory { ListCharactersUseCase(repository = get()) }
    }

    override val presentationModule = module {
        factory { ListCharactersUiMapper() }
        viewModel {
            ListCharactersViewModel(
                listCharactersUseCase = get(),
                get()
            )
        }
    }
}