package com.zharfan.kalkulatorzed.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zharfan.kalkulatorzed.R
import com.zharfan.kalkulatorzed.databinding.ActivityMainBinding
import com.zharfan.kalkulatorzed.fragment.CalculatorHomeFragment

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
        val mHomeFragment = CalculatorHomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(CalculatorHomeFragment::class.java.simpleName)


        if (fragment !is  CalculatorHomeFragment){
            mFragmentManager.beginTransaction()
                .add(R.id.frameContainer,mHomeFragment,CalculatorHomeFragment::class.java.simpleName)
                .commit()
        }
    }
}