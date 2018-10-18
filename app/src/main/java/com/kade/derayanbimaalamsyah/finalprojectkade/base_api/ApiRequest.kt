package com.kade.derayanbimaalamsyah.finalprojectkade.base_api

import java.net.URL

class ApiRequest {

    fun doRequest(url: String) : String {
        return URL(url).readText()
    }
}