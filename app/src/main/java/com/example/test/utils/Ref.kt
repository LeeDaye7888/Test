package com.example.test.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Ref {

    companion object {
        private val database = Firebase.database

        val category1 = database.getReference("contents")
        val category2 = database.getReference("contents2")

        val boardRef = database.getReference("board")

    }
}