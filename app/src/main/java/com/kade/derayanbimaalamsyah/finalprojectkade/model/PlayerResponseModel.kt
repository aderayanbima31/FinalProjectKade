package com.kade.derayanbimaalamsyah.finalprojectkade.model

import com.google.gson.annotations.SerializedName


data class PlayerResponseModel (
        val player: List<PlayerModel>,
        @SerializedName("players")
        val players: List<PlayerModel>
)