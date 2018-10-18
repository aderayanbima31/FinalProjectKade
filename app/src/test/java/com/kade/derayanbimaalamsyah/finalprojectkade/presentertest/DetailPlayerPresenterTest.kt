package com.kade.derayanbimaalamsyah.finalprojectkade.presentertest

import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.finalprojectkade.TestContextProvider
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.TheSportApi
import com.kade.derayanbimaalamsyah.finalprojectkade.model.PlayerModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.PlayerResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.presenter.DetailPlayersPresenter
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.activities.detail.player.DetailPlayerView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class DetailPlayerPresenterTest {
    @Mock
    private lateinit var view: DetailPlayerView

    @Mock
    private lateinit var gson: Gson

    @Mock
    lateinit var apiRequest: ApiRequest

    private lateinit var presenter: DetailPlayersPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailPlayersPresenter(view, apiRequest, gson, TestContextProvider())
    }

    @Test
    fun getTestDetailPlayers() {
        val detailPlayer: MutableList<PlayerModel> = mutableListOf()

        val playerResponse = PlayerResponseModel(detailPlayer, detailPlayer)

        val idPlayer = "34145411"

        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getDetailPlayerTeam(idPlayer)),
                PlayerResponseModel::class.java)).thenReturn(playerResponse)

        presenter.getPlayerDetail(idPlayer)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showPlayerDetail(detailPlayer)
        Mockito.verify(view).hideLoading()
    }
}