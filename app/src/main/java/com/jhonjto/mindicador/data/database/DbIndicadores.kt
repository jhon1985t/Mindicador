package com.jhonjto.mindicador.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DbIndicadores(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val autor: String,
    val bitcoin: Bitcoin,
    val dolar: Dolar,
    val dolarIntercambio: DolarIntercambio,
    val euro: Euro,
    val fecha: String,
    val imacec: Imacec,
    val ipc: Ipc,
    val ivp: Ivp,
    val libraCobre: LibraCobre,
    val tasaDesempleo: TasaDesempleo,
    val tpm: Tpm,
    val uf: Uf,
    val utm: Utm,
    val version: String
)