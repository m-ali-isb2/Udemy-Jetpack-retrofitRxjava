package com.muhammadali.udemy.jetpack.mvvmLiveData.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadali.udemy.jetpack.mvvmLiveData.R
import com.muhammadali.udemy.jetpack.mvvmLiveData.model.DogBreed
import com.muhammadali.udemy.jetpack.mvvmLiveData.viewModel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*


/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private val dogListAdapter = DogListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        dogsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dogListAdapter
        }

        obserceViewModel()
    }

    fun obserceViewModel() {
        viewModel.dogs.observe(viewLifecycleOwner, Observer {
            it?.let {
                dogsList.visibility = VISIBLE
                dogListAdapter.updateDogList(it as ArrayList<DogBreed>)
            }
        })
        viewModel.error.observe(viewLifecycleOwner, Observer {
            it?.let {
//                error.visibility = VISIBLE
                error.visibility = if(it) VISIBLE else GONE

            }
        })
        viewModel.loading.observe(viewLifecycleOwner, Observer {
            it?.let {
                progressBar.visibility = if(it) VISIBLE else GONE

                if(it){
                    error.visibility = GONE
                    dogsList.visibility = GONE
                }
            }
        })
    }


}
