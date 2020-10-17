package com.jhonjto.usecases

import com.jhonjto.data.repository.ConsultaIndicadorMesRepository
import com.jhonjto.domain.consultado.DomainConsultadoIndicador
import com.movies.data.common.Resource

/**
 * Created by jhon on 17/10/2020
 */
class GetConsultaIndicadorMes(private val consultaIndicadorMesRepository: ConsultaIndicadorMesRepository) {
    suspend fun invoke(tipoIndicador: String, ultimoMes: String): Resource<DomainConsultadoIndicador> =
        consultaIndicadorMesRepository.getConsultaIndicadoresMes(tipoIndicador, ultimoMes)
}