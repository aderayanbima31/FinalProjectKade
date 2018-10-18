package com.kade.derayanbimaalamsyah.finalprojectkade.model

import com.google.gson.annotations.SerializedName


data class TeamModel(
        @SerializedName("idTeam") var teamId: String? = null,
        @SerializedName("strTeam") var teamName: String? = null,
        @SerializedName("strTeamBadge") var teamBadge: String? = null,
        @SerializedName("strStadium") var stadiumName: String? = null,
        @SerializedName("intFormedYear") var formedYear: String? = null,
        @SerializedName("strDescriptionEN") var descriptionTeam: String? = null
)