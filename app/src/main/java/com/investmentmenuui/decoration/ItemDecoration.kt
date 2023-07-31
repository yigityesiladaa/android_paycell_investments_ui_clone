package com.investmentmenuui.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecoration(private val marginHorizontal: Int, private val marginVertical: Int, private val marginInner: Int) :
    RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.left = marginHorizontal
        outRect.right = marginHorizontal

        val position = parent.getChildAdapterPosition(view)
        val itemCount = parent.layoutManager?.itemCount ?: 0

        when (position) {
            0 -> {
                outRect.top = marginVertical
                outRect.bottom = marginInner
            }
            itemCount - 1 -> {
                outRect.top = marginInner
                outRect.bottom = marginVertical
            }
            else -> {
                outRect.top = marginInner
                outRect.bottom = marginInner
            }
        }
    }
}
