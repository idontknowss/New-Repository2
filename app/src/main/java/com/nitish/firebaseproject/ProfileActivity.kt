package com.nitish.firebaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nitish.firebaseproject.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_profile)
        val sharedPreferences=getSharedPreferences("lohinsihn", MODE_PRIVATE)
        val username=sharedPreferences.getString("username"," ")
        binding.usernames.setText(username)

    }
}