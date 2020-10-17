package com.jhonjto.data.repository

import com.jhonjto.data.source.RemoteDataSource
import com.jhonjto.domain.consultado.DomainConsultadoIndicador
import com.movies.data.common.Resource

/**
 * Created by jhon on 17/10/2020
 */
class ConsultaIndicadorMesRepository(
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getConsultaIndicadoresMes(tipoIndicador: String, ultimoMes: String): Resource<DomainConsultadoIndicador> {
        return remoteDataSource.getConsultaIndicadorMes(tipoIndicador, ultimoMes)
    }
}