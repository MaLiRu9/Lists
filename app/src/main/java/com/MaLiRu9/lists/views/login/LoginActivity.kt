package com.MaLiRu9.lists.views.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.MaLiRu9.lists.R
import com.MaLiRu9.lists.databinding.ActivityLoginBinding
import com.MaLiRu9.lists.firebase.FirebaseService
import com.MaLiRu9.lists.login.LoginFormFragment
import com.google.android.gms.common.api.ApiException
import menu.MenuHandler

class LoginActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityLoginBinding
    private val binding get() = _binding
    private val REQ_ONE_TAP = 1
    private var showOneTapUI = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initFirebase()

        val firebaseService = FirebaseService(this)

        var resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                try {
                    val credential =
                        firebaseService.oneTapClient.getSignInCredentialFromIntent(result.data)
                    val idToken = credential.googleIdToken
                    Log.d("Debug", "TOKEN: " + idToken.toString())
                } catch (e: ApiException) {
                    Log.d("Error", e.message.toString())
                }
            } else {
                Log.d("Debug", "CODE: " + result.resultCode)
            }
        }

    }

    //Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var menuHandler = MenuHandler(this, "login")
        menuHandler.itemHandler(item)
        if (menuHandler.intent != null) {
            startActivity(menuHandler.intent)
        }
        return super.onOptionsItemSelected(item)
    }

    //Firebase
    private fun initFirebase() {
        val firebaseService = FirebaseService(this)
    }
}