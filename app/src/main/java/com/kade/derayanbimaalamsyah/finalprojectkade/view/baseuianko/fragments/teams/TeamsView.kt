package com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.fragments.teams

import com.kade.derayanbimaalamsyah.finalprojectkade.model.TeamModel



interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<TeamModel>?)
}