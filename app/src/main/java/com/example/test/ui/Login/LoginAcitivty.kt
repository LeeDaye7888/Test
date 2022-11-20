package com.example.test.ui.board

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.test.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


class LoginAcitivty : AppCompatActivity() {

    lateinit var email: TextView
    lateinit var password: TextView
    lateinit var btn_login : Button

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        email = findViewById(R.id.editText_email)
        password = findViewById(R.id.editText_pw)
        btn_login = findViewById(R.id.btn_login)


        btn_login.setOnClickListener({
            signIn(email.text.toString(),password.text.toString())
//             createAccount(email.text.toString(), password.text.toString()) 회원가입
        })




//        ref.getBytes(Long.MAX_VALUE).addOnCompleteListener {
//            if(it.isSuccessful) {
//                val bmp = BitmapFactory.decodeByteArray(it.result, 0, it.result!!.size)
////                val imgView = findViewById<ImageView>(R.id.imageView)
////                imgView.setImageBitmap(bmp)
//            }
//        }

//        val remoteConfig = Firebase.remoteConfig
//        remoteConfig.setDefaultsAsync(R.xml.rc_defaults)
//        val settings = remoteConfigSettings {
//            minimumFetchIntervalInSeconds = 1
//        }
//        remoteConfig.setConfigSettingsAsync(settings)
//
//        remoteConfig.fetchAndActivate().addOnSuccessListener {
//            val season = remoteConfig.getString("season")
//            println("############## $season")
//        }


    }

    // 계정 생성
    private fun createAccount(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this, "계정 생성 완료",
                            Toast.LENGTH_SHORT
                        ).show()
                        signIn(email,password)
                    } else {
                        Toast.makeText(
                            this, "계정 생성 실패",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }

    // 로그인
    private fun signIn(email: String, password: String) {

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth?.signInWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            baseContext, "로그인 성공",
                            Toast.LENGTH_SHORT
                        ).show()

                        moveMainPage(auth?.currentUser?.email)
                    } else {
                        Toast.makeText(
                            baseContext, "로그인에 실패",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }

    // 메인으로 이동
    private fun moveMainPage(email: String?){
        var intent  = Intent(this, MainActivity::class.java)
        intent.putExtra("userEmail",email)
        startActivity(intent)
    }

}