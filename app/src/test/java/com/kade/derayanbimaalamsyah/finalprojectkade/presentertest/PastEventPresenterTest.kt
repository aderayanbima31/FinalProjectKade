package com.kade.derayanbimaalamsyah.finalprojectkade.presentertest

import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.finalprojectkade.TestContextProvider
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.TheSportApi
import com.kade.derayanbimaalamsyah.finalprojectkade.model.EventModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.EventResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.presenter.PastPresenter
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.fragments.match.prev.PastView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class PastEventPresenterTest {
    @Mock
    private lateinit var view: PastView

    @Mock
    private lateinit var gson: Gson

    @Mock
    lateinit var apiRequest: ApiRequest

    private lateinit var presenter: PastPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = PastPresenter(view, apiRequest, gson, TestContextProvider())
    }

    @Test
    fun testGetPrevEvent() {
        val events: MutableList<EventModel> = mutableListOf()
        val response = EventResponseModel(events, events)
        val paramEvent = "eventspastleague"

        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getSchedule(paramEvent)),
                EventResponseModel::class.java)).thenReturn(response)

        presenter.getEventList(paramEvent)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEventList(events)
        Mockito.verify(view).hideLoading()
    }
}