package com.kade.derayanbimaalamsyah.finalprojectkade.model

import com.google.gson.annotations.SerializedName

data class PlayerModel(
        @SerializedName("idPlayer") var playerId: String? = null,
        @SerializedName("strPlayer") var strPlayer: String? = null,
        @SerializedName("strPosition") var strPosition: String? = null,
        @SerializedName("strCutout") var strCutout: String? = null,
        @SerializedName("strDescriptionEN") var strDescription: String? = null,
        @SerializedName("strThumb") var strThumb: String? = null,
        @SerializedName("strHeight") var strHeight: String? = null,
        @SerializedName("strWeight") var strWeight: String? = null,
        @SerializedName("strFanart1") var strFanart1: String? = null
)