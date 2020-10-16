package com.jhonjto.mindicador.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jhonjto.mindicador.R
import com.jhonjto.mindicador.ui.MainViewModel.*
import com.jhonjto.mindicador.ui.adapter.IndicadoresAdapter
import com.jhonjto.mindicador.ui.adapter.IndicadoresListAdapter
import com.jhonjto.mindicador.ui.common.Bitcoin
import com.jhonjto.mindicador.ui.common.Dolar
import com.jhonjto.mindicador.ui.common.androidLazy
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class MainActivity : AppCompatActivity() {

    private val adapter by androidLazy { IndicadoresAdapter(viewModel::onIndicadorClicked) }

    private val viewModel: MainViewModel by lifecycleScope.viewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: UiModel) {

        progress.visibility = if (model is UiModel.Loading) View.VISIBLE else View.GONE

        when (model) {
            is UiModel.Content -> {
                model.domainIndicadores.bitcoin.let {
                    adapter.addBitcoin(Bitcoin(it.codigo, it.nombre, it.fecha, it.unidadMedida, it.valor))
                }
                model.domainIndicadores.dolar.let {
                    adapter.addDolar(Dolar(it.codigo, it.nombre, it.fecha, it.unidadMedida, it.valor))
                }
            }
            /*is UiModel.Navigation -> startActivity<DetailActivity> {
                putExtra(DetailActivity.MOVIE, model.movie.id)
            }*/
        }
    }
}