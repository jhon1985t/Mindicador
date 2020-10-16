package com.jhonjto.domain.indicadores

data class Tpm(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidadMedida: String,
    val valor: Double
)