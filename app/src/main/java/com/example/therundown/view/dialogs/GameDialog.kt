package com.example.therundown.view.dialogs

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.therundown.R
import com.example.therundown.domain.models.Game

class GameDialog : DialogFragment(R.layout.game_dialog) {

    companion object {
        fun newInstance(game: Game) = GameDialog().apply {
            arguments = bundleOf(ARG_GAME to game)
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
            team name: ${game.homeTeam?.name}
            team score: ${game.homeTeamScore}
            date: ${game.date}
            period: ${game.period}
            season: ${game.season}
        """.trimIndent()
    }
}