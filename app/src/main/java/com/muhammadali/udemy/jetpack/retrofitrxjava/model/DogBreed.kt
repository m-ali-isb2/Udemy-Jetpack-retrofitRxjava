package com.muhammadali.udemy.jetpack.retrofitrxjava.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Muhammad Ali on 29-Apr-20.
 * Email muhammad.ali9385@gmail.com
 */
data class DogBreed(
    val id: String? = null,
    val breed: String? = null,
    val lifespan: String? = null,
    val breedGroup: String? = null,
    val temperament: String? = null,
    val image: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(breed)
        parcel.writeString(lifespan)
        parcel.writeString(breedGroup)
        parcel.writeString(temperament)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DogBreed> {
        override fun createFromParcel(parcel: Parcel): DogBreed {
            return DogBreed(parcel)
        }

        override fun newArray(size: Int): Array<DogBreed?> {
            return arrayOfNulls(size)
        }
    }
}