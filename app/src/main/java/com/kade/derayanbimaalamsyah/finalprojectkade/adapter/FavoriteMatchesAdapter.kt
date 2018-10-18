package com.kade.derayanbimaalamsyah.finalprojectkade.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.kade.derayanbimaalamsyah.finalprojectkade.adapter.viewholders.MatchesViewHolder
import com.kade.derayanbimaalamsyah.finalprojectkade.model.database.MatchDB
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.ItemMatchesUI
import org.jetbrains.anko.AnkoContext


class FavoriteMatchesAdapter (private val favoriteMatches: List<MatchDB>,
                              private val listener: (MatchDB) -> Unit):
        RecyclerView.Adapter<MatchesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesViewHolder {
        return MatchesViewHolder(ItemMatchesUI().createView(AnkoContext.create(parent.context, parent)))
    }


    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        holder.bindFavorite(favoriteMatches[position], listener)
    }

    override fun getItemCount(): Int = favoriteMatches.size
}