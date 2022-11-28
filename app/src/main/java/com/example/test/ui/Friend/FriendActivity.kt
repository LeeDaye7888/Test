package com.example.test.ui.Friend

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.ui.board.BoardListLVAdapter
import com.example.test.ui.board.BoardModel
import com.example.test.ui.board.MainActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class FriendActivity : AppCompatActivity() {

    lateinit var menu_board : ImageView
    lateinit var friendRVAdapter : FriendListAdapter
    private val friendDataList = ArrayList<FriendModel>() // 데이터 담아놓을 곳
    private val TAG = MainActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_friend)
        menu_board =  findViewById<ImageView>(R.id.menu_board)
        super.onCreate(savedInstanceState)

        var friendLV = findViewById<RecyclerView>(R.id.friendListView)

        //        val boardList = mutableListOf<BoardModel>()
        friendRVAdapter =  FriendListAdapter(friendDataList)
        friendLV.adapter = friendRVAdapter
        val layoutManager = LinearLayoutManager(this)
        friendLV.layoutManager = layoutManager

        menu_board.setOnClickListener({
            var intent  = Intent(this, MainActivity::class.java) // 메인액티비티로
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION) // 자연스럽게 전환
            startActivity(intent)
            finish()
        })
        getFBFriendData()
    }

    // 파이어베이스에서 데이터 받아오는 부분
    private fun getFBFriendData() {
        val database = Firebase.database
        val myRef = database.getReference("mynickname")

        // Read from the database
        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                friendDataList.clear()

                val value = snapshot.getValue()
                Log.d(TAG, "Value is: " + value)

                for (dataModel in snapshot.children) {
                    Log.d(TAG, dataModel.toString())
                    val item = dataModel.getValue(FriendModel::class.java) // 데이터 받아오는 부분
                    friendDataList.add(item!!)
                }
                friendRVAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })


    }
}








