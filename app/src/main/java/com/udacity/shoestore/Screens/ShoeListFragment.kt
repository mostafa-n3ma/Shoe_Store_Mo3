package com.udacity.shoestore.Screens

import android.os.Bundle
import android.util.TypedValue
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeListFragment : Fragment() {
private lateinit var binding:FragmentShoeListBinding
private lateinit var viewModel:ShoeViewModel
private lateinit var shoeListFinal:MutableList<Shoe>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       binding=DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,container,false)
        activity.let {
            viewModel=ViewModelProvider(it!!).get(ShoeViewModel::class.java)

        }
        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            inflateShoeListItems(it)
        })

        binding.flotingBtn.setOnClickListener {
           Navigation.findNavController(it).navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        setHasOptionsMenu(true)


















       return binding.root
    }
    fun inflateShoeListItems(shoelist:MutableList<Shoe>){
        for (shoe in shoelist){
            //linearlayout
            val mylinearlayout:LinearLayout= LinearLayout(this.activity)
            var params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8,8,8,8)
            mylinearlayout.layoutParams=params
            mylinearlayout.orientation=LinearLayout.VERTICAL
            mylinearlayout.setBackgroundColor(resources.getColor(R.color.linearColor))
            //shoeName
            mylinearlayout.addView(createTextView(shoe.name,24F))
            //shoe size
            mylinearlayout.addView(createTextView(shoe.size.toString(),18F))
            //company
            mylinearlayout.addView(createTextView(shoe.company ,16F))
            //description
            mylinearlayout.addView(createTextView(shoe.description,16F))
            binding.mainLinear.addView(mylinearlayout)
        }
    }

private fun createTextView(txt:String, size:Float):View{
    val textView:TextView= TextView(this.activity)
    var text_params=LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )
    textView.layoutParams=text_params
    textView.text=txt
    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,size)
    return textView
}

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, requireView().findNavController())
                ||super.onOptionsItemSelected(item)

    }
}

