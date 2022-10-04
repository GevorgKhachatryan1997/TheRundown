package com.example.therundown.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.therundown.R
import com.example.therundown.domain.Stat

class StatDialog : DialogFragment(R.layout.stat_dialog) {

    companion object {
        fun newInstance(stat: Stat): StatDialog {
            val statDialog = StatDialog()
            statDialog.arguments = bundleOf(ARG_STAT to stat)
            return statDialog
        }

        private const val ARG_STAT = "arg stat"
        val STAT_DIALOG_TAG = StatDialog::class.simpleName
    }

    private var tvStatInfo: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val stat = requireArguments().get(ARG_STAT) as Stat
        tvStatInfo = view.findViewById(R.id.tvStatInfo)
        tvStatInfo?.text = """
            id: ${stat.id}
            ast: ${stat.ast}
            blk: ${stat.blk}
            stl: ${stat.stl}
            dreb: ${stat.dreb}
            min: ${stat.min}
        """.trimIndent()
    }
}