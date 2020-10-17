package com.jhonjto.data.repository

import com.jhonjto.data.source.RemoteDataSource
import com.jhonjto.domain.consultado.DomainConsultadoIndicador
import com.movies.data.common.Resource

/**
 * Created by jhon on 16/10/2020
 */
class ConsultaIndicadorRepository(
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun postConsultaIndicadores(tipoIndicador: String): Resource<DomainConsultadoIndicador> {
        return remoteDataSource.postConsultaIndicador(tipoIndicador)
    }
}