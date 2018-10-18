package com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.fragments.match.prev

import com.kade.derayanbimaalamsyah.finalprojectkade.model.EventModel


interface PastView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<EventModel>?)
    fun errorMessage(message: String?)
}