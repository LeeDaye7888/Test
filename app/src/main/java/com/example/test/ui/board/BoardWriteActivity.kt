package com.example.test.ui.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.test.R
import com.example.test.utils.Auth
import com.example.test.utils.Ref


class BoardWriteActivity : AppCompatActivity() {

    lateinit var writebtn : Button
    lateinit var titlearea : EditText
    lateinit var contentarea : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        // setContentView(R.layout.activity_board_write)
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_board_write)
        writebtn = findViewById<Button>(R.id.writeBtn)
        titlearea = findViewById<EditText>(R.id.titleArea)
        contentarea = findViewById<EditText>(R.id.contentArea)


        writebtn.setOnClickListener {
            val title = titlearea.text.toString()
            val content = contentarea.text.toString()
            val uid = Auth.getUid()
            val time = Auth.getTime()

            // 데이터 구조
            // board
            //  - key
            //      - boardModel(title, content, uid, time)
            Ref.boardRef
                .push() // 랜덤값 생성
                .setValue(BoardModel(title, content, "uid", "time"))

            Toast.makeText(this, "게시물 등록 완료", Toast.LENGTH_LONG).show()
        }
    }

}