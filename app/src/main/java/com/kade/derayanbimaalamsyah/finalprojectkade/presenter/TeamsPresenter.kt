package com.kade.derayanbimaalamsyah.finalprojectkade.presenter

import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.TheSportApi
import com.kade.derayanbimaalamsyah.finalprojectkade.model.TeamResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.utils.CoroutineContextProvider
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.fragments.teams.TeamsView
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class TeamsPresenter (private val view: TeamsView,
                      private val apiRequest: ApiRequest,
                      private val gson: Gson,
                      private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getTeamList(match: String?) {
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getListTeamByLeague(match)),
                        TeamResponseModel::class.java
                )
            }
            view.showEventList(data.await().team)
            view.hideLoading()
        }
    }

    fun getSearchTeam(team: String?) {
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getSearchTeamByName(team)),
                        TeamResponseModel::class.java
                )
            }
            view.showEventList(data.await().team)
            view.hideLoading()
        }
    }
}