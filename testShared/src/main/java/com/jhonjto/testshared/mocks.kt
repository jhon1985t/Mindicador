package com.jhonjto.testshared

import com.jhonjto.domain.consultado.DomainConsultadoIndicador
import com.jhonjto.domain.consultado.Serie
import com.jhonjto.domain.indicadores.*

val mockedIndicador = DomainIndicadores(
    "mindicador.cl",
    Bitcoin(
        "bitcoin",
        "20--11-2018",
        "bitcoin",
        "dolar",
        2.000
    ),
    Dolar(
        "bitcoin",
        "20--11-2018",
        "bitcoin",
        "dolar",
        2.000
    ),
    DolarIntercambio(
        "bitcoin",
        "20--11-2018",
        "bitcoin",
        "dolar",
        2.000
    ),
    Euro(
        "bitcoin",
        "20--11-2018",
        "bitcoin",
        "dolar",
        2.000
    ),
    "17-10-2020",
    Imacec(
        "bitcoin",
        "20--11-2018",
        "bitcoin",
        "dolar",
        2.000
    ),
    Ipc(
        "bitcoin",
        "20--11-2018",
        "bitcoin",
        "dolar",
        2.000
    ),
    Ivp(
        "bitcoin",
        "20--11-2018",
        "bitcoin",
        "dolar",
        2.000
    ),
    LibraCobre(
        "bitcoin",
        "20--11-2018",
        "bitcoin",
        "dolar",
        2.000
    ),
    TasaDesempleo(
        "bitcoin",
        "20--11-2018",
        "bitcoin",
        "dolar",
        2.000
    ),
    Tpm(
        "bitcoin",
        "20--11-2018",
        "bitcoin",
        "dolar",
        2.000
    ),
    Uf(
        "bitcoin",
        "20--11-2018",
        "bitcoin",
        "dolar",
        2.000
    ),
    Utm(
        "bitcoin",
        "20--11-2018",
        "bitcoin",
        "dolar",
        20
    ),
    "1.0"
)

val mockedBitcoin = Bitcoin(
    "bitcoin",
    "20--11-2018",
    "bitcoin",
    "dolar",
    2.000
)

val mockedConsultado = DomainConsultadoIndicador(
    "jhon",
    "bitcoin",
    "Bitcoin",
    listOf(),
    "dolar",
    "1.0"
)