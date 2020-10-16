package com.jhonjto.mindicador.data.server.datasources

import com.jhonjto.data.source.RemoteDataSource
import com.jhonjto.domain.indicadores.DomainIndicadores
import com.jhonjto.mindicador.data.server.MindicadorAPI
import com.jhonjto.mindicador.data.server.mappers.indicadores.toDomainPosts

/**
 * Created by jhon on 15/10/2020
 */
class MindicadorDataSource (private val mindicadorAPI: MindicadorAPI) : RemoteDataSource {

    override suspend fun getIndicadoresList(): DomainIndicadores =
        mindicadorAPI.service
            .listPopularIndicadores()
            .toDomainPosts()
}