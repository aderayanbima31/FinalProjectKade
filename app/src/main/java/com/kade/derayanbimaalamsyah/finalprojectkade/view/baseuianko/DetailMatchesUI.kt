package com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.LinearLayout
import com.kade.derayanbimaalamsyah.finalprojectkade.R
import com.kade.derayanbimaalamsyah.finalprojectkade.R.color.colorAccent
import com.kade.derayanbimaalamsyah.finalprojectkade.R.color.colorPrimary
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.activities.detail.match.DetailMatchesActivity

import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.swipeRefreshLayout


class DetailMatchesUI : AnkoComponent<DetailMatchesActivity> {

    @SuppressLint("NewApi")
    override fun createView(ui: AnkoContext<DetailMatchesActivity>) = with(ui) {
        swipeRefreshLayout {
            id = R.id.swipeRefreshDetail
            setColorSchemeResources(colorAccent,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light)

            scrollView {
                lparams(width = matchParent, height = matchParent)
                relativeLayout {
                    lparams(width = matchParent, height = matchParent)
                    linearLayout {
                        id = R.id.lyEventDetail
                        lparams(width = matchParent, height = matchParent)
                        orientation = LinearLayout.VERTICAL
                        gravity = Gravity.CENTER
                        backgroundColor = Color.WHITE
                        padding = dip(16)

                        textView {
                            id = R.id.tvDateDetail
                            gravity = Gravity.CENTER
                            textColor = colorPrimary
                            textSize = 18f
                            setTypeface(null, Typeface.BOLD)
                        }.lparams(width = wrapContent, height = wrapContent) {
                            topMargin = dip(8)
                            bottomMargin = dip(16)
                        }

                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            imageView{
                                id = R.id.ivHomeBadgeDetail
                                topPadding = dip(16)
                            }.lparams(width = dip(100), height = dip(100)) {
                                gravity = Gravity.CENTER
                                rightMargin = dip(16)
                            }

                            textView {
                                id = R.id.tvHomeScoreDetail
                                gravity = Gravity.CENTER
                                textSize = 48f
                                setTypeface(null, Typeface.BOLD)
                            }.lparams(width = wrapContent, height = wrapContent)

                            textView {
                                text = context.getString(R.string.resource_vs)
                                textSize = 24f
                            }.lparams(width = wrapContent, height = wrapContent) {
                                leftMargin = dip(8)
                                rightMargin = dip(8)
                            }

                            textView {
                                id = R.id.tvAwayScoreDetail
                                gravity = Gravity.CENTER
                                textSize = 48f
                                setTypeface(null, Typeface.BOLD)
                            }.lparams(width = wrapContent, height = wrapContent)

                            imageView{
                                id = R.id.ivAwayBadgeDetail
                                topPadding = dip(16)
                            }.lparams(width = dip(100), height = dip(100)) {
                                gravity = Gravity.CENTER
                                leftMargin = dip(16)
                            }

                        }.lparams(height = wrapContent, width = wrapContent)

                        //team and formation
                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            weightSum = 1f
                            gravity = Gravity.CENTER

                            linearLayout {
                                orientation = LinearLayout.VERTICAL

                                textView {
                                    id = R.id.tvHomeTeamDetail
                                    textColor = colorPrimary
                                    textSize = 20f
                                    setTypeface(null, Typeface.BOLD)
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.CENTER_HORIZONTAL
                                }

                                textView {
                                    id = R.id.tvHomeFormation
                                    textSize = 14f
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.CENTER_HORIZONTAL
                                }

                            }.lparams(width = 0, height = wrapContent, weight = 0.45f) {
                                margin = dip(16)
                            }

                            linearLayout {
                                orientation = LinearLayout.VERTICAL
                            }.lparams(width = 0, height = wrapContent, weight = 0.1f) {
                                margin = dip(16)
                            }

                            linearLayout {
                                orientation = LinearLayout.VERTICAL

                                textView {
                                    id = R.id.tvAwayTeamDetail
                                    textColor = colorPrimary
                                    textSize = 20f
                                    setTypeface(null, Typeface.BOLD)
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.CENTER_HORIZONTAL
                                }

                                textView {
                                    id = R.id.tvAwayFormation
                                    gravity = Gravity.CENTER_HORIZONTAL
                                    textSize = 14f
                                }

                            }.lparams(width = 0, height = wrapContent, weight = 0.45f) {
                                margin = dip(16)
                            }
                        }

                        view {
                            backgroundColorResource = android.R.color.darker_gray
                        }.lparams(width = matchParent, height = dip(2)) {
                            bottomMargin = dip(48)
                        }

                        //shot
                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            weightSum = 1f

                            relativeLayout {
                                textView {
                                    id = R.id.tvHomeShot
                                    textSize = 20f
                                    setTypeface(null, Typeface.BOLD)
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.START
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.4f) {
                                topMargin = dip(16)
                            }

                            relativeLayout {
                                textView {
                                    textSize = 18f
                                    text = context.getString(R.string.resource_shots)
                                    textColor = colorPrimary
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.CENTER_HORIZONTAL
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.2f) {
                                topMargin = dip(16)
                            }

                            relativeLayout {
                                textView {
                                    id = R.id.tvAwayShot
                                    textSize = 20f
                                    setTypeface(null, Typeface.BOLD)
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.END
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.4f) {
                                topMargin = dip(16)
                            }
                        }

                        view {
                            backgroundColorResource = android.R.color.darker_gray
                        }.lparams(width = matchParent, height = dip(2)) {
                            bottomMargin = dip(16)
                        }

                        textView {
                            textSize = 18f
                            text = context.getString(R.string.resource_lineups)
                        }.lparams(width = wrapContent, height = wrapContent)


                        //goalkeeper
                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            weightSum = 1f

                            relativeLayout {
                                textView {
                                    id = R.id.tvHomeGoalKeeper
                                    textSize = 12f

                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.START
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.4f) {
                                topMargin = dip(16)
                            }

                            relativeLayout {
                                textView {
                                    textSize = 12f
                                    text = context.getString(R.string.resource_goalkeeper)
                                    textColor = colorPrimary
                                    setTypeface(null, Typeface.BOLD)
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.CENTER_HORIZONTAL
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.2f) {
                                topMargin = dip(16)
                            }

                            relativeLayout {
                                textView {
                                    id = R.id.tvAwayGoalKeeper
                                    textSize = 12f
                                    gravity = right
                                    textAlignment = gravity
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.END
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.4f) {
                                topMargin = dip(16)
                            }
                        }

                        //Defense
                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            weightSum = 1f

                            relativeLayout {
                                textView {
                                    id = R.id.tvHomeDefense
                                    textSize = 12f

                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.START
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.4f) {
                                topMargin = dip(8)
                            }

                            relativeLayout {
                                textView {
                                    textSize = 12f
                                    text = context.getString(R.string.resource_defense)
                                    textColor = colorPrimary
                                    setTypeface(null, Typeface.BOLD)
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.CENTER_HORIZONTAL
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.2f) {
                                topMargin = dip(8)
                            }

                            relativeLayout {
                                textView {
                                    id = R.id.tvAwayDefense
                                    textSize = 12f
                                    gravity = right
                                    textAlignment = gravity
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.END
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.4f) {
                                topMargin = dip(8)
                            }
                        }

                        //Midfield
                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            weightSum = 1f

                            relativeLayout {
                                textView {
                                    id = R.id.tvHomeMidfield
                                    textSize = 12f

                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.START
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.4f) {
                                topMargin = dip(8)
                            }

                            relativeLayout {
                                textView {
                                    textSize = 12f
                                    text = context.getString(R.string.resource_midfield)
                                    textColor = colorPrimary
                                    setTypeface(null, Typeface.BOLD)
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.CENTER_HORIZONTAL
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.2f) {
                                topMargin = dip(8)
                            }

                            relativeLayout {
                                textView {
                                    id = R.id.tvAwayMidfield
                                    textSize = 12f
                                    gravity = right
                                    textAlignment = gravity
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.END
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.4f) {
                                topMargin = dip(8)
                            }
                        }

                        //Forward
                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            weightSum = 1f

                            relativeLayout {
                                textView {
                                    id = R.id.tvHomeForward
                                    textSize = 12f

                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.START
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.4f) {
                                topMargin = dip(8)
                            }

                            relativeLayout {
                                textView {
                                    textSize = 12f
                                    text = context.getString(R.string.resource_forward)
                                    textColor = colorPrimary
                                    setTypeface(null, Typeface.BOLD)
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.CENTER_HORIZONTAL
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.2f) {
                                topMargin = dip(8)
                            }

                            relativeLayout {
                                textView {
                                    id = R.id.tvAwayForward
                                    textSize = 12f
                                    gravity = right
                                    textAlignment = gravity
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    gravity = Gravity.END
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 0.4f) {
                                topMargin = dip(8)
                            }
                        }
                    }

                    progressBar {
                        id = R.id.pbDetailEvent
                    }.lparams {
                        centerInParent()
                    }
                }
            }
        }
    }
}