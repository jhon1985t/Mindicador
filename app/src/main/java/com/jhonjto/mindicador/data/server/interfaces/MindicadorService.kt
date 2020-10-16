package com.jhonjto.mindicador.data.server.interfaces

import com.jhonjto.mindicador.data.server.mappers.indicadores.ServerResponseIndicadoresLista
import retrofit2.http.GET

/**
 * Created by jhon on 15/10/2020
 */
interface MindicadorService {

    @GET("/api")
    suspend fun listPopularIndicadores(): ServerResponseIndicadoresLista
}