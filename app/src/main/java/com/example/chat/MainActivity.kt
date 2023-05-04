package com.example.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chat.Friend.FriendAdapter
import com.example.chat.Friend.FriendData
import com.example.chat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var items: ArrayList<FriendData>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        items = ArrayList<FriendData>().apply {
            add(FriendData(R.drawable.porimg1, "노윤서", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg1, "박서준", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg1, "제니", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg1, "정우성", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg2, "수지", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg1, "노윤서", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg2, "박서준", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg2, "제니", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg4, "정우성", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg1, "수지", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg1, "정우성", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg2, "수지", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg1, "노윤서", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg2, "박서준", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg2, "제니", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg4, "정우성", "오늘도 즐거운 하루"))
            add(FriendData(R.drawable.porimg1, "수지", "오늘도 즐거운 하루"))
        }
        binding.HomeRecyclerview.layoutManager = LinearLayoutManager(applicationContext)
        var articleAdapter = FriendAdapter(this, ArrayList(items))
        binding.HomeRecyclerview.adapter = articleAdapter

        articleAdapter.setData(items)
    }


}