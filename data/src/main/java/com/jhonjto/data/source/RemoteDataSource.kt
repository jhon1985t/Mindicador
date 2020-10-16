package com.jhonjto.data.source

import com.jhonjto.domain.indicadores.DomainIndicadores

/**
 * Created by jhon on 15/10/2020
 */
interface RemoteDataSource {

    suspend fun getIndicadoresList() : DomainIndicadores
}