package com.example.swapevent.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swapevent.R
import com.example.swapevent.model.entity.General
import com.example.swapevent.model.repo.remote.network.RetrofitInstance
import com.example.swapevent.view.EventsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Sports : Fragment() {

    override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
        View? {

        val recyclerVSports = view?.findViewById<RecyclerView>(R.id.recyclerViewEventsSports)

        return inflater.inflate(R.layout.fragment_sports, container, false)
    }


}
