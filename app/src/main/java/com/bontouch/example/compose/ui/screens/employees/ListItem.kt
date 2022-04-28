package com.bontouch.example.compose.ui.screens.employees

import androidx.annotation.DrawableRes

sealed interface ListItem {

    object JfokusLogo : ListItem

    data class Team(
        val name: String,
        @DrawableRes val imageResource: Int
    ): ListItem

    data class Employee(
        val name: String,
        val role: String,
        val employedSeconds: Long,
        val notes: String,
        @DrawableRes val imageResource: Int
    ): ListItem

}
