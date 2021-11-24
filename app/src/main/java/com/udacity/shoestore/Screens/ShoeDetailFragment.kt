package com.udacity.shoestore.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailFragment : Fragment() {
private lateinit var binding:FragmentShoeDetailBinding
private lateinit var viewModel:ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail,container,false)
        activity.let {
            viewModel=ViewModelProvider(it!!).get(ShoeViewModel::class.java)

        }
        viewModel.resetDetails()
        binding.shoeDetail=viewModel
        binding.saveBtn.setOnClickListener {
            viewModel.addToShoeList()
            Navigation.findNavController(it).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        binding.cancelBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
       return binding.root
    }




}