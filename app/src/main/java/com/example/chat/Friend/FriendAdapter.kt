package com.example.chat.Friend

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chat.Chat.ChatActivity
import com.example.chat.Chat.ChatAdapter
import com.example.chat.databinding.FriendItemBinding

class FriendAdapter(val context: Context, val FriendItems: MutableList<FriendData>) :
    RecyclerView.Adapter<FriendAdapter.ViewHolder>() {
    private lateinit var binding: FriendItemBinding

    inner class ViewHolder(val binding: FriendItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(friendData: FriendData) {
            binding.profileImageView.setImageResource(friendData.profileImageView)
            binding.nameTextView.text = friendData.nameTextView
            binding.stateMassageTextView.text = friendData.stateMassageTextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = FriendItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = FriendItems[position]
        holder.bind(item)
        holder.binding.otherProfileLayout.setOnClickListener {
            val intent = Intent(context, ChatActivity::class.java)
            intent.putParcelableArrayListExtra("Frienditems",ArrayList(FriendItems))
            intent.putExtra("nameTextView", position)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return FriendItems.size
    }

    fun setData(newItems: ArrayList<FriendData>) {
        FriendItems.clear()
        FriendItems.addAll(newItems)
        notifyDataSetChanged()
    }
}
