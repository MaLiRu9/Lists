package com.MaLiRu9.lists

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.MaLiRu9.lists.list.ListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, ListActivity::class.java).apply {
            Log.d("Debug", "Starting List Activity")
        }
        startActivity(intent)
    }
}