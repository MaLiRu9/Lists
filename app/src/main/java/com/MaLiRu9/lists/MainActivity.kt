package com.MaLiRu9.lists

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.MaLiRu9.lists.list.ListActivity
import com.MaLiRu9.lists.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: Check configuration and pass parameters to Login Activity if necessary
        val isLogged = false
        if (isLogged) {
            startActivity(Intent(this, ListActivity::class.java).apply { })
        } else {
            //TODO: Is firebase or local?
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("isLocal", false)
            startActivity(intent)
        }
    }
    }
}