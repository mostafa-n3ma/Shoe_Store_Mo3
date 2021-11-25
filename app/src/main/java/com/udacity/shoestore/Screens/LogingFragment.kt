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

        //check empty fields
        userViewModel.event_empty_field.observe(viewLifecycleOwner, Observer {
            if (it){
                Toast.makeText(this.activity,"please enter both email and password", Toast.LENGTH_SHORT).show()
            }
        })

        //check email
        userViewModel.event_wrong_email.observe(viewLifecycleOwner, Observer {
            if (it){
                Toast.makeText(this.activity,"Wrong email", Toast.LENGTH_SHORT).show()
            }
        })

        //check password
        userViewModel.event_wrong_password.observe(viewLifecycleOwner, Observer {
            if (it){
                Toast.makeText(this.activity,"Wrong password", Toast.LENGTH_SHORT).show()
            }
        })




        userViewModel.event_login_successfully.observe(viewLifecycleOwner, Observer {
            if (it){
                findNavController().navigate(R.id.action_logingFragment_to_welcomFragment)
                userViewModel.login_completed()
            }
        })
        Toast.makeText(this.activity,"email : mostafa.n3ma@gmail.com \n password: 12345",Toast.LENGTH_SHORT).show()
        binding.createAccountTextbtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_logingFragment_to_signUpFragment)
        }

        return binding.root
    }


}