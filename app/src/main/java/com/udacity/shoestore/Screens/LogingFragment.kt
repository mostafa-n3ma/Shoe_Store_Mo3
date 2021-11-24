package com.udacity.shoestore.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLogingBinding
import com.udacity.shoestore.models.UserViewModel

class LogingFragment : Fragment() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var binding:FragmentLogingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_loging,container,false)
        userViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        binding.bindingUser=userViewModel
        userViewModel.event_login_successfully.observe(viewLifecycleOwner, Observer {
            if (it){
                findNavController().navigate(R.id.action_logingFragment_to_welcomFragment)
                userViewModel.login_completed()
            }
        })

        binding.createAccountTextbtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_logingFragment_to_signUpFragment)
        }

        return binding.root
    }


}