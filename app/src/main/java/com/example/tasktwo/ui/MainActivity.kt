package com.example.tasktwo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.tasktwo.R
import com.example.tasktwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NavigationUI.setupWithNavController(binding.bm , Navigation.findNavController(this, R.id.fragmentContainerView))
        changeStatusBarColor()
    }

    private fun changeStatusBarColor() {
        val window = window
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.statusBarColor = ContextCompat.getColor(this, R.color.dark_blue)

        if (window != null) {
            WindowCompat.getInsetsController(window, window.decorView).apply { isAppearanceLightStatusBars = true }
        }
    }
}