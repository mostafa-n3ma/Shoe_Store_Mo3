package com.udacity.shoestore.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {
private lateinit var binding:FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(
            inflater,R.layout.fragment_sign_up,container,false
        )

        binding.crreateAccountBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_signUpFragment_to_welcomFragment)
        }


        return binding.root
    }

}