package com.jhonjto.mindicador

import com.jhonjto.data.source.RemoteDataSource
import com.jhonjto.domain.consultado.DomainConsultadoIndicador
import com.jhonjto.domain.indicadores.DomainIndicadores
import com.jhonjto.testshared.mockedConsultado
import com.jhonjto.testshared.mockedIndicador
import com.movies.data.common.Resource
import kotlinx.coroutines.Dispatchers
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun initMockedDi(vararg modules: Module) {
    startKoin {
        modules(listOf(mockedAppModule, dataModule) + modules)
    }
}

private val mockedAppModule = module {
    single(named("apiKey")) { "12456" }
    single<RemoteDataSource> { FakeRemoteDataSource() }
    single { Dispatchers.Unconfined }
}

val defaultFakeIndicadores = (
        mockedIndicador.copy("jhon")
        )

val defaultFakeConsultadoIndicador = (
        mockedConsultado.copy("jhon")
        )

class FakeRemoteDataSource : RemoteDataSource {

    var domainIndicadores = defaultFakeIndicadores

    override suspend fun getConsultaIndicador(tipoIndicador: String): Resource<DomainConsultadoIndicador> =
        Resource.success(
            defaultFakeConsultadoIndicador
        )

    override suspend fun getConsultaIndicadorMes(
        tipoIndicador: String,
        ultimoMes: String
    ): Resource<DomainConsultadoIndicador> = Resource.success(defaultFakeConsultadoIndicador)

    override suspend fun getIndicadoresList(): DomainIndicadores = domainIndicadores
}