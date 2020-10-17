package com.jhonjto.mindicador.data.server.datasources

import com.jhonjto.data.source.RemoteDataSource
import com.jhonjto.domain.consultado.DomainConsultadoIndicador
import com.jhonjto.domain.indicadores.DomainIndicadores
import com.jhonjto.mindicador.data.ResponseHandler
import com.jhonjto.mindicador.data.server.MindicadorAPI
import com.jhonjto.mindicador.data.server.mappers.consultado.toDomainPosts
import com.jhonjto.mindicador.data.server.mappers.indicadores.toDomainPosts
import com.movies.data.common.Resource

/**
 * Created by jhon on 15/10/2020
 */
class MindicadorDataSource (private val mindicadorAPI: MindicadorAPI) : RemoteDataSource {

    override suspend fun getIndicadoresList(): DomainIndicadores =
        mindicadorAPI.service
            .listPopularIndicadores()
            .toDomainPosts()

    override suspend fun getConsultaIndicador(tipoIndicador: String): Resource<DomainConsultadoIndicador> {
        return try {
            val consult = mindicadorAPI.service
                .filterTipoIndicador(tipoIndicador)
                .toDomainPosts()
            ResponseHandler().handleSuccess(consult)
        } catch (e: Exception) {
            ResponseHandler().handleException(e)
        }
    }

    override suspend fun getConsultaIndicadorMes(
        tipoIndicador: String,
        ultimoMes: String
    ): Resource<DomainConsultadoIndicador> {
        return try {
            val consult = mindicadorAPI.service
                .detailTipoIndicador(tipoIndicador, ultimoMes)
                .toDomainPosts()
            ResponseHandler().handleSuccess(consult)
        } catch (e: Exception) {
            ResponseHandler().handleException(e)
        }
    }
}