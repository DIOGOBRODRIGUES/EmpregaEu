package com.example.empregaeu4

import android.os.Parcel
import android.os.Parcelable

class User(val primeiroNome: String?, val ultimoNome: String?, val idade: Int):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(primeiroNome)
        parcel.writeString(ultimoNome)
        parcel.writeInt(idade)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}