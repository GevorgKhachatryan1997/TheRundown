package com.example.therundown.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.therundown.R
import com.example.therundown.domain.Player

class PlayerDialog : DialogFragment(R.layout.player_dialog) {

    companion object {
        fun newInstance(player: Player): PlayerDialog {
            val playerDialog = PlayerDialog()
            playerDialog.arguments = bundleOf(ARG_PLAYER to player)
            return playerDialog
        }

        private const val ARG_PLAYER = "arg player"
        val PLAYER_DIALOG_TAG = PlayerDialog::class.simpleName
    }

    private var tvPlayerInfo: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val player = requireArguments().get(ARG_PLAYER) as Player
        tvPlayerInfo = view.findViewById(R.id.tvPlayerInfo)
        tvPlayerInfo?.text = """
            player id ${player.id}
            player name ${player.firstName}
            player team id ${player.team.id}
            player team name ${player.team.name}
            player team full name ${player.team.fullName}
            player team city ${player.team.city}
            player team division ${player.team.division}
        """.trimIndent()
    }
}