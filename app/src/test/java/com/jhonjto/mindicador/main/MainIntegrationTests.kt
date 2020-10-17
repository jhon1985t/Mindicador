package com.jhonjto.mindicador.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.jhonjto.mindicador.defaultFakeIndicadores
import com.jhonjto.mindicador.initMockedDi
import com.jhonjto.mindicador.ui.main.MainViewModel
import com.jhonjto.usecases.GetConsultaIndicador
import com.jhonjto.usecases.GetIndicadoresList
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.get
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainIntegrationTests : AutoCloseKoinTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var observer: Observer<MainViewModel.UiModel>

    private lateinit var vm: MainViewModel

    @Before
    fun setUp() {
        val vmModule = module {
            factory { MainViewModel(get(), get(), get()) }
            factory { GetIndicadoresList(get()) }
            factory { GetConsultaIndicador(get()) }
        }

        initMockedDi(vmModule)
        vm = get()
    }

    @Test
    fun `data is loaded from server`() {
        vm.model.observeForever(observer)

        verify(observer).onChanged(MainViewModel.UiModel.Content(defaultFakeIndicadores))
    }
}