package com.kade.derayanbimaalamsyah.finalprojectkade.model

import com.google.gson.annotations.SerializedName


data class TeamResponseModel(
        @SerializedName("teams")
        val team: List<TeamModel>
)