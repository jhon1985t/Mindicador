package com.jhonjto.usecases

import com.jhonjto.data.repository.ConsultaIndicadorRepository
import com.jhonjto.domain.consultado.DomainConsultadoIndicador
import com.movies.data.common.Resource

/**
 * Created by jhon on 16/10/2020
 */
class GetConsultaIndicador(private val consultaIndicadorRepository: ConsultaIndicadorRepository) {
    suspend fun invoke(tipoIndicador: String): Resource<DomainConsultadoIndicador> =
        consultaIndicadorRepository.getConsultaIndicadores(tipoIndicador)
}