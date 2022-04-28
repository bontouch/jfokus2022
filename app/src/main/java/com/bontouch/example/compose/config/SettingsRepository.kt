package com.bontouch.example.compose.config

import com.bontouch.example.compose.ui.util.update
import kotlinx.coroutines.flow.MutableStateFlow

object SettingsRepository {
    private const val ANIMATION_TIME_MILLIS_FAST = 300
    private const val ANIMATION_TIME_MILLIS_SLOW = 7000

    private val settingsPanelVisibleStateFlow = MutableStateFlow<Boolean>(false)
    private val slowAnimationsStateFlow = MutableStateFlow<Boolean>(false)
    private val manyItemsStateFlow = MutableStateFlow<Boolean>(false)

    val settingsPanelVisibleFlow
        get() = settingsPanelVisibleStateFlow

    val slowAnimationFlow
        get() = slowAnimationsStateFlow

    val manyItemsFlow
        get() = manyItemsStateFlow

    fun toggleSettingsPanelVisible() {
        settingsPanelVisibleStateFlow.update { !it }
    }

    fun setSlowAnimations(slowAnimations: Boolean) {
        slowAnimationsStateFlow.update { slowAnimations }
    }

    fun setManyItems(manyItems: Boolean) {
        manyItemsStateFlow.update { manyItems }
    }

    val animationTimeMillis
        get() = if (slowAnimationsStateFlow.value) {
            ANIMATION_TIME_MILLIS_SLOW
        } else {
            ANIMATION_TIME_MILLIS_FAST
        }

}