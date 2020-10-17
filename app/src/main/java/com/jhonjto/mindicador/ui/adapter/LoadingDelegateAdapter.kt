package com.jhonjto.mindicador.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jhonjto.mindicador.R
import com.jhonjto.mindicador.ui.adapter.interfaces.ViewType
import com.jhonjto.mindicador.ui.adapter.interfaces.ViewTypeDelegateAdapter
import com.jhonjto.mindicador.ui.common.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.indicadores_item_loading))
}