package com.example.test.ui.board

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.ui.Friend.FriendActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    lateinit var menu_friend : ImageView
    lateinit var menu_board : ImageView

    lateinit var main_write : ImageView
    lateinit var myEmail : String

    lateinit var boardRVAdapter : BoardListLVAdapter
    private val boardDataList = ArrayList<BoardModel>() // 데이터 담아놓을 곳
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        menu_friend =  findViewById<ImageView>(R.id.menu_friend)
        menu_board = findViewById<ImageView>(R.id.menu_board)
        myEmail = intent.getStringExtra("userEmail").toString()

        var boardLV = findViewById<RecyclerView>(R.id.boardListView)

        //        val boardList = mutableListOf<BoardModel>()
        boardRVAdapter =  BoardListLVAdapter(boardDataList)
        boardLV.adapter = boardRVAdapter
        val layoutManager = LinearLayoutManager(this)
        boardLV.layoutManager = layoutManager

        main_write = findViewById<ImageView>(R.id.board_write)
        super.onCreate(savedInstanceState)

        menu_friend.setOnClickListener{

            var intent  = Intent(this, FriendActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        }

        main_write.setOnClickListener {
            var intent = Intent(this, BoardWriteActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        getFBBoardData()
    }

    // 파이어베이스에서 데이터 받아오는 부분
    private fun getFBBoardData() {
        val database = Firebase.database
        val myRef = database.getReference("message")

        // Read from the database
        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                boardDataList.clear()

                val value = snapshot.getValue()
                Log.d(TAG, "Value is: " + value)

                for (dataModel in snapshot.children) {
                    Log.d(TAG, dataModel.toString())
                    val item = dataModel.getValue(BoardModel::class.java) // 데이터 받아오는 부분
                    boardDataList.add(item!!)
                }
                boardRVAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })


    }
}