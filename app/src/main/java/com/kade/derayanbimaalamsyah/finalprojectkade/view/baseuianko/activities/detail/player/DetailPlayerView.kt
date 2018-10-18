package com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.activities.detail.player


import com.kade.derayanbimaalamsyah.finalprojectkade.model.PlayerModel


interface DetailPlayerView {
    fun hideLoading()
    fun showLoading()
    fun showPlayerDetail(player: List<PlayerModel>)
}