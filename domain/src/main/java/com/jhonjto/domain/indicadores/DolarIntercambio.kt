package com.jhonjto.domain.indicadores

data class DolarIntercambio(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidadMedida: String,
    val valor: Double
)