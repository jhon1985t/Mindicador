package com.jhonjto.data.repository

import com.jhonjto.data.source.RemoteDataSource
import com.jhonjto.domain.indicadores.DomainIndicadores

/**
 * Created by jhon on 15/10/2020
 */
class IndicadoresListRepository(
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getIndicadoresList(): DomainIndicadores {

        return remoteDataSource.getIndicadoresList()
    }
}