package com.jhonjto.domain.indicadores

data class DomainIndicadores(
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