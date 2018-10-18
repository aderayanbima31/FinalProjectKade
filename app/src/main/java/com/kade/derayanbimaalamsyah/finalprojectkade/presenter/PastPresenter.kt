package com.kade.derayanbimaalamsyah.finalprojectkade.presenter

import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.TheSportApi
import com.kade.derayanbimaalamsyah.finalprojectkade.model.EventResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.utils.CoroutineContextProvider
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.fragments.match.prev.PastView
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class PastPresenter (private val view: PastView,
                     private val apiRequest: ApiRequest,
                     private val gson: Gson,
                     private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getEventList(match: String?) {
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getSchedule(match)),
                        EventResponseModel::class.java
                )
            }
            view.showEventList(data.await().event)
            view.hideLoading()
        }
    }

    fun getSearchEventList(match: String?) {
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getSearchEventByName(match)),
                        EventResponseModel::class.java
                )
            }
            view.showEventList(data.await().searchEvent)
            view.hideLoading()
        }
    }

    fun getEventListByLeague(nameLeague: String?) {
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getListEventByLeague(nameLeague)),
                        EventResponseModel::class.java
                )
            }
            view.showEventList(data.await().searchEvent)
            view.hideLoading()
        }
    }
}