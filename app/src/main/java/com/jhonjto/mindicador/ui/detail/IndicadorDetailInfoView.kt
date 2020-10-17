package com.jhonjto.mindicador.ui.detail

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.jhonjto.domain.consultado.DomainConsultadoIndicador

class IndicadorDetailInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    fun setMovie(domainConsultadoIndicador: DomainConsultadoIndicador) = with(domainConsultadoIndicador) {
        text = buildSpannedString {

            bold { append("Código: ") }
            appendln(codigo)

            bold { append("Nombre: ") }
            appendln(nombre)

            bold { append("Serie: ") }
            appendln(serie.toString())
        }
    }
}