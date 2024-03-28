package com.dicoding.aplikasiandroidsederhana
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Component(
    val name: String,
    val description: String,
    val photo: Int
): Parcelable
