package com.kade.derayanbimaalamsyah.finalprojectkade.adapter.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.kade.derayanbimaalamsyah.finalprojectkade.R.string.item_teamdetail_id
import com.kade.derayanbimaalamsyah.finalprojectkade.R
import com.kade.derayanbimaalamsyah.finalprojectkade.model.TeamModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.database.TeamDB
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.activities.detail.team.DetailTeamsActivity
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity


class TeamViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    private val teamBadge: ImageView = view.find(R.id.team_badge)
    private val teamName: TextView = view.find(R.id.team_name)

    fun bindItem(teams: TeamModel) {
        Picasso.get().load(teams.teamBadge).into(teamBadge)
        teamName.text = teams.teamName

        val ctx = itemView.context

        itemView.setOnClickListener {
            ctx.startActivity<DetailTeamsActivity>(
                    ctx.getString(item_teamdetail_id) to teams.teamId)
        }
    }

    fun bindFavorite(favorite: TeamDB, listener: (TeamDB) -> Unit) {
        Picasso.get().load(favorite.badgeTeam).into(teamBadge)
        teamName.text = favorite.teamName

        itemView.onClick {
            listener(favorite)
        }
    }
}