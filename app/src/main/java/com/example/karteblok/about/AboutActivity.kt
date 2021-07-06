package com.example.karteblok.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import com.example.karteblok.R
import com.example.karteblok.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backArrow.setOnClickListener {
            this.finish()
        }

        //ImageView - GitHub link
        binding.githubLogo.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/tvrda34/CardsNotepads"))
            startActivity(browserIntent)
        }

        //status bar set-up -> color grey
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        val color = ColorUtils.setAlphaComponent(getColor(R.color.surface_1_white), 216)
        window.statusBarColor = color
    }
}