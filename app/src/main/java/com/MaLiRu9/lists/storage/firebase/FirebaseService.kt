package com.MaLiRu9.lists.storage.firebase

import android.content.Context
import com.MaLiRu9.lists.R
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase

class FirebaseService(val context: Context) {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    lateinit var oneTapClient: SignInClient
    lateinit var signInRequest: BeginSignInRequest

    init {
        signIn()
        auth = Firebase.auth
    }

    private fun signIn() {
        oneTapClient = Identity.getSignInClient(context)
        signInRequest = BeginSignInRequest.builder()
            .setPasswordRequestOptions(
                BeginSignInRequest.PasswordRequestOptions.builder()
                    .setSupported(true)
                    .build()
            )
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(context.getString(R.string.firebase_id))
                    .setFilterByAuthorizedAccounts(true)
                    .build()
            )
            .setAutoSelectEnabled(true)
            .build()

        //oneTapClient.beginSignIn((signInRequest))
    }
}
