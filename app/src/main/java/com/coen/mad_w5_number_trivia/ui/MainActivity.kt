package com.coen.mad_w5_number_trivia.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.coen.mad_w5_number_trivia.R
import com.coen.mad_w5_number_trivia.model.Number
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var numberList = ArrayList<Number>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillList()

        // Init RecyclerView
        rv_number_list.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rv_number_list.adapter = NumberAdapter(numberList, this)
    }

    fun fillList() {
        numberList.add(Number(436, "is the number of spots (or pips, circular patches or pits) on a pair of standard six-sided dice."))
        numberList.add(Number(946, "is the length in miles of a train of boxcars that can be filled from recycled paper in the USA every day."))
        numberList.add(Number(742, "is the number of suicides mentioned in the Bible."))
        numberList.add(Number(226, "is the number of Cantons of Switzerland."))
    }
}