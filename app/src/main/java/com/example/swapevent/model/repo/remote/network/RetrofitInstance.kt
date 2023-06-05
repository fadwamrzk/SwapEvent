package com.example.swapevent.model.repo.remote.network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const  val BASE_URL ="https://app.ticketmaster.com/discovery/v2/"
    private val retrofit by lazy {
         Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }
    fun buildEventsService(): EventService = retrofit.create((EventService::class.java))
}