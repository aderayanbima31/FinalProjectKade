package com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.activities.detail.match

import com.kade.derayanbimaalamsyah.finalprojectkade.model.EventModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.TeamModel


interface DetailMatchesView {
    fun hideLoading()
    fun showLoading()
    fun showEventList(data: List<EventModel>, home: List<TeamModel>, away: List<TeamModel>)
}