package com.example.therundown.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.therundown.data.PlayerLoadExeption
import com.example.therundown.data.Repository
import com.example.therundown.data.ServerExeption
import com.example.therundown.domain.PlayerDto
import com.example.therundown.utils.emit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NbaViewModel : ViewModel() {

    private val _uiEventSharedFlow = MutableSharedFlow<UIEvent>()
    val uiEventSharedFlow = _uiEventSharedFlow.asSharedFlow()

    private val _playerList = MutableStateFlow<List<PlayerDto>>(emptyList())
    val playerList = _playerList.asStateFlow()

    fun loadPlayers() {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                _playerList.value = Repository.getPlayers()
            }
        } catch (e: ServerExeption) {
            _uiEventSharedFlow.emit(ShowServerFailMessage, viewModelScope)
        } catch (e: PlayerLoadExeption) {
            _uiEventSharedFlow.emit(ShowPlayerLoadFailMessage, viewModelScope)
        }
    }

    interface UIEvent

    object ShowServerFailMessage : UIEvent
    object ShowPlayerLoadFailMessage : UIEvent
}