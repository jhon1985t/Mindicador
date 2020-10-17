package com.jhonjto.mindicador.data.server.mappers.consultado

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by jhon on 16/10/2020
 */
@Parcelize
data class Serie(
    @SerializedName("fecha")
    val fecha: String? = null,
    @SerializedName("valor")
    val valor: String? = null
) : Parcelable