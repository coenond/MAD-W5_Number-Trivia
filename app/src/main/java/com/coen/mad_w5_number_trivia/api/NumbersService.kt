package com.coen.mad_w5_number_trivia.api

import com.coen.mad_w5_number_trivia.model.Number
import io.reactivex.Observable
import retrofit2.http.GET

interface NumbersService {

    @GET("random/trivia?json")
    fun getRandomNumber(): Observable<Number>

}