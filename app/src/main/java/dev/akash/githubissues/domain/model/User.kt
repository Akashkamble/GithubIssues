package dev.akash.githubissues.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val userName: String,
    val avatarUrl: String
) : Parcelable