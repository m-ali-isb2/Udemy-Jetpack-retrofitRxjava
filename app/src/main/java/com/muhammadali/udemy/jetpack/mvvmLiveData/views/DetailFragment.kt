package com.muhammadali.udemy.jetpack.mvvmLiveData.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.muhammadali.udemy.jetpack.mvvmLiveData.R
import kotlinx.android.synthetic.main.fragment_detail.*


/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {
    var dogUuid = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //retrieving Argument
        arguments?.let {
            dogUuid = DetailFragmentArgs.fromBundle(it).dogUuid
            detailText.text = dogUuid.toString()

        }

        buttonList.setOnClickListener {
            val action: NavDirections =
                DetailFragmentDirections.actionDetailFragmentToListFragment()
            Navigation.findNavController(it).navigate(action)

        }
    }

}
