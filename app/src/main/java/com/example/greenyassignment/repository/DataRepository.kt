package com.example.greenyassignment.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.greenyassignment.model.DataModelCountries
import org.json.JSONArray
import org.json.JSONObject

class DataRepository{

    private var requestQueue: RequestQueue? = null

    private  var application:Application
    private  var dataListCountries:ArrayList<DataModelCountries> = ArrayList()
    var mResponse:String?=null

    constructor(mApplication: Application){

        this.application=mApplication
    }



    // volley Network call
    fun getAPIData() {

         // Instantiate the RequestQueue.
         var stringReq:StringRequest?=null
         val queue = Volley.newRequestQueue(application.baseContext)
         val url: String = "https://restcountries.eu/rest/v2/all"

         // Request a string response from the provided URL.
         stringReq = StringRequest(
             Request.Method.GET, url,
             Response.Listener<String> { response ->



                 mResponse=response.toString()

             },
             Response.ErrorListener {  })
         queue.add(stringReq)



    }


    //json parsing of data
   fun jsonParsing():MutableLiveData<ArrayList<DataModelCountries>>{



        var countryName: String? =null
        var countryCapital:String? =null
        var countryRegion:String? =null
        var mutableLiveData: MutableLiveData<ArrayList<DataModelCountries>> = MutableLiveData()


        var jsonArray: JSONArray = JSONArray(mResponse)
        for (items in 0 until jsonArray.length()) {

            val jsonObj: JSONObject = jsonArray.getJSONObject(items)
            countryName = jsonObj.getString("name")
            countryCapital = jsonObj.getString("capital")
            countryRegion = jsonObj.getString("region")
            dataListCountries.add(
                DataModelCountries(
                    countryName,
                    countryCapital,
                    countryRegion
                )
            )

            mutableLiveData.postValue(dataListCountries)


        }


        return mutableLiveData

    }






}