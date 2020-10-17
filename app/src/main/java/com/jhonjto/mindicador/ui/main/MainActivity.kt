package com.jhonjto.mindicador.ui.main

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jhonjto.mindicador.R
import com.jhonjto.mindicador.ui.main.MainViewModel.UiModel
import com.jhonjto.mindicador.ui.adapter.IndicadoresAdapter
import com.jhonjto.mindicador.ui.adapter.consultaIndicador.ConsultaIndicadorAdapter
import com.jhonjto.mindicador.ui.common.*
import com.jhonjto.mindicador.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class MainActivity : AppCompatActivity() {

    private val adapter by androidLazy { IndicadoresAdapter(viewModel::onBitcoinClicked,viewModel::onDolarClicked,viewModel::onDolarIntercambioClicked,viewModel::onEuroClicked,viewModel::onImacecClicked,viewModel::onIpcClicked,viewModel::onIvpClicked,viewModel::onLibraCobreClicked,viewModel::onTasaDesempleoClicked,viewModel::onTpmClicked,viewModel::onUfClicked,viewModel::onUtmClicked) }
    private val consultaAdapter by androidLazy { ConsultaIndicadorAdapter(viewModel::onConsultaClicked) }

    private val viewModel: MainViewModel by lifecycleScope.viewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cancelIcon = indicador_search.findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setOnClickListener {
            rv_consulta_indicador.visibility = View.GONE
            recycler.visibility = View.VISIBLE
        }

        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        rv_consulta_indicador.setHasFixedSize(true)
        rv_consulta_indicador.layoutManager = LinearLayoutManager(this)
        rv_consulta_indicador.adapter = consultaAdapter

        indicador_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                rv_consulta_indicador.visibility = View.VISIBLE
                recycler.visibility = View.GONE
                consultaAdapter.filter.filter(newText)
                viewModel.onConsultaRequested(newText.toString())
                return false
            }
        })

        viewModel.model.observe(this, Observer(::updateUi))
        viewModel.consult.observe(this, Observer {
            hideKeyboard()
            consultaAdapter.filterList = arrayListOf(it)
            consultaAdapter.notifyDataSetChanged()
        })
        viewModel.message.observe(this, Observer {
            showMessage("No hay resultados")
        })
    }

    private fun updateUi(model: UiModel) {

        progress.visibility = if (model is UiModel.Loading) View.VISIBLE else View.GONE

        when (model) {
            is UiModel.Content -> {
                model.domainIndicadores.bitcoin.let {
                    adapter.addBitcoin(
                        Bitcoin(
                            it.codigo,
                            it.nombre,
                            it.unidadMedida,
                            it.fecha,
                            it.valor
                        )
                    )
                }
                model.domainIndicadores.dolar.let {
                    adapter.addDolar(
                        Dolar(
                            it.codigo,
                            it.nombre,
                            it.unidadMedida,
                            it.fecha,
                            it.valor
                        )
                    )
                }
                model.domainIndicadores.dolarIntercambio.let {
                    adapter.addDolarIntercambio(
                        DolarIntercambio(
                            it.codigo,
                            it.nombre,
                            it.unidadMedida,
                            it.fecha,
                            it.valor
                        )
                    )
                }
                model.domainIndicadores.euro.let {
                    adapter.addEuro(
                        Euro(
                            it.codigo,
                            it.nombre,
                            it.unidadMedida,
                            it.fecha,
                            it.valor
                        )
                    )
                }
                model.domainIndicadores.imacec.let {
                    adapter.addImacec(
                        Imacec(
                            it.codigo,
                            it.nombre,
                            it.unidadMedida,
                            it.fecha,
                            it.valor
                        )
                    )
                }
                model.domainIndicadores.ipc.let {
                    adapter.addIpc(
                        Ipc(
                            it.codigo,
                            it.nombre,
                            it.unidadMedida,
                            it.fecha,
                            it.valor
                        )
                    )
                }
                model.domainIndicadores.ivp.let {
                    adapter.addIvp(
                        Ivp(
                            it.codigo,
                            it.nombre,
                            it.unidadMedida,
                            it.fecha,
                            it.valor
                        )
                    )
                }
                model.domainIndicadores.libraCobre.let {
                    adapter.addLibraCobre(
                        LibraCobre(
                            it.codigo,
                            it.nombre,
                            it.unidadMedida,
                            it.fecha,
                            it.valor
                        )
                    )
                }
                model.domainIndicadores.tasaDesempleo.let {
                    adapter.addTasaDesempleo(
                        TasaDesempleo(
                            it.codigo,
                            it.nombre,
                            it.unidadMedida,
                            it.fecha,
                            it.valor
                        )
                    )
                }
                model.domainIndicadores.tpm.let {
                    adapter.addTpm(
                        Tpm(
                            it.codigo,
                            it.nombre,
                            it.unidadMedida,
                            it.fecha,
                            it.valor
                        )
                    )
                }
                model.domainIndicadores.uf.let {
                    adapter.addUf(
                        Uf(
                            it.codigo,
                            it.nombre,
                            it.unidadMedida,
                            it.fecha,
                            it.valor
                        )
                    )
                }
                model.domainIndicadores.utm.let {
                    adapter.addUtm(
                        Utm(
                            it.codigo,
                            it.nombre,
                            it.unidadMedida,
                            it.fecha,
                            it.valor.toDouble()
                        )
                    )
                }
            }
            is UiModel.NavigationBitcoin -> startActivity<DetailActivity> {
                putExtra(DetailActivity.INDICADOR, model.bitcoin.codigo)
            }
            is UiModel.NavigationDolar -> startActivity<DetailActivity> {
                putExtra(DetailActivity.INDICADOR, model.dolar.codigo)
            }
            is UiModel.NavigationDolarIntercambio -> startActivity<DetailActivity> {
                putExtra(DetailActivity.INDICADOR, model.dolarIntercambio.codigo)
            }
            is UiModel.NavigationEuro -> startActivity<DetailActivity> {
                putExtra(DetailActivity.INDICADOR, model.euro.codigo)
            }
            is UiModel.NavigationImacec -> startActivity<DetailActivity> {
                putExtra(DetailActivity.INDICADOR, model.imacec.codigo)
            }
            is UiModel.NavigationIpc -> startActivity<DetailActivity> {
                putExtra(DetailActivity.INDICADOR, model.ipc.codigo)
            }
            is UiModel.NavigationIvp -> startActivity<DetailActivity> {
                putExtra(DetailActivity.INDICADOR, model.ivp.codigo)
            }
            is UiModel.NavigationLibraCobre -> startActivity<DetailActivity> {
                putExtra(DetailActivity.INDICADOR, model.libraCobre.codigo)
            }
            is UiModel.NavigationTasaDesempleo -> startActivity<DetailActivity> {
                putExtra(DetailActivity.INDICADOR, model.tasaDesempleo.codigo)
            }
            is UiModel.NavigationTpm -> startActivity<DetailActivity> {
                putExtra(DetailActivity.INDICADOR, model.tpm.codigo)
            }
            is UiModel.NavigationUf -> startActivity<DetailActivity> {
                putExtra(DetailActivity.INDICADOR, model.uf.codigo)
            }
            is UiModel.NavigationUtm -> startActivity<DetailActivity> {
                putExtra(DetailActivity.INDICADOR, model.utm.codigo)
            }
        }
    }
}