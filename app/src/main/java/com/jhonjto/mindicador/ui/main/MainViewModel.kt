package com.jhonjto.mindicador.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jhonjto.domain.consultado.DomainConsultadoIndicador
import com.jhonjto.domain.indicadores.DomainIndicadores
import com.jhonjto.mindicador.ui.common.*
import com.jhonjto.usecases.GetIndicadoresList
import com.jhonjto.usecases.GetConsultaIndicador
import com.movies.data.common.Status
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

/**
 * Created by jhon on 15/10/2020
 */
class MainViewModel(
    private val getIndicadoresList: GetIndicadoresList,
    private val getConsultaIndicador: GetConsultaIndicador,
    uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) {
                onIndicadoresRequested()
            }
            return _model
        }

    private val _filter = MutableLiveData<DomainIndicadores>()
    val filter: LiveData<DomainIndicadores> = _filter

    private val _consult = MutableLiveData<DomainConsultadoIndicador>()
    val consult: LiveData<DomainConsultadoIndicador> = _consult

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val domainIndicadores: DomainIndicadores) : UiModel()
        data class NavigationBitcoin(val bitcoin: Bitcoin) : UiModel()
        data class NavigationDolar(val dolar: Dolar) : UiModel()
        data class NavigationDolarIntercambio(val dolarIntercambio: DolarIntercambio) : UiModel()
        data class NavigationEuro(val euro: Euro) : UiModel()
        data class NavigationImacec(val imacec: Imacec) : UiModel()
        data class NavigationIpc(val ipc: Ipc) : UiModel()
        data class NavigationIvp(val ivp: Ivp) : UiModel()
        data class NavigationLibraCobre(val libraCobre: LibraCobre) : UiModel()
        data class NavigationTasaDesempleo(val tasaDesempleo: TasaDesempleo) : UiModel()
        data class NavigationTpm(val tpm: Tpm) : UiModel()
        data class NavigationUf(val uf: Uf) : UiModel()
        data class NavigationUtm(val utm: Utm) : UiModel()
        data class Consulta(val domainConsultadoIndicador: DomainConsultadoIndicador) : UiModel()
    }

    init {
        initScope()
    }

    private fun onIndicadoresRequested() {
        launch {
            _model.value = UiModel.Loading
            _model.value = UiModel.Content(getIndicadoresList.invoke())
        }
    }

    fun onFilterRequested() {
        launch {
            _filter.value = getIndicadoresList.invoke()
        }
    }

    fun onConsultaRequested(tipoIndicador: String) {
        launch {
            val result = getConsultaIndicador.invoke(tipoIndicador)
            when(result.status){
                Status.SUCCESS -> {
                    _consult.value = result.data
                }
                Status.ERROR -> {
                    _message.value = result.message
                }
                else -> {}
            }
        }
    }

    fun onBitcoinClicked(bitcoin: Bitcoin) {
        _model.value = UiModel.NavigationBitcoin(bitcoin)
    }

    fun onDolarClicked(dolar: Dolar) {
        _model.value = UiModel.NavigationDolar(dolar)
    }

    fun onDolarIntercambioClicked(dolarIntercambio: DolarIntercambio) {
        _model.value = UiModel.NavigationDolarIntercambio(dolarIntercambio)
    }

    fun onEuroClicked(euro: Euro) {
        _model.value = UiModel.NavigationEuro(euro)
    }

    fun onImacecClicked(imacec: Imacec) {
        _model.value = UiModel.NavigationImacec(imacec)
    }

    fun onIpcClicked(ipc: Ipc) {
        _model.value = UiModel.NavigationIpc(ipc)
    }

    fun onIvpClicked(ivp: Ivp) {
        _model.value = UiModel.NavigationIvp(ivp)
    }

    fun onLibraCobreClicked(libraCobre: LibraCobre) {
        _model.value = UiModel.NavigationLibraCobre(libraCobre)
    }

    fun onTasaDesempleoClicked(tasaDesempleo: TasaDesempleo) {
        _model.value = UiModel.NavigationTasaDesempleo(tasaDesempleo)
    }

    fun onTpmClicked(tpm: Tpm) {
        _model.value = UiModel.NavigationTpm(tpm)
    }

    fun onUfClicked(uf: Uf) {
        _model.value = UiModel.NavigationUf(uf)
    }

    fun onUtmClicked(utm: Utm) {
        _model.value = UiModel.NavigationUtm(utm)
    }

    fun onConsultaClicked(domainConsultadoIndicador: DomainConsultadoIndicador) {
        _model.value = UiModel.Consulta(domainConsultadoIndicador)
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}