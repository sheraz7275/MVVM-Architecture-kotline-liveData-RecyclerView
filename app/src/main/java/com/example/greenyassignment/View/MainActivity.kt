package com.example.greenyassignment.View

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.greenyassignment.model.DataModelCountries
import com.example.greenyassignment.R
import kotlinx.android.synthetic.main.activity_main.*
import com.example.greenyassignment.ViewModel.CountriesViewModel as mViewModel1

class MainActivity : AppCompatActivity() {


    private  var dataListCountries: ArrayList<DataModelCountries> = ArrayList()

    private lateinit var recyclerView:RecyclerView
    private lateinit var mViewModel: mViewModel1
    private lateinit var adapter: AdapterCountries


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //initializing view model
        mViewModel =ViewModelProviders.of(this).get(mViewModel1::class.java)



        setRecyclerView()
















    }

    //initializing of Recyclerview and setting up adapter
    private fun setRecyclerView(){

        recyclerView=recCountries

        recyclerView.layoutManager=LinearLayoutManager(this)

        adapter= AdapterCountries(dataListCountries)

        recyclerView.adapter=adapter

    }


    // subscribing call back observer of live data

    private fun subscribeDataCallBack() {

        mViewModel.getListData().observe(this, Observer<ArrayList<DataModelCountries>> {

            if (it != null) {

             dataListCountries=it


                adapter.setUpList(dataListCountries)

                adapter.notifyDataSetChanged()



            }

        })




    }



    // Just onClick view of text

    fun GetData(view: View) {
        view.visibility=View.GONE
        subscribeDataCallBack()

    }
}