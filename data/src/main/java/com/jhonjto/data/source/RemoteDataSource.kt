package com.jhonjto.data.source

import com.jhonjto.domain.consultado.DomainConsultadoIndicador
import com.jhonjto.domain.indicadores.DomainIndicadores
import com.movies.data.common.Resource

/**
 * Created by jhon on 15/10/2020
 */
interface RemoteDataSource {

    suspend fun getIndicadoresList() : DomainIndicadores

    suspend fun getConsultaIndicador(tipoIndicador: String) : Resource<DomainConsultadoIndicador>

    suspend fun getConsultaIndicadorMes(tipoIndicador: String, ultimoMes: String) : Resource<DomainConsultadoIndicador>
}