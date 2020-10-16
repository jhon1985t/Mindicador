package com.jhonjto.usecases

import com.jhonjto.data.repository.IndicadoresListRepository
import com.jhonjto.domain.indicadores.DomainIndicadores

/**
 * Created by jhon on 15/10/2020
 */
class GetIndicadoresList(private val indicadoresListRepository: IndicadoresListRepository) {
    suspend fun invoke(): DomainIndicadores = indicadoresListRepository.getIndicadoresList()
}