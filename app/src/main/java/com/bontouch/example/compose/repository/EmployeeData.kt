package com.bontouch.example.compose.repository

import com.bontouch.example.compose.R
import com.bontouch.example.compose.domain.Employee
import com.bontouch.example.compose.domain.Role
import com.bontouch.example.compose.domain.Team
import com.bontouch.example.compose.domain.Teams
import org.threeten.bp.LocalDate

object EmployeeData {

    val TEAMS = Teams(
        listOf(

            Team(
                name = "Systembolaget",
                imageResource = R.drawable.logo_systembolaget,
                employees = listOf(
                    Employee(
                        name = "Camille Bossoutrot",
                        role = Role.AndroidDeveloper,
                        notes = "Likes Kotlin",
                        startDate = LocalDate.parse("2017-10-30"),
                        imageResource = R.drawable.photo_camille
                    ),
                    Employee(
                        name = "Emma Olsson",
                        role = Role.IosDeveloper,
                        notes = "Likes Swift",
                        startDate = LocalDate.parse("2021-01-18"),
                        imageResource = R.drawable.photo_emma
                    )
                )
            ),

            Team(
                name = "Swish",
                imageResource = R.drawable.logo_swish,
                employees = listOf(
                    Employee(
                        name = "Jonas Hansson",
                        role = Role.AndroidDeveloper,
                        notes = "Likes Kotlin",
                        startDate = LocalDate.parse("2018-08-20"),
                        imageResource = R.drawable.photo_jonas
                    ),
                    Employee(
                        name = "Adam Morén",
                        role = Role.WebDeveloper,
                        notes = "Likes JavaScript",
                        startDate = LocalDate.parse("2021-08-09"),
                        imageResource = R.drawable.photo_adam
                    )
                )
            ),

            Team(
                name = "PostNord",
                imageResource = R.drawable.logo_postnord,
                employees = listOf(
                    Employee(
                        name = "Robert Söderbjörn",
                        role = Role.AndroidDeveloper,
                        notes = "❤️ Commodore C64 / Amiga",
                        startDate = LocalDate.parse("2017-02-27"),
                        imageResource = R.drawable.photo_robert
                    )
                )
            )
        )
    )
}
