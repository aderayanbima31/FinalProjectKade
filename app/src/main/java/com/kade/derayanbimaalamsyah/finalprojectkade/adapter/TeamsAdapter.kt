package com.kade.derayanbimaalamsyah.finalprojectkade.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.kade.derayanbimaalamsyah.finalprojectkade.adapter.viewholders.TeamViewHolder
import com.kade.derayanbimaalamsyah.finalprojectkade.model.TeamModel
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.ItemTeamsUI
import org.jetbrains.anko.AnkoContext


class TeamsAdapter (private val teams: List<TeamModel>)
    : RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(ItemTeamsUI().createView(AnkoContext.create(parent.context,
                parent)))
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position])
    }
}