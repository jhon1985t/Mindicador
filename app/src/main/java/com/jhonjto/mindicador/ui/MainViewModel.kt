package com.jhonjto.mindicador.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jhonjto.domain.indicadores.DomainIndicadores
import com.jhonjto.mindicador.ui.common.ScopedViewModel
import com.jhonjto.usecases.GetIndicadoresList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

/**
 * Created by jhon on 15/10/2020
 */
class MainViewModel(
    private val getIndicadoresList: GetIndicadoresList,
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

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val domainIndicadores: DomainIndicadores) : UiModel()
        data class Navigation(val domainIndicadores: DomainIndicadores) : UiModel()
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

    fun onIndicadorClicked(domainIndicadores: DomainIndicadores) {
        _model.value = UiModel.Navigation(domainIndicadores)
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}