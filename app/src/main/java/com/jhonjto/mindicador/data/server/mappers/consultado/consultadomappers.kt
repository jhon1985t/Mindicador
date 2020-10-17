package com.jhonjto.mindicador.data.server.mappers.consultado

import com.jhonjto.domain.consultado.DomainConsultadoIndicador
import com.jhonjto.domain.consultado.Serie

/**
 * Created by jhon on 16/10/2020
 */
fun ServerResponseConsultaIndicador.toDomainPosts(): DomainConsultadoIndicador {
    val listSerie = ArrayList<Serie>()
    listSerie.map {
        listSerie.add(Serie(it.fecha, it.valor))
    }

    return DomainConsultadoIndicador(
        autor!!,
        codigo!!,
        nombre!!,
        listSerie,
        unidadMedida!!,
        version!!
    )
}