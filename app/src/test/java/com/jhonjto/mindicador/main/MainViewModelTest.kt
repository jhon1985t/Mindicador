package com.jhonjto.mindicador.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.jhonjto.domain.indicadores.*
import com.jhonjto.mindicador.ui.main.MainViewModel
import com.jhonjto.testshared.mockedConsultado
import com.jhonjto.testshared.mockedIndicador
import com.jhonjto.usecases.GetConsultaIndicador
import com.jhonjto.usecases.GetIndicadoresList
import com.movies.data.common.Resource
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var getIndicadoresList: GetIndicadoresList

    @Mock
    lateinit var getConsultaIndicador: GetConsultaIndicador

    @Mock
    lateinit var observer: Observer<MainViewModel.UiModel>

    private lateinit var vm: MainViewModel

    @Before
    fun setUp() {
        vm = MainViewModel(getIndicadoresList, getConsultaIndicador, Dispatchers.Unconfined)
    }

    @Test
    fun `after requesting the list, loading is shown`() {
        runBlocking {

            val indicador = mockedIndicador.copy(
                autor = "jhon", bitcoin = Bitcoin(
                    "bitcoin",
                    "20--11-2018",
                    "bitcoin",
                    "dolar",
                    2.000
                ), dolar = Dolar(
                    "bitcoin",
                    "20--11-2018",
                    "bitcoin",
                    "dolar",
                    2.000
                ),
                dolarIntercambio = DolarIntercambio(
                    "bitcoin",
                    "20--11-2018",
                    "bitcoin",
                    "dolar",
                    2.000
                ),
                euro = Euro(
                    "bitcoin",
                    "20--11-2018",
                    "bitcoin",
                    "dolar",
                    2.000
                ),
                fecha = "17-10-2020",
                imacec = Imacec(
                    "bitcoin",
                    "20--11-2018",
                    "bitcoin",
                    "dolar",
                    2.000
                ),
                ipc = Ipc(
                    "bitcoin",
                    "20--11-2018",
                    "bitcoin",
                    "dolar",
                    2.000
                ),
                ivp = Ivp(
                    "bitcoin",
                    "20--11-2018",
                    "bitcoin",
                    "dolar",
                    2.000
                ),
                libraCobre = LibraCobre(
                    "bitcoin",
                    "20--11-2018",
                    "bitcoin",
                    "dolar",
                    2.000
                ),
                tasaDesempleo = TasaDesempleo(
                    "bitcoin",
                    "20--11-2018",
                    "bitcoin",
                    "dolar",
                    2.000
                ),
                tpm = Tpm(
                    "bitcoin",
                    "20--11-2018",
                    "bitcoin",
                    "dolar",
                    2.000
                ),
                uf = Uf(
                    "bitcoin",
                    "20--11-2018",
                    "bitcoin",
                    "dolar",
                    2.000
                ),
                utm = Utm(
                    "bitcoin",
                    "20--11-2018",
                    "bitcoin",
                    "dolar",
                    20
                ),
                version = "1.0"
            )
            whenever(getIndicadoresList.invoke()).thenReturn(indicador)
            vm.model.observeForever(observer)

            verify(observer).onChanged(MainViewModel.UiModel.Loading)
        }
    }

    @Test
    fun `after requesting the list, getConsulta is called`() {
        runBlocking {
            val consultaIndicador = mockedConsultado.copy(
                "jhon",
                "bitcoin",
                "Bitcoin",
                listOf(),
                "dolar",
                "1.0")
            whenever(getConsultaIndicador.invoke("bitcoin")).thenReturn(
                Resource.success(
                    consultaIndicador
                )
            )

            vm.model.observeForever(observer)

            verify(observer).onChanged(MainViewModel.UiModel.Consulta(consultaIndicador))
        }
    }
}