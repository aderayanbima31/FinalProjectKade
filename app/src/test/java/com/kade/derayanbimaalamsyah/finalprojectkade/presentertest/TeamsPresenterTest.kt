package com.kade.derayanbimaalamsyah.finalprojectkade.presentertest

import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.finalprojectkade.TestContextProvider
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.TheSportApi
import com.kade.derayanbimaalamsyah.finalprojectkade.model.TeamModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.TeamResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.presenter.TeamsPresenter
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.fragments.teams.TeamsView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class TeamsPresenterTest  {
    @Mock
    private lateinit var view: TeamsView

    @Mock
    private lateinit var gson: Gson

    @Mock
    lateinit var apiRequest: ApiRequest

    private lateinit var presenter: TeamsPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TeamsPresenter(view, apiRequest, gson, TestContextProvider())
    }

    @Test
    fun testGetTeams() {
        val teams: MutableList<TeamModel> = mutableListOf()
        val response = TeamResponseModel(teams)
        val paramEvent = "Spanish"

        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getListTeamByLeague(paramEvent)),
                TeamResponseModel::class.java)).thenReturn(response)

        presenter.getTeamList(paramEvent)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEventList(teams)
        Mockito.verify(view).hideLoading()
    }
}