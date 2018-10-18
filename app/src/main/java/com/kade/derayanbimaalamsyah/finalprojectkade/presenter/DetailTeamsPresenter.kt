package com.kade.derayanbimaalamsyah.finalprojectkade.presenter

import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.TheSportApi
import com.kade.derayanbimaalamsyah.finalprojectkade.model.PlayerResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.TeamResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.utils.CoroutineContextProvider
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.activities.detail.team.DetailTeamsView
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class DetailTeamsPresenter(private val view: DetailTeamsView,
                           private val apiRequest: ApiRequest,
                           private val gson: Gson,
                           private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getTeamDetail(idTeam: String?) {
        view.showLoading()

        async(context.main) {
            val eventDetailTeam = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getListDetailTeam(idTeam)),
                        TeamResponseModel::class.java)
            }
            val listPlayerTeam = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getListPlayerTeam(idTeam)),
                        PlayerResponseModel::class.java)
            }
            view.showEventList(eventDetailTeam.await().team, listPlayerTeam.await().player)
            view.hideLoading()
        }
    }
}