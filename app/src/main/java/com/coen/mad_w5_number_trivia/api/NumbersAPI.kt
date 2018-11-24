package com.coen.mad_w5_number_trivia.api

import com.coen.mad_w5_number_trivia.model.Number
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class NumbersAPI {
    companion object {
        fun create(): NumbersService {

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()

            val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl("http://numbersapi.com/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            return retrofit.create(NumbersService::class.java)
        }
    }

//   fun start() {
//        val gson = GsonBuilder()
//                .setLenient()
//                .create()
//
//        val retrofit = Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build()
//
//        val numberAPI = retrofit.create(NumbersService::class.java)
//        println("hello?")
//        val call = numberAPI.getRandomNumber()
//        call.enqueue(this)
//    }
//
//    // Member function
//    override fun onFailure(call: Call<Number>, t: Throwable) { }
//    override fun onResponse(call: Call<Number>, response: Response<Number>) {
//        println("Response")
//        println(response)
//        println(response.message())
//        println(response.body())
//        println(response.raw())
//        if (response.isSuccessful) {
//            println("RESPONSE")
//            println(response.body())
//        }
//        else println(response.errorBody())
//    }
}
