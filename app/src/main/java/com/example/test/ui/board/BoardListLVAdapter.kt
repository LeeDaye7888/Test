package com.example.test.ui.board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
class BoardListLVAdapter(private val items: ArrayList<BoardModel>) : RecyclerView.Adapter<BoardListLVAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BoardListLVAdapter.ViewHolder, position: Int) {
        holder.title!!.text = items[position].title // title부분의 값은 boardList의 position의 값에 title 값을 가져와라
        holder.content!!.text = items[position].content
        holder.time!!.text = items[position].time

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.board_list_item, parent, false)
        return BoardListLVAdapter.ViewHolder(inflatedView)
    }

    // 각 항목에 필요한 기능을 구현
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v

        // 각각 해당하는 데이터에 매핑
        val title = view?.findViewById<TextView>(R.id.titleArea)
        val content = view?.findViewById<TextView>(R.id.contentArea)
        val time = view?.findViewById<TextView>(R.id.timeArea)

    }
}


//class BoardListLVAdapter(val boardList : MutableList<BoardModel>) : BaseAdapter() {
//    override fun getCount(): Int {
//        return boardList.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return boardList[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//
//        var convertView = convertView
//        if(convertView == null) {
//            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.board_list_item, parent,false)
//        }
//        // 각각 해당하는 데이터에 매핑
//        val title = convertView?.findViewById<TextView>(R.id.titleArea)
//        val content = convertView?.findViewById<TextView>(R.id.contentArea)
//        val time = convertView?.findViewById<TextView>(R.id.timeArea)
//
//        title!!.text = boardList[position].title // title부분의 값은 boardList의 position의 값에 title 값을 가져와라
//        content!!.text = boardList[position].content
//        time!!.text = boardList[position].time
//        return convertView!!
//    }
//}