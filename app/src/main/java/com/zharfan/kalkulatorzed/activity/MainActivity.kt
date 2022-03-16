package com.zharfan.kalkulatorzed.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zharfan.kalkulatorzed.R
import com.zharfan.kalkulatorzed.databinding.ActivityMainBinding
import com.zharfan.kalkulatorzed.fragment.OnCalculatorClickListenerHomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showHomeFragment()
        supportActionBar?.hide()
    }

    private fun showHomeFragment() {
        val mFragmentManager = supportFragmentManager
        val mHomeFragment = OnCalculatorClickListenerHomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(OnCalculatorClickListenerHomeFragment::class.java.simpleName)

        if (fragment !is  OnCalculatorClickListenerHomeFragment){
            mFragmentManager.beginTransaction()
                .add(R.id.frameContainer,mHomeFragment,OnCalculatorClickListenerHomeFragment::class.java.simpleName)
                .commit()
        }
    }
}