package com.example.karteblok

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import com.example.karteblok.about.AboutActivity
import com.example.karteblok.bela.BelaTableActivity
import com.example.karteblok.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.aboutButton.setOnClickListener {
            this.startActivity(Intent(this, AboutActivity::class.java))
        }

        binding.belaButton.setOnClickListener {
            this.startActivity(Intent(this, BelaTableActivity::class.java))
        }

        //Status bar color set-up
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        val color = ColorUtils.setAlphaComponent(getColor(R.color.surface_1_white), 216)
        window.statusBarColor = color
    }
}