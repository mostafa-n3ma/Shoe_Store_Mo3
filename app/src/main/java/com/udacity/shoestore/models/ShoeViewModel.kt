package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {


    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList

     val shoeName=MutableLiveData<String>()
     val company=MutableLiveData<String>()
     val shoeSize=MutableLiveData<String>()
     val description=MutableLiveData<String>()

    private val _eventResetDetails=MutableLiveData<Boolean>()
    val eventResetDetails:LiveData<Boolean>get() = _eventResetDetails


    init {
        initShoeList()
        _eventResetDetails.value=false
    }

    fun initShoeList() {
        var shoeList:MutableList<Shoe> = mutableListOf()
        _shoeList.value=shoeList

    }
    fun addToShoeList(){
        val shoe:Shoe= Shoe(shoeName.value.toString(),
            shoeSize.value!!.toDouble(),company.value.toString(),description.value.toString(),
            listOf("1","2"))
      _shoeList.value!!.add(shoe)
        onDetailsFinished()
    }

    fun onDetailsFinished(){
        _eventResetDetails.value=false
    }
    fun resetDetails(){
        shoeName.value=""
        shoeSize.value=""
        company.value=""
        description.value=""
    }

}