package com.example.karteblok.bela.entry

import android.os.Bundle
import android.text.InputType
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import com.example.karteblok.R
import com.example.karteblok.databinding.ActivityBelaEntryBinding

class BelaEntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBelaEntryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivityBelaEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //save button
        binding.enterButton.setOnClickListener {
            this.finish()
        }

        //cancel button
        binding.cancelButton.setOnClickListener {
            this.finish()
        }

        //
        binding.team1Entry.inputType = InputType.TYPE_NULL

        //Status bar color set-up
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        val color = ColorUtils.setAlphaComponent(getColor(R.color.surface_1_white), 216)
        window.statusBarColor = color
    }
}