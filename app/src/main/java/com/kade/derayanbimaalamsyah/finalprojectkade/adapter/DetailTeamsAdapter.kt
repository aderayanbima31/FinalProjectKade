package com.kade.derayanbimaalamsyah.finalprojectkade.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.kade.derayanbimaalamsyah.finalprojectkade.adapter.viewholders.ListPlayerViewHolder
import com.kade.derayanbimaalamsyah.finalprojectkade.model.PlayerModel
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.ItemListPlayerUI
import org.jetbrains.anko.AnkoContext

class DetailTeamsAdapter (private val players: List<PlayerModel>) :
        RecyclerView.Adapter<ListPlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPlayerViewHolder {
        return ListPlayerViewHolder(ItemListPlayerUI().createView(AnkoContext.create(parent.context,
                parent)))
    }

    override fun getItemCount(): Int = players.size

    override fun onBindViewHolder(holder: ListPlayerViewHolder, position: Int) {
        holder.bindItem(players[position])
    }
}