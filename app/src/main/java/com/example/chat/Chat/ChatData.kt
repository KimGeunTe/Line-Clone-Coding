package com.example.chat.Chat

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChatData(
    val profileImageView: Int = 0,
    val ChatTextView:String ="",
    val TimeTextView:Long = 0
): Parcelable
