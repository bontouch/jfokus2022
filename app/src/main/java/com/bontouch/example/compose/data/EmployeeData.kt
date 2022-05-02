package com.bontouch.example.compose.data

import com.bontouch.example.compose.R
import com.bontouch.example.compose.domain.Employee
import com.bontouch.example.compose.domain.Role
import com.bontouch.example.compose.domain.Team
import com.bontouch.example.compose.domain.Teams
import org.threeten.bp.LocalDate

object EmployeeData {

    private val camille = Employee(
        name = "Camille Bossoutrot",
        role = Role.AndroidDeveloper,
        notes = "Likes Kotlin",
        startDate = LocalDate.parse("2017-10-30"),
        imageResource = R.drawable.photo_camille
    )

    private val emma = Employee(
        name = "Emma Olsson",
        role = Role.IosDeveloper,
        notes = "Likes Swift",
        startDate = LocalDate.parse("2021-01-18"),
        imageResource = R.drawable.photo_emma
    )

    private val jonas = Employee(
        name = "Jonas Hansson",
        role = Role.AndroidDeveloper,
        notes = "Likes Kotlin",
        startDate = LocalDate.parse("2018-08-20"),
        imageResource = R.drawable.photo_jonas
    )

    private val adam = Employee(
        name = "Adam Morén",
        role = Role.WebDeveloper,
        notes = "Likes JavaScript",
        startDate = LocalDate.parse("2021-08-09"),
        imageResource = R.drawable.photo_adam
    )

    private val robert = Employee(
        name = "Robert Söderbjörn",
        role = Role.AndroidDeveloper,
        notes = "❤️ Commodore C64 / Amiga",
        startDate = LocalDate.parse("2017-02-27"),
        imageResource = R.drawable.photo_robert
    )

    private val nina = Employee(
        name = "Nina Dizdarevic",
        role = Role.EventCommunicationsManager,
        notes = "Loves events!",
        startDate = LocalDate.parse("2021-11-29"),
        imageResource = R.drawable.photo_nina
    )

    private val henrik = Employee(
        name = "Henrik Björkman",
        role = Role.SocialMediaManager,
        notes = "Great photographer!",
        startDate = LocalDate.parse("2022-01-17"),
        imageResource = R.drawable.photo_henrik
    )

    val everyone = Teams(
        listOf(
            Team(
                name = "Systembolaget",
                logoResource = R.drawable.logo_systembolaget,
                employees = listOf(
                    camille,
                    emma
                )
            ),
            Team(
                name = "Swish",
                logoResource = R.drawable.logo_swish,
                employees = listOf(
                    jonas,
                    adam
                )
            ),
            Team(
                name = "PostNord",
                logoResource = R.drawable.logo_postnord,
                employees = listOf(
                    robert
                )
            ),
            Team(
                name = "Booth Support",
                logoResource = null,
                employees = listOf(
                    nina,
                    henrik
                )
            )
        )
    )

    val developers = Teams(
        listOf(
            Team(
                name = null,
                logoResource = null,
                employees = listOf(
                    robert,
                    camille,
                    jonas,
                    emma,
                    adam,
                    nina,
                    henrik
                )
            )
        )
    )
}
