package io.github.iplanetcn.app.fruits.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * AppViewModel
 *
 * @author john
 * @since 2025-11-03
 */
@HiltViewModel
class AppViewModel @Inject constructor(): ViewModel() {
    private val mutableStateFlow = MutableStateFlow(true)
    val isLoading = mutableStateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            delay(300)
            mutableStateFlow.value = false
        }
    }
}