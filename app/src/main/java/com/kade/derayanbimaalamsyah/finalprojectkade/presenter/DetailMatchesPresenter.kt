package com.kade.derayanbimaalamsyah.finalprojectkade.presenter

import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.TheSportApi
import com.kade.derayanbimaalamsyah.finalprojectkade.model.EventResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.TeamResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.utils.CoroutineContextProvider
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.activities.detail.match.DetailMatchesView
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class DetailMatchesPresenter(private val view: DetailMatchesView,
                             private val apiRequest: ApiRequest,
                             private val gson: Gson,
                             private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getEventDetail(idEvent: String?, idHomeTeam: String?, idAwayTeam: String?) {
        view.showLoading()

        async(context.main) {
            val eventDetail = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getDetailEvent(idEvent)),
                        EventResponseModel::class.java)
            }
            val badgeHome = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getHomeBadge(idHomeTeam)),
                        TeamResponseModel::class.java)
            }
            val badgeAway =  bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getAwayBadge(idAwayTeam)),
                        TeamResponseModel::class.java)
            }
            view.showEventList(eventDetail.await().event, badgeHome.await().team,
                    badgeAway.await().team)
            view.hideLoading()
        }
    }
}