package com.jhonjto.mindicador.data.server.mappers.consultado

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ServerResponseConsultaIndicador(
    @SerializedName("autor")
    val autor: String? = null,
    @SerializedName("codigo")
    val codigo: String? = null,
    @SerializedName("nombre")
    val nombre: String? = null,
    @SerializedName("serie")
    val serie: List<Serie>? = null,
    @SerializedName("unidad_medida")
    val unidadMedida: String? = null,
    @SerializedName("version")
    val version: String? = null
) : Parcelable