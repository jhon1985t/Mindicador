package com.jhonjto.mindicador.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jhonjto.domain.indicadores.DomainIndicadores
import com.jhonjto.mindicador.R
import com.jhonjto.mindicador.ui.common.basicDiffUtil
import com.jhonjto.mindicador.ui.common.inflate
import kotlinx.android.synthetic.main.view_indicadores.view.*

/**
 * Created by jhon on 15/10/2020
 */
class IndicadoresListAdapter(private val listener: (DomainIndicadores) -> Unit) :
    RecyclerView.Adapter<IndicadoresListAdapter.ViewHolder>() {

    var indicadores: List<DomainIndicadores> by basicDiffUtil(
        emptyList(), { old, new -> old.version == new.version }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_indicadores, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = indicadores.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val indicadores = indicadores[position]
        holder.bind(indicadores)
        holder.itemView.setOnClickListener { listener(indicadores) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(indicadores: DomainIndicadores) {
            if (indicadores.bitcoin.codigo == "bitcoin") {
                itemView.nombreIndicador.text = indicadores.bitcoin.nombre
                itemView.unidadMedidaIndicador.text = indicadores.bitcoin.unidadMedida
                itemView.valorIndicador.text = indicadores.bitcoin.valor.toString()
            }
            else if (indicadores.dolar.codigo == "dolar") {
                itemView.nombreIndicador.text = indicadores.dolar.nombre
                itemView.unidadMedidaIndicador.text = indicadores.dolar.unidadMedida
                itemView.valorIndicador.text = indicadores.dolar.valor.toString()
            }
        }
    }
}