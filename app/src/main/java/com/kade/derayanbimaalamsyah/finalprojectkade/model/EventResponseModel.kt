package com.kade.derayanbimaalamsyah.finalprojectkade.model

import com.google.gson.annotations.SerializedName

data class EventResponseModel(
        @SerializedName("events")
        val event: List<EventModel>,
        @SerializedName("event")
        val searchEvent: List<EventModel>
)