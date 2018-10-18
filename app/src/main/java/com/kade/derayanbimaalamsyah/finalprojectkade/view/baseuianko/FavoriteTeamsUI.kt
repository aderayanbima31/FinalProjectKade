package com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko


import android.support.v7.widget.LinearLayoutManager
import com.kade.derayanbimaalamsyah.finalprojectkade.R
import com.kade.derayanbimaalamsyah.finalprojectkade.utils.SpaceItemDecoration
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.fragments.favorite.team.FavoriteTeamsFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout


class FavoriteTeamsUI : AnkoComponent<FavoriteTeamsFragment> {

    override fun createView(ui: AnkoContext<FavoriteTeamsFragment>) = with(ui) {
        relativeLayout {
            lparams(width = matchParent, height = matchParent)

            swipeRefreshLayout {
                id = R.id.swipeRefreshFavoTeams
                setColorSchemeResources(R.color.colorAccent,
                        android.R.color.holo_green_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_red_light)

                recyclerView {
                    lparams(width = matchParent, height = wrapContent)
                    id = R.id.rvFavoTeams
                    layoutManager = LinearLayoutManager(ctx)
                    addItemDecoration(SpaceItemDecoration(8))
                }
            }

            progressBar {
                id = R.id.pbFavoTeams
            }.lparams {
                centerHorizontally()
            }
        }
    }
}