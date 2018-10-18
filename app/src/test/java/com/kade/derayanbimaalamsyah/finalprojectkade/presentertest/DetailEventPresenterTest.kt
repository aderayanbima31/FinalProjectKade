package com.kade.derayanbimaalamsyah.finalprojectkade.presentertest

import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.finalprojectkade.TestContextProvider
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.TheSportApi
import com.kade.derayanbimaalamsyah.finalprojectkade.model.EventModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.EventResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.TeamModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.TeamResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.presenter.DetailMatchesPresenter
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.activities.detail.match.DetailMatchesView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailEventPresenterTest {
    @Mock
    private lateinit var view: DetailMatchesView

    @Mock
    private lateinit var gson: Gson

    @Mock
    lateinit var apiRequest: ApiRequest

    private lateinit var presenter: DetailMatchesPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailMatchesPresenter(view, apiRequest, gson, TestContextProvider())
    }

    @Test
    fun testGetNextEvent() {
        val events: MutableList<EventModel> = mutableListOf()
        val home: MutableList<TeamModel> = mutableListOf()
        val away: MutableList<TeamModel> = mutableListOf()
        val response = EventResponseModel(events, events)
        val homeResponse = TeamResponseModel(home)
        val awayResponse = TeamResponseModel(away)
        val idEvent = "526916"
        val idHomeTeam = "134778"
        val idAwayTeam = "133613"

        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getDetailEvent(idEvent)),
                EventResponseModel::class.java)).thenReturn(response)
        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getHomeBadge(idHomeTeam)),
                TeamResponseModel::class.java)).thenReturn(homeResponse)
        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getAwayBadge(idAwayTeam)),
                TeamResponseModel::class.java)).thenReturn(awayResponse)

        presenter.getEventDetail(idEvent, idHomeTeam, idAwayTeam)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEventList(events, home, away)
        Mockito.verify(view).hideLoading()
    }
}