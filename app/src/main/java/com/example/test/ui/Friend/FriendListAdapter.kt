package com.example.test.ui.Friend


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.ui.board.BoardModel

class FriendListAdapter(private val items: ArrayList<FriendModel>) : RecyclerView.Adapter<FriendListAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FriendListAdapter.ViewHolder, position: Int) {
        holder.name!!.text = items[position].nickname // title부분의 값은 boardList의 position의 값에 title 값을 가져와라

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.friend_list_item, parent, false)
        return FriendListAdapter.ViewHolder(inflatedView)
    }

    // 각 항목에 필요한 기능을 구현
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v

        // 각각 해당하는 데이터에 매핑
        val name = view?.findViewById<TextView>(R.id.friendnicknameArea)
    }
}
