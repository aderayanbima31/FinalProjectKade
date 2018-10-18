package com.kade.derayanbimaalamsyah.finalprojectkade.presenter

import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.TheSportApi
import com.kade.derayanbimaalamsyah.finalprojectkade.model.PlayerResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.utils.CoroutineContextProvider
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.activities.detail.player.DetailPlayerView
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class DetailPlayersPresenter(private val view: DetailPlayerView,
                             private val apiRequest: ApiRequest,
                             private val gson: Gson,
                             private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getPlayerDetail(idPlayer: String?) {
        view.showLoading()

        async(context.main) {
            val detailPlayerTeam = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getDetailPlayerTeam(idPlayer)),
                        PlayerResponseModel::class.java)
            }
            view.showPlayerDetail(detailPlayerTeam.await().players)
            view.hideLoading()
        }
    }
}