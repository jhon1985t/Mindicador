package com.jhonjto.mindicador.ui.common

import android.os.Parcel
import android.os.Parcelable
import com.jhonjto.mindicador.ui.adapter.AdapterConstants
import com.jhonjto.mindicador.ui.adapter.interfaces.ViewType

/**
 * Created by jhon on 15/10/2020
 */
data class Indicadores(
    val autor: String,
    val bitcoin: List<Bitcoin>,
    val dolar: List<Dolar>,
    val dolarIntercambio: List<DolarIntercambio>,
    val euro: List<Euro>,
    val fecha: String,
    val imacec: List<Imacec>,
    val ipc: List<Ipc>,
    val ivp: List<Ivp>,
    val libraCobre: List<LibraCobre>,
    val tasaDesempleo: List<TasaDesempleo>,
    val tpm: List<Tpm>,
    val uf: List<Uf>,
    val utm: List<Utm>,
    val version: String
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.DOMAIN_INDICADORES

    companion object {
        @Suppress("unused")
        @JvmField val CREATOR: Parcelable.Creator<Indicadores> = object : Parcelable.Creator<Indicadores> {
            override fun createFromParcel(source: Parcel): Indicadores = Indicadores(source)
            override fun newArray(size: Int): Array<Indicadores?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
        source.readString()!!,
        source.createTypedArrayList(Bitcoin.CREATOR)!!,
        source.createTypedArrayList(Dolar.CREATOR)!!,
        source.createTypedArrayList(DolarIntercambio.CREATOR)!!,
        source.createTypedArrayList(Euro.CREATOR)!!,
        source.readString()!!,
        source.createTypedArrayList(Imacec.CREATOR)!!,
        source.createTypedArrayList(Ipc.CREATOR)!!,
        source.createTypedArrayList(Ivp.CREATOR)!!,
        source.createTypedArrayList(LibraCobre.CREATOR)!!,
        source.createTypedArrayList(TasaDesempleo.CREATOR)!!,
        source.createTypedArrayList(Tpm.CREATOR)!!,
        source.createTypedArrayList(Uf.CREATOR)!!,
        source.createTypedArrayList(Utm.CREATOR)!!,
        source.readString()!!
    )


    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(autor)
        dest?.writeTypedList(bitcoin)
        dest?.writeTypedList(dolar)
        dest?.writeTypedList(dolarIntercambio)
        dest?.writeTypedList(euro)
        dest?.writeString(fecha)
        dest?.writeTypedList(imacec)
        dest?.writeTypedList(ipc)
        dest?.writeTypedList(ivp)
        dest?.writeTypedList(libraCobre)
        dest?.writeTypedList(tasaDesempleo)
        dest?.writeTypedList(tpm)
        dest?.writeTypedList(uf)
        dest?.writeTypedList(utm)
        dest?.writeString(version)
    }
}

data class Bitcoin(
    val codigo: String?,
    val nombre: String?,
    val unidadMedida: String?,
    val fecha: String?,
    val valor: Double
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.BITCOIN

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Bitcoin> = object : Parcelable.Creator<Bitcoin> {
            override fun createFromParcel(source: Parcel): Bitcoin = Bitcoin(source)
            override fun newArray(size: Int): Array<Bitcoin?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readString(), source.readDouble())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(codigo)
        dest?.writeString(nombre)
        dest?.writeString(unidadMedida)
        dest?.writeString(fecha)
        dest?.writeDouble(valor)
    }
}

data class Dolar(
    val codigo: String?,
    val nombre: String?,
    val unidadMedida: String?,
    val fecha: String?,
    val valor: Double
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.DOLAR

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Dolar> = object : Parcelable.Creator<Dolar> {
            override fun createFromParcel(source: Parcel): Dolar = Dolar(source)
            override fun newArray(size: Int): Array<Dolar?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readString(), source.readDouble())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(codigo)
        dest?.writeString(nombre)
        dest?.writeString(unidadMedida)
        dest?.writeString(fecha)
        dest?.writeDouble(valor)
    }
}

data class DolarIntercambio(
    val codigo: String?,
    val nombre: String?,
    val unidadMedida: String?,
    val fecha: String?,
    val valor: Double
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.DOLAR_INTERCAMBIO

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<DolarIntercambio> = object : Parcelable.Creator<DolarIntercambio> {
            override fun createFromParcel(source: Parcel): DolarIntercambio = DolarIntercambio(source)
            override fun newArray(size: Int): Array<DolarIntercambio?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readString(), source.readDouble())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(codigo)
        dest?.writeString(nombre)
        dest?.writeString(unidadMedida)
        dest?.writeString(fecha)
        dest?.writeDouble(valor)
    }
}

data class Euro(
    val codigo: String?,
    val nombre: String?,
    val unidadMedida: String?,
    val fecha: String?,
    val valor: Double
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.EURO

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Euro> = object : Parcelable.Creator<Euro> {
            override fun createFromParcel(source: Parcel): Euro = Euro(source)
            override fun newArray(size: Int): Array<Euro?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readString(), source.readDouble())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(codigo)
        dest?.writeString(nombre)
        dest?.writeString(unidadMedida)
        dest?.writeString(fecha)
        dest?.writeDouble(valor)
    }
}

data class Imacec(
    val codigo: String?,
    val nombre: String?,
    val unidadMedida: String?,
    val fecha: String?,
    val valor: Double
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.IMACEC

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Imacec> = object : Parcelable.Creator<Imacec> {
            override fun createFromParcel(source: Parcel): Imacec = Imacec(source)
            override fun newArray(size: Int): Array<Imacec?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readString(), source.readDouble())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(codigo)
        dest?.writeString(nombre)
        dest?.writeString(unidadMedida)
        dest?.writeString(fecha)
        dest?.writeDouble(valor)
    }
}

data class Ipc(
    val codigo: String?,
    val nombre: String?,
    val unidadMedida: String?,
    val fecha: String?,
    val valor: Double
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.IPC

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Ipc> = object : Parcelable.Creator<Ipc> {
            override fun createFromParcel(source: Parcel): Ipc = Ipc(source)
            override fun newArray(size: Int): Array<Ipc?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readString(), source.readDouble())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(codigo)
        dest?.writeString(nombre)
        dest?.writeString(unidadMedida)
        dest?.writeString(fecha)
        dest?.writeDouble(valor)
    }
}

data class Ivp(
    val codigo: String?,
    val nombre: String?,
    val unidadMedida: String?,
    val fecha: String?,
    val valor: Double
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.IVP

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Ivp> = object : Parcelable.Creator<Ivp> {
            override fun createFromParcel(source: Parcel): Ivp = Ivp(source)
            override fun newArray(size: Int): Array<Ivp?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readString(), source.readDouble())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(codigo)
        dest?.writeString(nombre)
        dest?.writeString(unidadMedida)
        dest?.writeString(fecha)
        dest?.writeDouble(valor)
    }
}

data class LibraCobre(
    val codigo: String?,
    val nombre: String?,
    val unidadMedida: String?,
    val fecha: String?,
    val valor: Double
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.LIBRA_COBRE

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<LibraCobre> = object : Parcelable.Creator<LibraCobre> {
            override fun createFromParcel(source: Parcel): LibraCobre = LibraCobre(source)
            override fun newArray(size: Int): Array<LibraCobre?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readString(), source.readDouble())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(codigo)
        dest?.writeString(nombre)
        dest?.writeString(unidadMedida)
        dest?.writeString(fecha)
        dest?.writeDouble(valor)
    }
}

data class TasaDesempleo(
    val codigo: String?,
    val nombre: String?,
    val unidadMedida: String?,
    val fecha: String?,
    val valor: Double
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.TASA_DESEMPLEO

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<TasaDesempleo> = object : Parcelable.Creator<TasaDesempleo> {
            override fun createFromParcel(source: Parcel): TasaDesempleo = TasaDesempleo(source)
            override fun newArray(size: Int): Array<TasaDesempleo?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readString(), source.readDouble())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(codigo)
        dest?.writeString(nombre)
        dest?.writeString(unidadMedida)
        dest?.writeString(fecha)
        dest?.writeDouble(valor)
    }
}

data class Tpm(
    val codigo: String?,
    val nombre: String?,
    val unidadMedida: String?,
    val fecha: String?,
    val valor: Double
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.TPM

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Tpm> = object : Parcelable.Creator<Tpm> {
            override fun createFromParcel(source: Parcel): Tpm = Tpm(source)
            override fun newArray(size: Int): Array<Tpm?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readString(), source.readDouble())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(codigo)
        dest?.writeString(nombre)
        dest?.writeString(unidadMedida)
        dest?.writeString(fecha)
        dest?.writeDouble(valor)
    }
}

data class Uf(
    val codigo: String?,
    val nombre: String?,
    val unidadMedida: String?,
    val fecha: String?,
    val valor: Double
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.UF

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Uf> = object : Parcelable.Creator<Uf> {
            override fun createFromParcel(source: Parcel): Uf = Uf(source)
            override fun newArray(size: Int): Array<Uf?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readString(), source.readDouble())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(codigo)
        dest?.writeString(nombre)
        dest?.writeString(unidadMedida)
        dest?.writeString(fecha)
        dest?.writeDouble(valor)
    }
}

data class Utm(
    val codigo: String?,
    val nombre: String?,
    val unidadMedida: String?,
    val fecha: String?,
    val valor: Double
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.UTM

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Utm> = object : Parcelable.Creator<Utm> {
            override fun createFromParcel(source: Parcel): Utm = Utm(source)
            override fun newArray(size: Int): Array<Utm?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readString(), source.readDouble())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(codigo)
        dest?.writeString(nombre)
        dest?.writeString(unidadMedida)
        dest?.writeString(fecha)
        dest?.writeDouble(valor)
    }
}