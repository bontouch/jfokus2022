package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.ui.geometry.Rect

data class EmployeeDetailsAnimationState(
    val selectedItemIndex: Int? = null,
    private val collapsedRect: Rect? = null,
    private val expandedRect: Rect? = null,
    private val state: State = State.Collapsed
) {
    enum class State {
        Collapsed,
        PreparingExpansion,
        Expanding,
        Expanded,
        Collapsing
    }

    val isExpanded
        get() = state == State.Expanded

    val isInOrApproachingDetailsView
        get() = state == State.Expanding || state == State.Expanded

    fun startExpansion(
        itemIndex: Int,
        collapsedRect: Rect,
        expandedRect: Rect
    ) = EmployeeDetailsAnimationState(
        selectedItemIndex = itemIndex,
        collapsedRect = collapsedRect,
        expandedRect = expandedRect,
        state = State.PreparingExpansion
    )

    fun startCollapse() =
        copy(state = State.Collapsing)

    fun targetRect(): Rect? =
        if (selectedItemIndex == null) {
            null
        } else if (
            state == State.Collapsed ||
            state == State.PreparingExpansion ||
            state == State.Collapsing
        ) {
            collapsedRect!!
        } else {
            expandedRect!!
        }

    fun next(currentRect: Rect): EmployeeDetailsAnimationState? =
        when (state) {
            State.Collapsed -> null
            State.PreparingExpansion -> copy(state = State.Expanding)
            State.Expanding -> {
                if (currentRect == expandedRect) {
                    copy(state = State.Expanded)
                } else {
                    null
                }
            }
            State.Expanded -> null
            State.Collapsing -> {
                if (currentRect == collapsedRect) {
                    copy(selectedItemIndex = null, state = State.Collapsed)
                } else {
                    null
                }
            }
        }

}