package com.jhonjto.mindicador.data.server.mappers.indicadores

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ServerResponseIndicadoresLista(
    @SerializedName("autor")
    val autor: String,
    @SerializedName("bitcoin")
    val bitcoin: Bitcoin,
    @SerializedName("dolar")
    val dolar: Dolar,
    @SerializedName("dolar_intercambio")
    val dolarIntercambio: DolarIntercambio,
    @SerializedName("euro")
    val euro: Euro,
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("imacec")
    val imacec: Imacec,
    @SerializedName("ipc")
    val ipc: Ipc,
    @SerializedName("ivp")
    val ivp: Ivp,
    @SerializedName("libra_cobre")
    val libraCobre: LibraCobre,
    @SerializedName("tasa_desempleo")
    val tasaDesempleo: TasaDesempleo,
    @SerializedName("tpm")
    val tpm: Tpm,
    @SerializedName("uf")
    val uf: Uf,
    @SerializedName("utm")
    val utm: Utm,
    @SerializedName("version")
    val version: String
) : Parcelable