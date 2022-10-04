package com.example.therundown.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.therundown.data.PlayerLoadExeption
import com.example.therundown.data.ServerExeption
import com.example.therundown.data.models.Game
import com.example.therundown.data.models.Player
import com.example.therundown.data.models.Stat
import com.example.therundown.data.models.Team
import com.example.therundown.domain.*
import com.example.therundown.utils.emit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NbaViewModel(private val repository: Repository) : ViewModel() {

    private val _uiEventSharedFlow = MutableSharedFlow<UIEvent>()
    val uiEventSharedFlow = _uiEventSharedFlow.asSharedFlow()

    private val _playerList = MutableStateFlow<List<Player?>>(emptyList())
    val playerList = _playerList.asStateFlow()

    private val _gameList = MutableStateFlow<List<Game?>>(emptyList())
    val gameList = _gameList.asStateFlow()

    private val _teamList = MutableStateFlow<List<Team?>>(emptyList())
    val teamList = _teamList.asStateFlow()

    private val _statList = MutableStateFlow<List<Stat?>>(emptyList())
    val statList = _statList.asStateFlow()

    fun loadPlayers() {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                _playerList.value = repository.getPlayers()
            }
        } catch (e: ServerExeption) {
            _uiEventSharedFlow.emit(ShowServerFailMessage, viewModelScope)
        } catch (e: PlayerLoadExeption) {
            _uiEventSharedFlow.emit(ShowPlayerLoadFailMessage, viewModelScope)
        }
    }

    fun loadGames() {
        viewModelScope.launch(Dispatchers.IO) {
            _gameList.value = repository.getGames()
        }
    }

    fun loadTeams() {
        viewModelScope.launch(Dispatchers.IO) {
            _teamList.value = repository.getTeams()
        }
    }

    fun loadStats() {
        viewModelScope.launch(Dispatchers.IO) {
            _statList.value = repository.getStats()
        }
    }

    fun onPlayerClick(playerId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val player = repository.getPlayer(playerId) ?: return@launch
            _uiEventSharedFlow.emit(ShowPlayerInfoDialog(player), viewModelScope)
        }
    }

    fun onGameClick(gameId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val game = repository.getGame(gameId) ?: return@launch
            _uiEventSharedFlow.emit(ShowGameInfoDialog(game), viewModelScope)
        }
    }

    fun onTeamClick(teamId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val team = repository.getTeam(teamId) ?: return@launch
            _uiEventSharedFlow.emit(ShowTeamInfoDialog(team), viewModelScope)
        }
    }

    fun onStatClick(selectedStat: Stat) {
        statList.value
            .find { stat -> selectedStat == stat }
            ?.let { _uiEventSharedFlow.emit(ShowStatInfoDialog(it), viewModelScope) }
    }

    interface UIEvent
    object ShowServerFailMessage : UIEvent
    object ShowPlayerLoadFailMessage : UIEvent
    class ShowGameInfoDialog(val game: Game) : UIEvent
    class ShowPlayerInfoDialog(val player: Player) : UIEvent
    class ShowTeamInfoDialog(val team: Team) : UIEvent
    class ShowStatInfoDialog(val stat: Stat) : UIEvent
}