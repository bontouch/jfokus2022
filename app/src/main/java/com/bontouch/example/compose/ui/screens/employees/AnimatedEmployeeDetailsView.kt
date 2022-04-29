package com.bontouch.example.compose.ui.screens.employees

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateRectAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalDensity
import com.bontouch.example.compose.config.SettingsRepository
import com.bontouch.example.compose.ui.util.asBoundsModifier
import org.threeten.bp.LocalDate

@Composable
fun AnimatedEmployeeDetailsView(
    name: String,
    role: String,
    @DrawableRes photoResource: Int,
    employmentDate: LocalDate,
    notes: String,
    onNotesTyped: (String) -> Unit,
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
        name = name,
        role = role,
        photoResource = photoResource,
        employmentDate = employmentDate,
        notes = notes,
        onNotesTyped = onNotesTyped
    )

    employeeDetailsAnimationState.next(animatingRect)?.let {
        onEmployeeAnimationStateChangeRequest(it)
    }
}
