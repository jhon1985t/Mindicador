package com.jhonjto.mindicador.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DolarIntercambio(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidadMedida: String,
    val valor: Double
)