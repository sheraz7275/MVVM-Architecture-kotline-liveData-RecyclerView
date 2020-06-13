package com.example.greenyassignment.View

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.greenyassignment.model.DataModelCountries
import com.example.greenyassignment.databinding.ItemBinding


class AdapterCountries(dataList: ArrayList<DataModelCountries> = ArrayList() ):RecyclerView.Adapter<AdapterCountries.viewHolderCountries>() {


    private var dataListCountries: ArrayList<DataModelCountries> = ArrayList()

    init {

        this.dataListCountries=dataList
    }


    fun setUpList(dataList: ArrayList<DataModelCountries> = ArrayList()){

        this.dataListCountries=dataList



    }




    override fun getItemCount(): Int {


        return dataListCountries.size
    }

    override fun onBindViewHolder(holder: viewHolderCountries, position: Int) {



        val appInfo = dataListCountries[position]
        (holder as viewHolderCountries).bind(appInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderCountries {

        val layoutInflater = LayoutInflater.from(parent.context)
        val applicationBinding = ItemBinding.inflate(layoutInflater, parent, false)

        return viewHolderCountries(applicationBinding)
    }




    class viewHolderCountries( itemBiding: ItemBinding): RecyclerView.ViewHolder(itemBiding.root) {


        private var mItemBinding:ItemBinding = itemBiding

        fun bind(appInfo: DataModelCountries) {
            mItemBinding.mDataModel = appInfo

        }

    }




}