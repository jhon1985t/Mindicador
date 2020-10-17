package com.jhonjto.mindicador.data.server.interfaces

import com.jhonjto.mindicador.data.server.mappers.consultado.ServerResponseConsultaIndicador
import com.jhonjto.mindicador.data.server.mappers.indicadores.ServerResponseIndicadoresLista
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by jhon on 15/10/2020
 */
interface MindicadorService {

    @GET("/api")
    suspend fun listPopularIndicadores(): ServerResponseIndicadoresLista

    @GET("/api/{tipo_indicador}")
    suspend fun filterTipoIndicador(
        @Path("tipo_indicador") tipoIndicador: String
    ) : ServerResponseConsultaIndicador

    @GET("/api/{tipo_indicador}/{dd-mm-yyyy}")
    suspend fun detailTipoIndicador(
        @Path("tipo_indicador") tipoIndicador: String,
        @Path("dd-mm-yyyy") ultimoMes: String
    ) : ServerResponseConsultaIndicador
}