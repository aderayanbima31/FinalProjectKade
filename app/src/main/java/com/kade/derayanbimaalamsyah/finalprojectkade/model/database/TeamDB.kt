package com.kade.derayanbimaalamsyah.finalprojectkade.model.database


class TeamDB (val id: Long?, val teamId: String?, val teamName: String?,
              val badgeTeam: String?) {

    companion object {
        const val TABLE_TEAMS = "TABLE_TEAMS"
        const val ID: String = "ID_"
        const val TEAMS_ID: String = "TEAMS_ID"
        const val TEAMS_NAME: String = "TEAMS_NAME"
        const val BADGE_TEAM: String = "BADGE_TEAM"
    }
}