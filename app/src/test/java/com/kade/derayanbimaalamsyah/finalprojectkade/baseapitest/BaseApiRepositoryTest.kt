package com.kade.derayanbimaalamsyah.finalprojectkade.baseapitest

import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.finalprojectkade.base_api.TheSportApi
import org.junit.Test
import org.mockito.Mockito

class BaseApiRepositoryTest {

    @Test
    fun testSearchEventByName() {
        val apiRepository = Mockito.mock(ApiRequest::class.java)
        val url = TheSportApi.getSearchEventByName("Chelsea")
        apiRepository.doRequest(url)
        Mockito.verify(apiRepository).doRequest(url)
    }

    @Test
    fun testSearchTeam() {
        val apiRepository = Mockito.mock(ApiRequest::class.java)
        val url = TheSportApi.getSearchTeamByName("Liverpool")
        apiRepository.doRequest(url)
        Mockito.verify(apiRepository).doRequest(url)
    }
}