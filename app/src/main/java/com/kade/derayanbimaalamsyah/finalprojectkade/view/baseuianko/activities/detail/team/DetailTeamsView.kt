package com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.activities.detail.team

import com.kade.derayanbimaalamsyah.finalprojectkade.model.PlayerModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.TeamModel

interface DetailTeamsView {
    fun hideLoading()
    fun showLoading()
    fun showEventList(data: List<TeamModel>, player: List<PlayerModel>)
}