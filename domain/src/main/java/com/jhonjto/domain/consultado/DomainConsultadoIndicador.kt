package com.jhonjto.domain.consultado

data class DomainConsultadoIndicador(
    val autor: String,
    val codigo: String,
    val nombre: String,
    val serie: List<Serie>,
    val unidadMedida: String,
    val version: String
)