package com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.fragments.match.next

import com.kade.derayanbimaalamsyah.finalprojectkade.model.EventModel


interface NextView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<EventModel>?)
    fun errorMessage(message: String?)
}