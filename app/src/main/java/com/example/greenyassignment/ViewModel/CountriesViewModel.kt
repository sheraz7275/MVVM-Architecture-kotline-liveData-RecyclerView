package com.example.greenyassignment.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.greenyassignment.model.DataModelCountries
import com.example.greenyassignment.repository.DataRepository

class CountriesViewModel(application: Application) : AndroidViewModel(application) {


    private var mDataRepository: DataRepository = DataRepository(application)

    init {
        mDataRepository.getAPIData()
   }









    //getting parsed formatted data

    fun getListData():MutableLiveData<ArrayList<DataModelCountries>>{





        return mDataRepository.jsonParsing()
    }





}