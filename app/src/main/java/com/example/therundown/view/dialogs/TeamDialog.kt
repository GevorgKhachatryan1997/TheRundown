package com.example.therundown.view.dialogs

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.therundown.R
import com.example.therundown.data.models.Team

class TeamDialog : DialogFragment(R.layout.team_dialog) {

    companion object {
        fun newInstance(team: Team) = TeamDialog().apply {
            arguments = bundleOf(ARG_TEAM to team)
        }

        private const val ARG_TEAM = "arg team"
        val TEAM_DIALOG_TAG = TeamDialog::class.simpleName
    }

    private var tvTeamInfo: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val team = requireArguments().get(ARG_TEAM) as Team
        tvTeamInfo = view.findViewById(R.id.tvTeamInfo)
        tvTeamInfo?.text = """
            id ${team.id}
            name ${team.name}
            full name ${team.fullName}
            city ${team.city}
            abbreviation ${team.abbreviation}
            conference ${team.conference}
            division ${team.division}
        """.trimIndent()
    }
}