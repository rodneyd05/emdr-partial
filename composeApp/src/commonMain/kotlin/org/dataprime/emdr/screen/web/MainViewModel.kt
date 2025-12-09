package org.dataprime.emdr.screen.web

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {

    private val _lightsOn = MutableStateFlow(false)
    val lightsOn = _lightsOn.asStateFlow()

    fun toggleLightsOn(toggled: Boolean) {
        _lightsOn.value = toggled
    }
}