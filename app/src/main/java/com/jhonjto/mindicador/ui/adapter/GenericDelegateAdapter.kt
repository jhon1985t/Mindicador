package com.jhonjto.mindicador.ui.adapter

import android.content.Intent
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.jhonjto.mindicador.R
import com.jhonjto.mindicador.ui.adapter.interfaces.ViewType
import com.jhonjto.mindicador.ui.adapter.interfaces.ViewTypeDelegateAdapter
import com.jhonjto.mindicador.ui.common.*
import kotlinx.android.synthetic.main.view_indicadores.view.*


/**
 * Created by jhon on 17/02/2020
 */
class GenericDelegateAdapter(
    private val listenerBitcoin: (Bitcoin) -> Unit,
    private val listenerDolar: (Dolar) -> Unit,
    private val listenerDolarIntercambio: (DolarIntercambio) -> Unit,
    private val listenerEuro: (Euro) -> Unit,
    private val listenerImacec: (Imacec) -> Unit,
    private val listenerIpc: (Ipc) -> Unit,
    private val listenerIvp: (Ivp) -> Unit,
    private val listenerLibraCobre: (LibraCobre) -> Unit,
    private val listenerTasaDesempleo: (TasaDesempleo) -> Unit,
    private val listenerTpm: (Tpm) -> Unit,
    private val listenerUf: (Uf) -> Unit,
    private val listenerUtm: (Utm) -> Unit
) : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            AdapterConstants.BITCOIN -> BitCoinViewHolder(parent)
            AdapterConstants.DOLAR -> DolarViewHolder(parent)
            AdapterConstants.DOLAR_INTERCAMBIO -> DolarIntercambioViewHolder(parent)
            AdapterConstants.EURO -> EuroViewHolder(parent)
            AdapterConstants.IMACEC -> ImacecViewHolder(parent)
            AdapterConstants.IPC -> IpcViewHolder(parent)
            AdapterConstants.IVP -> IvpViewHolder(parent)
            AdapterConstants.LIBRA_COBRE -> LibraCobreViewHolder(parent)
            AdapterConstants.TASA_DESEMPLEO -> TasaDesempleoViewHolder(parent)
            AdapterConstants.TPM -> TpmViewHolder(parent)
            AdapterConstants.UF -> UfViewHolder(parent)
            AdapterConstants.UTM -> UtmViewHolder(parent)
            else -> BitCoinViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        when (holder.itemViewType) {
            AdapterConstants.BITCOIN -> {
                holder as BitCoinViewHolder
                holder.bind(item as Bitcoin)
            }
            AdapterConstants.DOLAR -> {
                holder as DolarViewHolder
                holder.bind(item as Dolar)
            }
            AdapterConstants.DOLAR_INTERCAMBIO -> {
                holder as DolarIntercambioViewHolder
                holder.bind(item as DolarIntercambio)
            }
            AdapterConstants.EURO -> {
                holder as EuroViewHolder
                holder.bind(item as Euro)
            }
            AdapterConstants.IMACEC -> {
                holder as ImacecViewHolder
                holder.bind(item as Imacec)
            }
            AdapterConstants.IPC -> {
                holder as IpcViewHolder
                holder.bind(item as Ipc)
            }
            AdapterConstants.IVP -> {
                holder as IvpViewHolder
                holder.bind(item as Ivp)
            }
            AdapterConstants.LIBRA_COBRE -> {
                holder as LibraCobreViewHolder
                holder.bind(item as LibraCobre)
            }
            AdapterConstants.TASA_DESEMPLEO -> {
                holder as TasaDesempleoViewHolder
                holder.bind(item as TasaDesempleo)
            }
            AdapterConstants.TPM -> {
                holder as TpmViewHolder
                holder.bind(item as Tpm)
            }
            AdapterConstants.UF -> {
                holder as UfViewHolder
                holder.bind(item as Uf)
            }
            AdapterConstants.UTM -> {
                holder as UtmViewHolder
                holder.bind(item as Utm)
            }
        }
    }

    inner class BitCoinViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.view_indicadores)
    ) {

        fun bind(item: Bitcoin) {
            itemView.nombreIndicador.text = item.nombre
            itemView.unidadMedidaIndicador.text = item.unidadMedida
            itemView.valorIndicador.text = item.valor.toString()
            itemView.containerIndicador.setOnClickListener { listenerBitcoin(item) }
            itemView.compartirNombre.setOnClickListener {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                sharingIntent.putExtra(Intent.EXTRA_TEXT, item.nombre + " " + item.valor)
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, item.valor  +  item.valor)
                it.context.startActivity(Intent.createChooser(sharingIntent, "Share using"))
            }
            itemView.compartirValor.setOnClickListener {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                sharingIntent.putExtra(Intent.EXTRA_TEXT, item.nombre + " " + item.valor)
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, item.valor  +  item.valor)
                it.context.startActivity(Intent.createChooser(sharingIntent, "Share using"))
            }
        }
    }

    inner class DolarViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.view_indicadores)
    ) {

        fun bind(item: Dolar) {
            itemView.nombreIndicador.text = item.nombre
            itemView.unidadMedidaIndicador.text = item.unidadMedida
            itemView.valorIndicador.text = item.valor.toString()
            itemView.containerIndicador.setOnClickListener { listenerDolar(item) }
        }
    }

    inner class DolarIntercambioViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.view_indicadores)
    ) {

        fun bind(item: DolarIntercambio) {
            itemView.nombreIndicador.text = item.nombre
            itemView.unidadMedidaIndicador.text = item.unidadMedida
            itemView.valorIndicador.text = item.valor.toString()
            itemView.containerIndicador.setOnClickListener { listenerDolarIntercambio(item) }
        }
    }

    inner class EuroViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.view_indicadores)
    ) {

        fun bind(item: Euro) {
            itemView.nombreIndicador.text = item.nombre
            itemView.unidadMedidaIndicador.text = item.unidadMedida
            itemView.valorIndicador.text = item.valor.toString()
            itemView.containerIndicador.setOnClickListener { listenerEuro(item) }
        }
    }

    inner class ImacecViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.view_indicadores)
    ) {

        fun bind(item: Imacec) {
            itemView.nombreIndicador.text = item.nombre
            itemView.unidadMedidaIndicador.text = item.unidadMedida
            itemView.valorIndicador.text = item.valor.toString()
            itemView.containerIndicador.setOnClickListener { listenerImacec(item) }
        }
    }

    inner class IpcViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.view_indicadores)
    ) {

        fun bind(item: Ipc) {
            itemView.nombreIndicador.text = item.nombre
            itemView.unidadMedidaIndicador.text = item.unidadMedida
            itemView.valorIndicador.text = item.valor.toString()
            itemView.containerIndicador.setOnClickListener { listenerIpc(item) }
        }
    }

    inner class IvpViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.view_indicadores)
    ) {

        fun bind(item: Ivp) {
            itemView.nombreIndicador.text = item.nombre
            itemView.unidadMedidaIndicador.text = item.unidadMedida
            itemView.valorIndicador.text = item.valor.toString()
            itemView.containerIndicador.setOnClickListener { listenerIvp(item) }
        }
    }

    inner class LibraCobreViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.view_indicadores)
    ) {

        fun bind(item: LibraCobre) {
            itemView.nombreIndicador.text = item.nombre
            itemView.unidadMedidaIndicador.text = item.unidadMedida
            itemView.valorIndicador.text = item.valor.toString()
            itemView.containerIndicador.setOnClickListener { listenerLibraCobre(item) }
        }
    }

    inner class TasaDesempleoViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.view_indicadores)
    ) {

        fun bind(item: TasaDesempleo) {
            itemView.nombreIndicador.text = item.nombre
            itemView.unidadMedidaIndicador.text = item.unidadMedida
            itemView.valorIndicador.text = item.valor.toString()
            itemView.containerIndicador.setOnClickListener { listenerTasaDesempleo(item) }
        }
    }

    inner class TpmViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.view_indicadores)
    ) {

        fun bind(item: Tpm) {
            itemView.nombreIndicador.text = item.nombre
            itemView.unidadMedidaIndicador.text = item.unidadMedida
            itemView.valorIndicador.text = item.valor.toString()
            itemView.containerIndicador.setOnClickListener { listenerTpm(item) }
        }
    }

    inner class UfViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.view_indicadores)
    ) {

        fun bind(item: Uf) {
            itemView.nombreIndicador.text = item.nombre
            itemView.unidadMedidaIndicador.text = item.unidadMedida
            itemView.valorIndicador.text = item.valor.toString()
            itemView.containerIndicador.setOnClickListener { listenerUf(item) }
        }
    }

    inner class UtmViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.view_indicadores)
    ) {

        fun bind(item: Utm) {
            itemView.nombreIndicador.text = item.nombre
            itemView.unidadMedidaIndicador.text = item.unidadMedida
            itemView.valorIndicador.text = item.valor.toString()
            itemView.containerIndicador.setOnClickListener { listenerUtm(item) }
        }
    }
}