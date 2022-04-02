package com.nitish.firebaseproject

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.nitish.firebaseproject.databinding.ActivityMainBinding
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityMainBinding
    lateinit var users: Users
    private lateinit var googleSignInClient: GoogleSignInClient
    private val pickImage = 100
    private var imageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)



        binding.loginbtn.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }
//hello
        }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            binding.imageView.setImageURI(imageUri)
        }


//        auth= Firebase.auth
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken("593862035537-07tchoqfoi890hv484epp408n9okkt40.apps.googleusercontent.com")
//                .requestEmail()
//                .build()
//        googleSignInClient = GoogleSignIn.getClient(this, gso)
//        binding.signinwithgoogle.setOnClickListener {
////            signIn()
//        }
//        binding.loginbtn.setOnClickListener {
//            createAccount(binding.userid.text.toString(),binding.password.text.toString())
//        }
    }
//    override fun onStart() {
//        super.onStart()
//        val currentUser=auth.currentUser
//        updateUI(currentUser)
//    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//    val REQUEST_CODE = 100
//        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
//            binding.imageView.setImageURI(data?.data) // handle chosen image
//        }
//    }
////    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
////        super.onActivityResult(requestCode, resultCode, data)
////
////        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
////        if (requestCode == RC_SIGN_IN) {
////            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
////            try {
////                // Google Sign In was successful, authenticate with Firebase
////                val account = task.getResult(ApiException::class.java)!!
////                Log.d(TAG1, "firebaseAuthWithGoogle:" + account.id)
////                firebaseAuthWithGoogle(account.idToken!!)
////            } catch (e: ApiException) {
////                // Google Sign In failed, update UI appropriately
////                Log.w(TAG1, "Google sign in failed", e)
////            }
////        }
////    }
////    // [END onactivityresult]
////
////    // [START auth_with_google]
////    private fun firebaseAuthWithGoogle(idToken: String) {
////        val credential = GoogleAuthProvider.getCredential(idToken, null)
////        auth.signInWithCredential(credential)
////            .addOnCompleteListener(this) { task ->
////                if (task.isSuccessful) {
////                    // Sign in success, update UI with the signed-in user's information
////                    Log.d(TAG1, "signInWithCredential:success")
////                    val user = auth.currentUser
////                    updateUI(user)
////                    val intent=Intent(this,ProfileActivity::class.java)
////                    startActivity(intent)
////                } else {
////                    // If sign in fails, display a message to the user.
////                    Log.w(TAG1, "signInWithCredential:failure", task.exception)
////                    updateUI(null)
////                }
////            }
////    }
////    // [END auth_with_google]
////
////    // [START signin]
////    private fun signIn() {
////        val signInIntent = googleSignInClient.signInIntent
////        startActivityForResult(signInIntent, RC_SIGN_IN)
////    }
////    private fun createAccount(email: String, password: String) {
////        // [START create_user_with_email]
////        auth.createUserWithEmailAndPassword(email, password)
////            .addOnCompleteListener(this) { task ->
////                if (task.isSuccessful) {
////                    // Sign in success, update UI with the signed-in user's information
////                    val database = Firebase.database
////                    val myRef = database.getReference("users")
////                    myRef.push().setValue(Users(binding.userid.text.toString(),binding.password.text.toString()))
////                    Log.d(TAG, "createUserWithEmail:success")
////                    val user = auth.currentUser
////                    val sharedPreferences=getSharedPreferences("lohinsihn", MODE_PRIVATE)
////                    val editor=sharedPreferences.edit()
////                    editor.putString("username",binding.userid.text.toString())
////                    editor.apply()
////                    val intent=Intent(this,ProfileActivity::class.java)
////                    startActivity(intent)
////                    updateUI(user)
////                } else {
////                    // If sign in fails, display a message to the user.
////                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
////                    Toast.makeText(baseContext, "Authentication failed.",
////                        Toast.LENGTH_SHORT).show()
////                    updateUI(null)
////                }
////            }
////        // [END create_user_with_email]
////    }
////
////    private fun updateUI(user: FirebaseUser?) {
////
////    }
////
////    companion object {
////        private const val TAG = "AnonymousAuth"
////        private const val TAG1 = "GoogleActivity"
////        private const val RC_SIGN_IN = 9001
////    }
//    private fun openGalleryForImage() {
//         val REQUEST_CODE = 100
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        startActivityForResult(intent, REQUEST_CODE)
//    }
}