package com.example.swapevent.fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.swapevent.R


class All : Fragment() {

    override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
        View? {

        val recyclerVAll = view?.findViewById<RecyclerView>(R.id.recyclerViewEventsAll)

      /*  val eventService= RetrofitInstance.buildEventsService()
        eventService.getEvent().enqueue(object : Callback<General> {

            override fun onResponse(call: Call<General>, response: Response<General>)
            {
                if (response.isSuccessful){
                    val items=response.body() as General

                    val eventsAdapter = EventsAdapter(items._embedded.events,this@All)
                    recyclerVAll?.layoutManager = LinearLayoutManager(requireContext())
                    recyclerVAll?.adapter = eventsAdapter
                    Log.println(Log.ASSERT, "-------ALL--------", response.body().toString())
                }
            }

            override fun onFailure(call: Call<General>, t:Throwable){
                Toast.makeText(requireContext(),"Server Error", Toast.LENGTH_LONG).show()
                Log.println(Log.ASSERT, "///////", t.message.toString())
            }
        })*/

        return inflater.inflate(R.layout.fragment_all, container, false)
    }
}
