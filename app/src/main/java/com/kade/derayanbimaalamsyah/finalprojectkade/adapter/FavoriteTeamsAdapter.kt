package com.kade.derayanbimaalamsyah.finalprojectkade.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.kade.derayanbimaalamsyah.finalprojectkade.adapter.viewholders.TeamViewHolder
import com.kade.derayanbimaalamsyah.finalprojectkade.model.database.TeamDB
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.ItemTeamsUI
import org.jetbrains.anko.AnkoContext


class FavoriteTeamsAdapter (private val favoriteMatches: List<TeamDB>,
                            private val listener: (TeamDB) -> Unit):
        RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(ItemTeamsUI().createView(AnkoContext.
                create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindFavorite(favoriteMatches[position], listener)
    }

    override fun getItemCount(): Int = favoriteMatches.size
}