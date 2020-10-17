package com.jhonjto.mindicador.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jhonjto.domain.consultado.DomainConsultadoIndicador
import com.jhonjto.mindicador.ui.common.ScopedViewModel
import com.jhonjto.usecases.GetConsultaIndicadorMes
import com.movies.data.common.Resource
import com.movies.data.common.Status
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

/**
 * Created by jhon on 16/10/2020
 */
class DetailViewModel(
    private val consultaIndicador: String,
    private val getConsultaIndicadorMes: GetConsultaIndicadorMes,
    override val uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {

    data class UiModel(val domainConsultadoIndicador: DomainConsultadoIndicador)

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) findIndicador()
            return _model
        }

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    init {
        initScope()
    }

    private fun findIndicador() = launch {
        val result = getConsultaIndicadorMes.invoke(consultaIndicador, "17-10-2020")
        when(result.status){
            Status.SUCCESS -> {
                _model.value = UiModel(result.data!!)
            }
            Status.ERROR -> {
                _message.value = result.message
            }
            else -> {}
        }
    }
}