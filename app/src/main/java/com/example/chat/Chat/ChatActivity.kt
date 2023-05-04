package com.example.chat.Chat

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chat.Friend.FriendData
import com.example.chat.R
import com.example.chat.Talk
import com.example.chat.databinding.ChatProItemBinding
import com.example.chat.databinding.LeftBalloonItemBinding
import kotlin.collections.ArrayList

class ChatActivity : AppCompatActivity(), TextWatcher {

    // 변수
    private lateinit var name: LeftBalloonItemBinding
    private lateinit var binding: ChatProItemBinding
    lateinit var chatAdapter: ChatAdapter
    var FriendItems: MutableList<FriendData> = ArrayList()
    var changeType = false
    var s= ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.chat_pro_item)
        binding.chatEditText.addTextChangedListener(this)

        // 전송버튼
        binding.sendButton.setOnClickListener{
            submitTalk()
        }

        // 채팅방 이름 변경
        FriendItems = intent.getParcelableArrayListExtra<FriendData>("Frienditems") as ArrayList
        var position = intent.getIntExtra("nameTextView", 0)
        binding.chatRoomNameTextView.setText(FriendItems[position].nameTextView)


        // 어뎁터 연결
        chatAdapter = ChatAdapter()
        binding.chatRecyclerView.adapter = chatAdapter
        binding.chatRecyclerView.setHasFixedSize(false)
        binding.chatRecyclerView.layoutManager = LinearLayoutManager(applicationContext)


        // 카메라 버튼
        binding.cameraButton.setOnClickListener{
            cameraButton()
        }

        // 갤러리 버튼
        binding.galleryButton.setOnClickListener{
            onImageSelectButtonClick()
        }
    }


    // 카메라 권한
    fun cameraButton() {
        binding.cameraButton.setOnClickListener {
            val cameraPermissionCheck = ContextCompat.checkSelfPermission(
                this@ChatActivity,
                android.Manifest.permission.CAMERA
            )
            if (cameraPermissionCheck != PackageManager.PERMISSION_GRANTED) { // 권한이 없는 경우
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    1000
                )
            } else { //권한이 있는 경우
                val REQUEST_IMAGE_CAPTURE = 1
                Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                    takePictureIntent.resolveActivity(packageManager)?.also {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                    }
                }
            }
        }
    }

    companion object {
        const val REQUEST_CODE_SELECT_IMAGE = 1000
    }

    /// 이미지 선택 버튼 클릭 이벤트 핸들러
    private fun onImageSelectButtonClick() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE)
    }

    override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
        this.s = s.toString()
    }

    override fun afterTextChanged(s: Editable?) {

    }
    fun submitTalk() {
        val talk = if (changeType) {
            Talk(s, "right")
        } else {
            Talk(s, "left")
        }

        chatAdapter.addItem(talk)
        binding.chatRecyclerView.smoothScrollToPosition(chatAdapter.lst.size-1)
        chatAdapter.notifyItemChanged(chatAdapter.lst.size-1)
        changeType = !changeType
        binding.chatEditText.text = null
    }


}