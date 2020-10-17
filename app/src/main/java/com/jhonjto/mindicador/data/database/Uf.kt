package com.jhonjto.mindicador.data.database

import androidx.room.Entity

@Entity
data class Uf(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidadMedida: String,
    val valor: Double
)