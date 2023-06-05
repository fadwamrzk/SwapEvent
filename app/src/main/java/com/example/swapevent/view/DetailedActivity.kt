package com.example.swapevent.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.swapevent.R
import com.squareup.picasso.Picasso

class DetailedActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        var back_btn = findViewById<ImageButton>(R.id.back_btn)

        val name_event = intent.getStringExtra("name")
        val tv_name_event = findViewById<TextView>(R.id.EventName)
        tv_name_event.text = name_event

        val local_event = intent.getStringExtra("local")
        val tv_local_event = findViewById<TextView>(R.id.EventLocal)
        tv_local_event.text = local_event

        val genre_event = intent.getStringExtra("genre")
        val tv_genre_event = findViewById<TextView>(R.id.EventGenre)
        tv_genre_event.text = genre_event


        val sub_genre_event = intent.getStringExtra("subGenre")
        val tv_sub_genre_event = findViewById<TextView>(R.id.EventSubGenre)
        tv_sub_genre_event.text = sub_genre_event


        val type_event = intent.getStringExtra("type")
        val tv_type_event = findViewById<TextView>(R.id.EventType)
        tv_type_event.text = type_event



        val sub_type_event = intent.getStringExtra("subType")
        val tv_sub_type_event = findViewById<TextView>(R.id.EventSubType)
        tv_sub_type_event.text = sub_type_event


        val photo_event = intent.getStringExtra("photo")
        val iv_photo_event = findViewById<ImageView>(R.id.image)
        Picasso.get().load(photo_event).fit().into(iv_photo_event)

        Log.println(Log.ASSERT,"======>Intent",name_event.toString())

    back_btn.setOnClickListener {
        var intent1 = Intent(this,MainActivity::class.java)
        startActivity(intent1)
    }
         val ratingBar=findViewById<RatingBar>(R.id.RatingBr)
        val button= findViewById<Button>(R.id.btn)

        ratingBar.onRatingBarChangeListener= RatingBar.OnRatingBarChangeListener {
                _, rating, _ ->

        }


    }



}