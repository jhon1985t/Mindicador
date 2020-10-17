package com.jhonjto.mindicador.ui.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.jhonjto.mindicador.R
import com.jhonjto.mindicador.ui.common.showMessage
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.parameter.parametersOf

class DetailActivity : AppCompatActivity() {
    companion object {
        const val INDICADOR = "DetailActivity:indicador"
    }

    private val viewModel: DetailViewModel by lifecycleScope.viewModel(this) {
        parametersOf(intent.getStringExtra(INDICADOR))
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        viewModel.model.observe(this, Observer(::updateUi))
        viewModel.message.observe(this, Observer {
            showMessage(it)
        })
    }

    private fun updateUi(model: DetailViewModel.UiModel) = with(model.domainConsultadoIndicador) {
        serieDetailInfo.setMovie(this)
    }
}