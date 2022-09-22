package com.example.therundown.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.therundown.data.PlayerLoadExeption
import com.example.therundown.data.ServerExeption
import com.example.therundown.domain.GameDto
import com.example.therundown.domain.Player
import com.example.therundown.domain.Repository
import com.example.therundown.domain.convertToPlayer
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

    private val _playerList = MutableStateFlow<List<Player>>(emptyList())
    val playerList = _playerList.asStateFlow()

    private val _gameList = MutableStateFlow<List<GameDto>>(emptyList())
    val gameList = _gameList.asStateFlow()

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

    fun onPlayerClick(playerId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val playerDto = repository.getPlayer(playerId)
            val player = playerDto?.convertToPlayer() ?: return@launch
            _uiEventSharedFlow.emit(ShowPlayerInfoDialog(player), viewModelScope)
        }
    }

    interface UIEvent
    object ShowServerFailMessage : UIEvent
    object ShowPlayerLoadFailMessage : UIEvent
    object ShowGameInfoDialog: UIEvent
    class ShowPlayerInfoDialog(val player: Player) : UIEvent
}