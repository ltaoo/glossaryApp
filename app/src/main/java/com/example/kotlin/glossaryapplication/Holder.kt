package com.example.kotlin.glossaryapplication

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.widget.TextView

/**
 * Created by ltaoo on 2017/11/28.
 */
class Holder(itemView: View, click: OnItemClick) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    val textView: TextView

    private var click: OnItemClick? = null

    init {
        textView = itemView.findViewOften(R.id.textView)
        this.click = click
        // 注册监听
        itemView.setOnClickListener(this)
    }

    fun <T: View> View.findViewOften(viewId: Int): T {
        val viewHolder: SparseArray<View> = tag as? SparseArray<View> ?: SparseArray()
        tag = viewHolder
        var childView: View? = viewHolder.get(viewId)
        if (null == childView) {
            childView = findViewById(viewId)
            viewHolder.put(viewId, childView)
        }

        return childView as T
    }

    override fun onClick(v: View?) {
        if (v !== null) {
            click!!.onItemClick(v, adapterPosition)
        }
    }
}