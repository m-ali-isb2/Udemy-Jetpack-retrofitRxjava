package com.muhammadali.udemy.jetpack.mvvmLiveData.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadali.udemy.jetpack.mvvmLiveData.R
import com.muhammadali.udemy.jetpack.mvvmLiveData.model.DogBreed
import kotlinx.android.synthetic.main.item_dog.view.*

/**
 * Created by Muhammad Ali on 29-Apr-20.
 * Email muhammad.ali9385@gmail.com
 */
class DogListAdapter(val dogBreedList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogListAdapter.DogViewHolder>() {


    class DogViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount(): Int = dogBreedList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.name.text = dogBreedList.get(position).breed
        holder.view.body.text = dogBreedList.get(position).lifespan
    }

    fun updateDogList(dogBreedList: ArrayList<DogBreed>) {
        this.dogBreedList.clear()
        this.dogBreedList.addAll(dogBreedList)
        notifyDataSetChanged()
    }
}