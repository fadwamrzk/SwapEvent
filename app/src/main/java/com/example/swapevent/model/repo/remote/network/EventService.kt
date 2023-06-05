package com.example.swapevent.model.repo.remote.network

import retrofit2.Call
import com.example.swapevent.model.entity.General
import retrofit2.http.GET

interface EventService {

    @GET("events.json?apikey=OD4xzueT8AYEJ5aTol53tSotfeZHPUEL")
    fun getEvent(): Call<General>

}