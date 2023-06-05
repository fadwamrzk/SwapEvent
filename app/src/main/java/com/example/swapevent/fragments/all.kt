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


        return inflater.inflate(R.layout.fragment_all, container, false)
    }
}
