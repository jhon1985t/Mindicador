package com.jhonjto.mindicador.data.server.mappers.indicadores

import com.jhonjto.domain.indicadores.Bitcoin
import com.jhonjto.domain.indicadores.Dolar
import com.jhonjto.domain.indicadores.DolarIntercambio
import com.jhonjto.domain.indicadores.DomainIndicadores
import com.jhonjto.domain.indicadores.Euro
import com.jhonjto.domain.indicadores.Imacec
import com.jhonjto.domain.indicadores.Ipc
import com.jhonjto.domain.indicadores.Ivp
import com.jhonjto.domain.indicadores.LibraCobre
import com.jhonjto.domain.indicadores.TasaDesempleo
import com.jhonjto.domain.indicadores.Tpm
import com.jhonjto.domain.indicadores.Uf
import com.jhonjto.domain.indicadores.Utm

/**
 * Created by jhon on 15/10/2020
 */
fun ServerResponseIndicadoresLista.toDomainPosts(): DomainIndicadores {
    var bitcoin: Bitcoin?
    var dolar: Dolar?
    var dolarIntercambio: DolarIntercambio?
    var euro: Euro?
    var imacec: Imacec?
    var ipc: Ipc?
    var ivp: Ivp?
    var libraCobre: LibraCobre?
    var tasaDesempleo: TasaDesempleo?
    var tpm: Tpm?
    var uf: Uf?
    var utm: Utm?

    this.bitcoin.let { result ->
        bitcoin = Bitcoin(
            result.codigo,
            result.fecha,
            result.nombre,
            result.unidadMedida,
            result.valor
        )
    }

    this.dolar.let { result ->
        dolar = Dolar(
            result.codigo,
            result.fecha,
            result.nombre,
            result.unidadMedida,
            result.valor
        )
    }

    this.dolarIntercambio.let { result ->
        dolarIntercambio = DolarIntercambio(
            result.codigo,
            result.fecha,
            result.nombre,
            result.unidadMedida,
            result.valor
        )
    }

    this.euro.let { result ->
        euro = Euro(
            result.codigo,
            result.fecha,
            result.nombre,
            result.unidadMedida,
            result.valor
        )
    }

    this.imacec.let { result ->
        imacec = Imacec(
            result.codigo,
            result.fecha,
            result.nombre,
            result.unidadMedida,
            result.valor
        )
    }

    this.ipc.let { result ->
        ipc = Ipc(
            result.codigo,
            result.fecha,
            result.nombre,
            result.unidadMedida,
            result.valor
        )
    }

    this.ivp.let { result ->
        ivp = Ivp(
            result.codigo,
            result.fecha,
            result.nombre,
            result.unidadMedida,
            result.valor
        )
    }

    this.libraCobre.let { result ->
        libraCobre = LibraCobre(
            result.codigo,
            result.fecha,
            result.nombre,
            result.unidadMedida,
            result.valor
        )
    }

    this.tasaDesempleo.let { result ->
        tasaDesempleo = TasaDesempleo(
            result.codigo,
            result.fecha,
            result.nombre,
            result.unidadMedida,
            result.valor
        )
    }

    this.tpm.let { result ->
        tpm = Tpm(
            result.codigo,
            result.fecha,
            result.nombre,
            result.unidadMedida,
            result.valor
        )
    }

    this.uf.let { result ->
        uf = Uf(
            result.codigo,
            result.fecha,
            result.nombre,
            result.unidadMedida,
            result.valor
        )
    }

    this.utm.let { result ->
        utm = Utm(
            result.codigo,
            result.fecha,
            result.nombre,
            result.unidadMedida,
            result.valor.toInt()
        )
    }

    return DomainIndicadores(
        autor,
        bitcoin!!,
        dolar!!,
        dolarIntercambio!!,
        euro!!,
        fecha,
        imacec!!,
        ipc!!,
        ivp!!,
        libraCobre!!,
        tasaDesempleo!!,
        tpm!!,
        uf!!,
        utm!!,
        version
    )
}