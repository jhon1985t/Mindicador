package com.jhonjto.mindicador.ui.adapter

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import com.jhonjto.mindicador.ui.adapter.interfaces.ViewType
import com.jhonjto.mindicador.ui.adapter.interfaces.ViewTypeDelegateAdapter
import com.jhonjto.mindicador.ui.common.*
import java.util.ArrayList

/**
 * Created by jhon on 15/10/2020
 */
class IndicadoresAdapter(
    listener: (Bitcoin) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(AdapterConstants.BITCOIN, GenericDelegateAdapter(listener))
        delegateAdapters.put(AdapterConstants.DOLAR, GenericDelegateAdapter(listener))
        delegateAdapters.put(AdapterConstants.DOLAR_INTERCAMBIO, GenericDelegateAdapter(listener))
        delegateAdapters.put(AdapterConstants.EURO, GenericDelegateAdapter(listener))
        delegateAdapters.put(AdapterConstants.IMACEC, GenericDelegateAdapter(listener))
        delegateAdapters.put(AdapterConstants.IPC, GenericDelegateAdapter(listener))
        delegateAdapters.put(AdapterConstants.IVP, GenericDelegateAdapter(listener))
        delegateAdapters.put(AdapterConstants.LIBRA_COBRE, GenericDelegateAdapter(listener))
        delegateAdapters.put(AdapterConstants.TASA_DESEMPLEO, GenericDelegateAdapter(listener))
        delegateAdapters.put(AdapterConstants.TPM, GenericDelegateAdapter(listener))
        delegateAdapters.put(AdapterConstants.UF, GenericDelegateAdapter(listener))
        delegateAdapters.put(AdapterConstants.UTM, GenericDelegateAdapter(listener))
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        items = ArrayList()
        items.add(loadingItem)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        delegateAdapters.get(viewType)!!.onCreateViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position))!!.onBindViewHolder(holder, items[position])
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()

    fun addBitcoin(bitcoin: Bitcoin) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        items.addAll(listOf(bitcoin))
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

    fun addDolar(dolar: Dolar) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(listOf(dolar))
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

    fun addDolarIntercambio(dolarIntercambio: DolarIntercambio) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(listOf(dolarIntercambio))
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

    fun addEuro(euro: Euro) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(listOf(euro))
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

    fun addImacec(imacec: Imacec) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(listOf(imacec))
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

    fun addIpc(ipc: Ipc) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(listOf(ipc))
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

    fun addIvp(ivp: Ivp) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(listOf(ivp))
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

    fun addLibraCobre(libraCobre: LibraCobre) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(listOf(libraCobre))
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

    fun addTasaDesempleo(tasaDesempleo: TasaDesempleo) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(listOf(tasaDesempleo))
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

    fun addTpm(tpm: Tpm) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(listOf(tpm))
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

    fun addUf(uf: Uf) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(listOf(uf))
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

    fun addUtm(utm: Utm) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(listOf(utm))
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }
}