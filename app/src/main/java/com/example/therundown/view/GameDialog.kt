package com.example.therundown.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.therundown.R
import com.example.therundown.domain.Game
import com.example.therundown.domain.GameDto

class GameDialog : DialogFragment(R.layout.game_dialog) {

    companion object {
        fun newInstance(game: Game): GameDialog {
            val gameDialog = GameDialog()
            gameDialog.arguments = bundleOf(ARG_GAME to game)
            return gameDialog
        }

        private const val ARG_GAME = "arg game"
        val GAME_DIALOG_TAG = GameDialog::class.simpleName
    }

    private var tvGameInfo: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val game = requireArguments().get(ARG_GAME) as Game
        tvGameInfo = view.findViewById(R.id.tvGameInfo)
        tvGameInfo?.text = """
            id: ${game.id}
            team name: ${game.homeTeam?.fullName}
            team score: ${game.homeTeamScore}
            date: ${game.date}
            period: ${game.period}
            season: ${game.season}
        """.trimIndent()
    }
}