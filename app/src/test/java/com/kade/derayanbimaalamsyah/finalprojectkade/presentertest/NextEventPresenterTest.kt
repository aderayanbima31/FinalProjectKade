package com.kade.derayanbimaalamsyah.finalprojectkade.presentertest

import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.finalprojectkade.TestContextProvider
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.TheSportApi
import com.kade.derayanbimaalamsyah.finalprojectkade.model.EventModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.EventResponseModel
import com.kade.derayanbimaalamsyah.finalprojectkade.presenter.NextPresenter
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.fragments.match.next.NextView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NextEventPresenterTest {
    @Mock
    private lateinit var view: NextView

    @Mock
    private lateinit var gson: Gson

    @Mock
    lateinit var apiRequest: ApiRequest

    private lateinit var presenter: NextPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = NextPresenter(view, apiRequest, gson, TestContextProvider())
    }

    @Test
    fun testGetNextEvent() {
        val events: MutableList<EventModel> = mutableListOf()
        val response = EventResponseModel(events, events)
        val paramEvent = "eventsnextleague"

        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getSchedule(paramEvent)),
                EventResponseModel::class.java)).thenReturn(response)

        presenter.getEventList(paramEvent)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEventList(events)
        Mockito.verify(view).hideLoading()
    }
}