package com.kade.derayanbimaalamsyah.finalprojectkade.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.kade.derayanbimaalamsyah.finalprojectkade.adapter.viewholders.MatchesViewHolder
import com.kade.derayanbimaalamsyah.finalprojectkade.model.EventModel
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.ItemMatchesUI
import org.jetbrains.anko.AnkoContext


class MatchesAdapater (private val matchs: List<EventModel>) :
        RecyclerView.Adapter<MatchesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesViewHolder {
        return MatchesViewHolder(ItemMatchesUI().createView(AnkoContext.create(parent.context,
                parent)))
    }

    override fun getItemCount(): Int = matchs.size

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        holder.bindItem(matchs[position])
    }

}