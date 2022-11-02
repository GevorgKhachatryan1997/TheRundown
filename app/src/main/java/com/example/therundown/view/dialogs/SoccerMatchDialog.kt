package com.example.therundown.view.dialogs

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.therundown.R
import com.example.therundown.domain.models.SoccerMatch

class SoccerMatchDialog : DialogFragment(R.layout.soccer_match_dialog) {

    companion object {
        fun newInstance(soccerMatch: SoccerMatch) = SoccerMatchDialog().apply {
            arguments = bundleOf(ARG_SOCCER to soccerMatch)
        }

        private const val ARG_SOCCER = "arg soccer"
        val SOCCER_DIALOG_TAG = SoccerMatchDialog::class.simpleName
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val soccerMatch = requireArguments().get(ARG_SOCCER) as SoccerMatch
    }
}