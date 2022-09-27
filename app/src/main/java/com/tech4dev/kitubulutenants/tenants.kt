package com.tech4dev.kitubulutenants

import android.os.Parcel
import android.os.Parcelable

data class Tenants(
    val ID: String?,

    val NAME: String?,

    val AMOUNT: String?,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(ID)
        parcel.writeString(NAME)
        parcel.writeString(AMOUNT)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tenants> {
        override fun createFromParcel(parcel: Parcel): Tenants {
            return Tenants(parcel)
        }

        override fun newArray(size: Int): Array<Tenants?> {
            return arrayOfNulls(size)
        }
    }
}