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
        var shoeList:MutableList<Shoe>
        val shoe1:Shoe= Shoe("classic snickers",42.0,"Nike","nice shoe", listOf("1","2") )
        val shoe2:Shoe= Shoe("Golf shoes",38.0,"puma","nice shoe2",listOf("3","4") )
        val shoe3:Shoe= Shoe("Running shoes",29.0,"adidas","nice shoe3",listOf("3","4") )
        shoeList= mutableListOf(shoe1,shoe2,shoe3)
        _shoeList.value=shoeList

    }
    fun addToShoeList(){
        val shoe:Shoe= Shoe(shoeName.value.toString(),
            shoeSize.value!!.toDouble(),company.value.toString(),description.value.toString(),
            listOf("1","2"))
        var shoeList:MutableList<Shoe>
        shoeList=_shoeList.value as MutableList<Shoe>
        shoeList.add(shoe)
        _shoeList.value=shoeList
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