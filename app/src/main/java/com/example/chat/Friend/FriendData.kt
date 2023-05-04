package com.example.chat.Friend

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FriendData(
    var profileImageView: Int = 0,  // 이미지 profileImageView
    var nameTextView: String = "", // 이름 nameTextView
    var stateMassageTextView: String = "", // 상태메세지 stateMassageTextView
): Parcelable