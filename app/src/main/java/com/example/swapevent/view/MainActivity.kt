package com.example.swapevent.view

import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swapevent.R
import com.example.swapevent.fragments.*
import com.example.swapevent.model.entity.Event
import com.example.swapevent.model.entity.General
import com.example.swapevent.model.repo.remote.network.RetrofitInstance
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){


    private var allFragment:Fragment= Fragment()
    private var musicFragment:Fragment=Fragment()
    private var sportsFragment:Fragment=Fragment()
    private lateinit var bottomNav:BottomNavigationView
    private lateinit var recyclerALl : RecyclerView
    private lateinit var tryAgainButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_SwapEvent)

        setContentView(R.layout.activity_main)
        recyclerALl = findViewById(R.id.recyclerViewEventsAll)
        setFragment(allFragment)

        allFragment = All()
        musicFragment = Music()
        sportsFragment = Sports()

        bottomNav = BottomNavigationView(this)
        bottomNav = findViewById<BottomNavigationView>(R.id.navigation_bar)



        callApi("All")
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.ic_all -> {setFragment(allFragment)
                    callApi("All") }
                R.id.ic_music -> {setFragment(musicFragment)
                    callApi("Music") }
                R.id.ic_sports -> {setFragment(sportsFragment)
                    callApi("Sports") }
            }
            true
        }
    }


    private fun callApi(Type : String) {
            val eventService = RetrofitInstance.buildEventsService()
            eventService.getEvent().enqueue(object : Callback<General> {
                override fun onResponse(call: Call<General>, response: Response<General>) {
                    if (response.isSuccessful) {
                        val items = response.body() as General
                        val eventsAdapter = EventsAdapter(items._embedded.events,this@MainActivity)
                        recyclerALl.layoutManager = LinearLayoutManager(this@MainActivity)
                        recyclerALl.adapter = eventsAdapter

                        if (Type == "All") {
                           val eventsAdapter = EventsAdapter(items._embedded.events,this@MainActivity)
                           recyclerALl.layoutManager = LinearLayoutManager(this@MainActivity)
                           recyclerALl.adapter = eventsAdapter
                         }
                        else{
                           val eventsAdapter = EventsAdapter(filtre(items._embedded.events, Type),this@MainActivity)
                           recyclerALl.layoutManager = LinearLayoutManager(this@MainActivity)
                           recyclerALl.adapter = eventsAdapter
                         }
                    }
                }

                override fun onFailure(call: Call<General>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Server Error", Toast.LENGTH_LONG).show()
                    setContentView(R.layout.activity_error)
                    tryAgainButton = findViewById(R.id.try_again)
                    Log.println(Log.ASSERT, "////////", t.message.toString())
                    tryAgainButton.setOnClickListener {
                        finish()
                        startActivity(intent)
                    }
                }
            })
        }

    fun filtre(items:List<Event> ,Type : String?) : List<Event>{
        val event_sports = ArrayList<Event>()
        for (item in items){
            if (item.classifications[0].segment.name.equals(Type))
                event_sports.add(item)
        }
        Log.println(Log.ASSERT,"Test Filtrage Sports==>",event_sports.toString())
        return event_sports

    }

    private fun setFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }






}





