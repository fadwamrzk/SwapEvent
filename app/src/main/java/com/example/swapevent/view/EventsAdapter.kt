package com.example.swapevent.view


import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.swapevent.R
import com.example.swapevent.model.entity.Event
import com.squareup.picasso.Picasso

class EventsAdapter (

    var items: List<Event>,
    private val context : Context) : RecyclerView.Adapter<EventsAdapter.EventsViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_event,parent,false)
        return EventsViewHolder(itemView )
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        val event=items[position]
        holder.bind(event)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class EventsViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView){
        fun bind(event: Event){

            itemView.findViewById<TextView>(R.id.EventName).text = event.name
            Picasso.get().load(event.images.get(2).url).placeholder(R.drawable.loading).into(itemView.findViewById<ImageView>(R.id.image))
            itemView.findViewById<TextView>(R.id.EventDate).text = event.dates.start.localDate
            itemView.findViewById<TextView>(R.id.EventTime).text = event.dates.start.localTime

            itemView.setOnClickListener() {
                val intent = Intent(context,DetailedActivity::class.java).apply {
                    putExtra("name", event.name)
                    putExtra("local", event.locale)
                    putExtra("photo", event.images.get(2).url)

                    val list = listOf("genre", "subGenre", "type", "subType")
                    try {
                        for (item in list) {
                            when (item) {
                                "genre" -> putExtra("genre", event.classifications.get(0).genre.name)
                                "subGenre" -> putExtra("subGenre", event.classifications.get(0).subGenre.name)
                                "type" -> putExtra("type", event.classifications.get(0).type.name)
                                "subType" -> putExtra("subType", event.classifications.get(0).subType.name)
                                else -> putExtra(item, "error")
                            }
                        }
                    }catch (e :NullPointerException ){
                        putExtra(list.toString(), "error")
                    }
                }
                    context.startActivity(intent)
            }
        }
    }
}

