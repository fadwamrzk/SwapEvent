package com.example.swapevent.model.entity
import android.os.Parcelable

data class Event (//var id:String,
                  var name : String,
                  var type: String,
                  var locale: String,
                  //  var test: Boolean,
                  //  var url:String,
                    var dates:Date,
                    var classifications:List<Classification>,
                    var images: List<Images>,
                  var fovoris : Boolean
                  )
