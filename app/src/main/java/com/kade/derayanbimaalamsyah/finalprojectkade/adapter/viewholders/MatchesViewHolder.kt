package com.kade.derayanbimaalamsyah.finalprojectkade.adapter.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.kade.derayanbimaalamsyah.finalprojectkade.R
import com.kade.derayanbimaalamsyah.finalprojectkade.model.EventModel
import com.kade.derayanbimaalamsyah.finalprojectkade.model.database.MatchDB
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.activities.detail.match.DetailMatchesActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*

class MatchesViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    private val timeSchedule: TextView = view.find(R.id.time_schedule)
    private val homeTeam: TextView = view.find(R.id.tvHomeTeam)
    private val homeScore: TextView = view.find(R.id.tvHomeScore)
    private val awayScore: TextView = view.find(R.id.tvAwayScore)
    private val awayTeam: TextView = view.find(R.id.tvAwayTeam)

    fun bindItem(events: EventModel) {

        val timeEvent = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                .parse(events.dateEvent)
        val dateEvent = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
                .format(timeEvent)

        timeSchedule.text = dateEvent.toString()
        homeTeam.text = events.strHomeTeam
        homeScore.text = events.intHomeScore
        awayScore.text = events.intAwayScore
        awayTeam.text = events.strAwayTeam

        val ctx = itemView.context

        itemView.setOnClickListener {
            ctx.startActivity<DetailMatchesActivity>(
                    ctx.getString(R.string.item_eventdetail_id) to events.idEvent,
                    ctx.getString(R.string.item_home_id) to events.idHomeTeam,
                    ctx.getString(R.string.item_away_id) to events.idAwayTeam)
        }
    }

    fun bindFavorite(favoriteMatches: MatchDB, listener:(MatchDB) -> Unit) {
        val timeEvent = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                .parse(favoriteMatches.eventTime)
        val dateEvent = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
                .format(timeEvent)

        timeSchedule.text = dateEvent.toString()
        homeTeam.text = favoriteMatches.homeTeam
        homeScore.text = favoriteMatches.homeScore
        awayScore.text = favoriteMatches.awayScore
        awayTeam.text = favoriteMatches.awayTeam

        itemView.onClick {
            listener(favoriteMatches)
        }

    }
}