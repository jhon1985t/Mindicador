package com.jhonjto.mindicador.data.server.mappers.indicadores

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Bitcoin(
    @SerializedName("codigo")
    val codigo: String,
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("unidad_medida")
    val unidadMedida: String,
    @SerializedName("valor")
    val valor: Double
) : Parcelable