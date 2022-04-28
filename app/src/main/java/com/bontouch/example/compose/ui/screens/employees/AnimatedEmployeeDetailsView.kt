package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.animation.core.animateRectAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalDensity
import com.bontouch.example.compose.config.SettingsRepository
import com.bontouch.example.compose.ui.util.asBoundsModifier

@Composable
fun AnimatedEmployeeDetailsView(
    employeeItem: ListItem.Employee,
    onNotesChanged: (String) -> Unit,
    employeeDetailsAnimationState: EmployeeDetailsAnimationState,
    onEmployeeAnimationStateChangeRequest: (EmployeeDetailsAnimationState) -> Unit
) {
    val animatingRect by animateRectAsState(
        targetValue = employeeDetailsAnimationState.targetRect()!!,
        animationSpec = tween(SettingsRepository.animationTimeMillis)
    )

    val animatingBoundsModifier = animatingRect.asBoundsModifier(LocalDensity.current)

    EmployeeDetailsView(
        modifier = animatingBoundsModifier,
        employeeItem = employeeItem,
        onNotesChanged = onNotesChanged
    )

    employeeDetailsAnimationState.next(animatingRect)?.let {
        onEmployeeAnimationStateChangeRequest(it)
    }
}
