package com.jhonjto.mindicador.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jhonjto.domain.consultado.DomainConsultadoIndicador
import com.jhonjto.domain.indicadores.DomainIndicadores
import com.jhonjto.mindicador.ui.common.*
import com.jhonjto.usecases.GetIndicadoresList
import com.jhonjto.usecases.PostConsultaIndicador
import com.movies.data.common.Status
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

/**
 * Created by jhon on 15/10/2020
 */
class MainViewModel(
    private val getIndicadoresList: GetIndicadoresList,
    private val postConsultaIndicador: PostConsultaIndicador,
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
        data class Navigation(val bitcoin: Bitcoin) : UiModel()
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
            val result = postConsultaIndicador.invoke(tipoIndicador)
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

    fun onIndicadorClicked(bitcoin: Bitcoin) {
        _model.value = UiModel.Navigation(bitcoin)
    }

    fun onConsultaClicked(domainConsultadoIndicador: DomainConsultadoIndicador) {
        _model.value = UiModel.Consulta(domainConsultadoIndicador)
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}