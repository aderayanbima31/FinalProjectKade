package com.kade.derayanbimaalamsyah.finalprojectkade.presentertest

import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.finalprojectkade.TestContextProvider
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.TheSportApi
import com.kade.derayanbimaalamsyah.finalprojectkade.model.PlayerModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.PlayerResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.TeamModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.TeamResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.presenter.DetailTeamsPresenter
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.activities.detail.team.DetailTeamsView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class DetailTeamsPresenterTest {
    @Mock
    private lateinit var view: DetailTeamsView

    @Mock
    private lateinit var gson: Gson

    @Mock
    lateinit var apiRequest: ApiRequest

    private lateinit var presenter: DetailTeamsPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailTeamsPresenter(view, apiRequest, gson, TestContextProvider())
    }

    @Test
    fun getTestDetailTeams() {
        val detailTeam: MutableList<TeamModel> = mutableListOf()
        val listPlayer: MutableList<PlayerModel> = mutableListOf()

        val response = TeamResponseModel(detailTeam)
        val homeResponse = PlayerResponseModel(listPlayer, listPlayer)

        val idTeam = "133604"

        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getListDetailTeam(idTeam)),
                TeamResponseModel::class.java)).thenReturn(response)
        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getListPlayerTeam(idTeam)),
                PlayerResponseModel::class.java)).thenReturn(homeResponse)

        presenter.getTeamDetail(idTeam)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEventList(detailTeam, listPlayer)
        Mockito.verify(view).hideLoading()
    }
}