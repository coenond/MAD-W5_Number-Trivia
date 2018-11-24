package com.coen.mad_w5_number_trivia.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import io.reactivex.disposables.Disposable
import com.coen.mad_w5_number_trivia.R
import com.coen.mad_w5_number_trivia.api.NumbersAPI
import com.coen.mad_w5_number_trivia.model.Number
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var numberList = ArrayList<Number>()
    private val numbersApi by lazy { NumbersAPI.create() }
    private var disposable: Disposable? = null
    val numberAdapter = NumberAdapter(numberList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init RecyclerView
        rv_number_list.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rv_number_list.adapter = numberAdapter

        fab.setOnClickListener { getRandomNumber() }
    }

    fun getRandomNumber() {
        disposable = numbersApi.getRandomNumber()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { addToList(it) }
                )
    }

    fun addToList(number: Number) {
        numberList.add(number)
        numberAdapter.updateList(numberList)
    }
}