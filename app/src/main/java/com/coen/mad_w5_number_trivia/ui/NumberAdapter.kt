package com.coen.mad_w5_number_trivia.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coen.mad_w5_number_trivia.R
import com.coen.mad_w5_number_trivia.model.Number
import kotlinx.android.synthetic.main.item_number.view.*

class NumberAdapter(var items : ArrayList<Number>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int { return items.size }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.item_number, parent, false)
        layoutInflater.layoutDirection = when (getItemViewType(viewType)) {
            1 -> View.LAYOUT_DIRECTION_LTR
            else -> View.LAYOUT_DIRECTION_RTL
        }

        val viewholder = ViewHolder(layoutInflater)
        return viewholder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNumber?.text = items[position].number.toString()
        holder.tvText?.text = items[position].text
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) 1 else 0
    }

    fun updateList(items : ArrayList<Number>) {
        this.items = items
        notifyDataSetChanged()
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val clContainer = view.cl_container!!
    val tvNumber = view.tv_number!!
    val tvText = view.tv_text!!
}