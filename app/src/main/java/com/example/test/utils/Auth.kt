package com.example.test.utils

import com.google.firebase.auth.FirebaseAuth
import java.text.SimpleDateFormat
import java.util.*

class Auth {
    companion object {
        private lateinit var auth : FirebaseAuth

        fun getUid() : String {
            auth = FirebaseAuth.getInstance()

            return auth.currentUser?.uid.toString()
        }

        fun getTime() : String {
            val currenDataTime = Calendar.getInstance().time // 시간 가져오기
            val dateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA).format(currenDataTime) // 어떤 포멧 형태로 가져오냐

            return dateFormat
        }
    }
}