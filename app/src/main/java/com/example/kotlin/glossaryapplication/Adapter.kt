package com.example.kotlin.glossaryapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AbsListView

/**
 * Created by ltaoo on 2017/11/28.
 */
class Adapter : RecyclerView.Adapter<Holder>() {
    var list: List<String> = ArrayList<String>()
    var click: OnItemClick? = null

    fun add(list: List<String>) {
        this.list = list
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder!!.textView.setText(list!!.get(position))
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view = LayoutInflater.from(parent!!.getContext()).inflate(R.layout.item_holder_view, parent, false)
        val holder = Holder(view, click!!)
        return holder
    }

    fun setItemClick(click: OnItemClick) {
        this.click = click
    }
}