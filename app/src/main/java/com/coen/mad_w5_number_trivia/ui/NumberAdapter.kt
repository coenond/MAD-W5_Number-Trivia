package com.coen.mad_w5_number_trivia.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coen.mad_w5_number_trivia.R
import com.coen.mad_w5_number_trivia.model.Number
import kotlinx.android.synthetic.main.item_number.view.*

class NumberAdapter(val items : ArrayList<Number>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int { return items.size }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_number, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNumber?.text = items[position].num.toString()
        holder.tvText?.text = items[position].text
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvNumber = view.tv_number!!
    val tvText = view.tv_text!!
}