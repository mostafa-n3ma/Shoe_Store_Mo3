package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.models.ShoeViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {
private lateinit var binding:ActivityMainBinding
private lateinit var viewModel: ShoeViewModel
private lateinit var appBarConfigration:AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        val navController=this.findNavController(R.id.nav_host_fragment)

        //build a new AppBarConfiguration for
        // logingFragment and shoeListFragment  with out the up button
        appBarConfigration= AppBarConfiguration.Builder(
            R.id.logingFragment,
            R.id.shoeListFragment
        ).build()


        NavigationUI.setupActionBarWithNavController(this, navController,appBarConfigration)
        viewModel=ViewModelProvider(this).get(ShoeViewModel::class.java)
        appBarConfigration= AppBarConfiguration(navController.graph,null)

    }


    override fun onSupportNavigateUp(): Boolean {
        val navController=this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }
}
