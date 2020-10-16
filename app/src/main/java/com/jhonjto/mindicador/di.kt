package com.jhonjto.mindicador

import android.app.Application
import com.jhonjto.data.repository.IndicadoresListRepository
import com.jhonjto.data.source.RemoteDataSource
import com.jhonjto.mindicador.data.server.MindicadorAPI
import com.jhonjto.mindicador.data.server.datasources.MindicadorDataSource
import com.jhonjto.mindicador.ui.MainActivity
import com.jhonjto.mindicador.ui.MainViewModel
import com.jhonjto.usecases.GetIndicadoresList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by jhon on 15/10/2020
 */
fun Application.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(appModule, dataModule, scopesModule))
    }
}

private val appModule = module {
    single<CoroutineDispatcher> { Dispatchers.Main }
    single(named("baseUrl")) { "https://mindicador.cl" }
    single { MindicadorAPI(get(named("baseUrl"))) }
    factory<RemoteDataSource> { MindicadorDataSource(get()) }
}

val dataModule = module {
    factory { IndicadoresListRepository(get()) }
}

private val scopesModule = module {
    scope(named<MainActivity>()) {
        viewModel { MainViewModel(get(), get()) }
        scoped { GetIndicadoresList(get()) }
    }
}