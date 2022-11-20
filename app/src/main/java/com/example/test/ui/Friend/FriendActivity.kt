package com.example.test.ui.Friend

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.test.R
import com.example.test.ui.board.MainActivity


class FriendActivity : AppCompatActivity() {

    lateinit var menu_board : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_friend)
        menu_board =  findViewById<ImageView>(R.id.menu_board)
        super.onCreate(savedInstanceState)

        menu_board.setOnClickListener({
            var intent  = Intent(this, MainActivity::class.java) // 메인액티비티로
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION) // 자연스럽게 전환
            startActivity(intent)
        })

    }
}








