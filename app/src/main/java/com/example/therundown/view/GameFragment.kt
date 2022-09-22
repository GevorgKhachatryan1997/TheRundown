package com.example.therundown.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.therundown.R
import com.example.therundown.domain.GameDto

class GameFragment : Fragment(R.layout.game_fragment) {

    private var tvGameId: TextView? = null
    private var tvGameDate: TextView? = null
    private var tvGameHomeTeam: TextView? = null
    private var tvGameHomeTeamScore: TextView? = null
    private var tvGamePeriod: TextView? = null
    private var tvGamePostseason: TextView? = null
    private var tvGameSeason: TextView? = null
    private var tvGameStatus: TextView? = null
    private var tvGameTime: TextView? = null
    private var tvGameVisitorTeam: TextView? = null
    private var tvGameVisitorTeamScore: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*tvGameId = view.findViewById(R.id.tvGameId)
        tvGameDate = view.findViewById(R.id.tvGameDate)
        tvGameHomeTeam = view.findViewById(R.id.tvGameHomeTeam)
        tvGameHomeTeamScore = view.findViewById(R.id.tvGameHomeTeamScore)
        tvGamePeriod = view.findViewById(R.id.tvGamePeriod)
        tvGamePostseason = view.findViewById(R.id.tvGamePostSeason)
        tvGameSeason = view.findViewById(R.id.tvGameSeason)
        tvGameStatus = view.findViewById(R.id.tvGameStatus)
        tvGameTime = view.findViewById(R.id.tvGameTime)
        tvGameVisitorTeam = view.findViewById(R.id.tvGameVisitorTeam)
        tvGameVisitorTeamScore = view.findViewById(R.id.tvGameVisitorTeamScore)
*/
        val game = arguments?.get(GAME_ARGUMENT_KEY) as GameDto
        tvGameId?.text = game.id.toString()
        tvGameDate?.text = game.date
        tvGameHomeTeam?.text = """
            |   id ${game.homeTeam?.id}
            |    name ${game.homeTeam?.name}
            |     fullname ${game.homeTeam?.fullName}
            |city ${game.homeTeam?.city}
            |division ${game.homeTeam?.division}
            |conference ${game.homeTeam?.conference}
            |abbreviation ${game.homeTeam?.abbreviation}
            """.trimMargin()
        tvGameHomeTeamScore?.text = game.homeTeamScore
        tvGamePeriod?.text = game.period
        tvGamePostseason?.text = game.postseason.toString()
        tvGameSeason?.text = game.season
        tvGameStatus?.text = game.status
        tvGameTime?.text = game.time
        tvGameVisitorTeam?.text = """
           id ${game.visitorTeam?.id}
           name ${game.visitorTeam?.name}
           fullname ${game.visitorTeam?.fullName}
           city ${game.visitorTeam?.city}
           division ${game.visitorTeam?.division}
           conference ${game.visitorTeam?.conference}
           abbreviation ${game.visitorTeam?.abbreviation} 
         """.trimIndent()
    }

    companion object {
        private const val GAME_ARGUMENT_KEY = "game_argument_key"

        fun newInstance(value: List<GameDto>) =
            PlayerFragment().apply { arguments = bundleOf(GAME_ARGUMENT_KEY to value) }
    }
}