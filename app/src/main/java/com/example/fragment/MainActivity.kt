package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment.databinding.ActivityMainBinding
import com.example.fragment.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceWithFragment(Clock())
        binding.btnClock.setOnClickListener {
            replaceWithFragment(Clock())
        }
        binding.btnBanner.setOnClickListener {
            replaceWithFragment(Banner())
        }
        binding.btnValidate.setOnClickListener {
            replaceWithFragment(LoginFragment())
        }
    }

    private fun replaceWithFragment(frag: Fragment) {
        val fragManager = supportFragmentManager
        val fragTransaction = fragManager.beginTransaction()
        fragTransaction.replace(R.id.frameLayout,frag)
        fragTransaction.commit()
    }
}