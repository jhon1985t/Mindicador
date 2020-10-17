package com.jhonjto.mindicador.ui.adapter.consultaIndicador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.jhonjto.domain.consultado.DomainConsultadoIndicador
import com.jhonjto.mindicador.R
import kotlinx.android.synthetic.main.view_indicadores.view.*
import kotlin.collections.ArrayList

/**
 * Created by jhon on 16/10/2020
 */
class ConsultaIndicadorAdapter(
    private val listener: (DomainConsultadoIndicador) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {

    var filterList = ArrayList<DomainConsultadoIndicador>()

    lateinit var mcontext: Context

    class CountryHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val countryListView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_indicadores, parent, false)
        val sch = CountryHolder(countryListView)
        mcontext = parent.context
        return sch
    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        filterList.forEach { item ->
            holder.itemView.nombreIndicador.text = item.autor
            holder.itemView.unidadMedidaIndicador.text = item.nombre
            holder.itemView.valorIndicador.text = item.unidadMedida
            holder.itemView.containerIndicador.setOnClickListener { listener(item) }
        }
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filterList
                } else {
                    val resultList = ArrayList<DomainConsultadoIndicador>()
                    for (row in filterList) {
                        resultList.add(row)
                    }
                    filterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filterList = results?.values as ArrayList<DomainConsultadoIndicador>
                notifyDataSetChanged()
            }

        }
    }

}