package com.example.test.ui.board

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.test.R
import com.example.test.ui.Friend.FriendActivity


class MainActivity : AppCompatActivity() {

    lateinit var menu_friend : ImageView
    lateinit var main_write : ImageView
    lateinit var myEmail : String

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        menu_friend =  findViewById<ImageView>(R.id.menu_friend)
        myEmail = intent.getStringExtra("userEmail").toString()

        main_write = findViewById<ImageView>(R.id.board_write)
        super.onCreate(savedInstanceState)

        menu_friend.setOnClickListener{
            var intent  = Intent(this, FriendActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        main_write.setOnClickListener {
            var intent = Intent(this, BoardWriteActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
    }
}