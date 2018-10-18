package com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko

import android.support.design.widget.TabLayout
import android.view.Gravity
import com.kade.derayanbimaalamsyah.finalprojectkade.R
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.fragments.teams.TeamsFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.tabLayout
import org.jetbrains.anko.design.themedTabLayout
import org.jetbrains.anko.support.v4.viewPager


class TeamFragmentUI : AnkoComponent<TeamsFragment> {

    override fun createView(ui: AnkoContext<TeamsFragment>) = with(ui) {
        coordinatorLayout {
            lparams(width = matchParent, height =  matchParent)

            appBarLayout {
                lparams(width = matchParent, height = wrapContent)

                toolbar {
                    lparams(width = matchParent, height = R.attr.actionBarSize)
                    id = R.id.toolbar_teams
                    backgroundColor = R.attr.colorPrimary
                }

                tabLayout {
                    lparams(width = matchParent, height = wrapContent)
                    themedTabLayout(R.style.ThemeOverlay_AppCompat_Dark)
                    id = R.id.tabs_teams
                    tabGravity = Gravity.FILL
                    tabMode = TabLayout.MODE_FIXED
                }
            }
            viewPager {
                id = R.id.pager_teams
            }.lparams(width = matchParent, height = wrapContent)
        }
    }
}