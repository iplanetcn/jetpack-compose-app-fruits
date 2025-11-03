package io.github.iplanetcn.app.fruits.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

/**
 * AppViewModel
 *
 * @author john
 * @since 2025-11-03
 */
@HiltViewModel
class AppViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    // Splash/Routine
    // Onboarding
    // Main
    // Detail
    // Setting
}