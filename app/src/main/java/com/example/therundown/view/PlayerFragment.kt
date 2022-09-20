package com.example.therundown.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.therundown.R
import com.example.therundown.domain.Player

class PlayerFragment : DialogFragment(R.layout.player_fragment) {

    private var twId: TextView? = null
    private var twName: TextView? = null
    private var twFullName: TextView? = null
    private var twDivision: TextView? = null
    private var twCity: TextView? = null
    private var twConference: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        twId = view.findViewById(R.id.twId)
        twName = view.findViewById(R.id.twName)
        twFullName = view.findViewById(R.id.twFullName)
        twDivision = view.findViewById(R.id.twDivision)
        twCity = view.findViewById(R.id.twCity)
        twConference = view.findViewById(R.id.twConference)

        val player = arguments?.get(KEY) as Player
        twId?.text = "id ${player.team.id.toString()}"
        twName?.text = "name ${player.team.name}"
        twFullName?.text = "fullname ${player.team.fullName}"
        twDivision?.text = "division ${player.team.division}"
        twCity?.text = "city ${player.team.city}"
        twConference?.text = "Conference ${player.team.conference}"
    }

    companion object {
        const val TAG = "PlayerFragment"
        private const val KEY = "argument_key"

        fun newInstance(value: Player): PlayerFragment {
            val playerFragment = PlayerFragment()
            playerFragment.arguments = bundleOf(KEY to value)
            return playerFragment
        }
    }
}