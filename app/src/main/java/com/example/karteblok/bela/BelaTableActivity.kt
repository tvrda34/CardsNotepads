package com.example.karteblok.bela

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.karteblok.R
import com.example.karteblok.databinding.ActivityBelaTableBinding
import com.example.karteblok.models.BelaModel

class BelaTableActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBelaTableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivityBelaTableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //status bar color set-up
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        val color = ColorUtils.setAlphaComponent(getColor(R.color.surface_1_white), 216)
        window.statusBarColor = color

        //back button
        binding.toolbar.backArrow.setOnClickListener {
            this.finish()
        }

        //mockana lista samo za prezentaciju
        val resultList = listOf(BelaModel(24, 138), BelaModel(162, 0), BelaModel(35, 127))

        binding.belaScoresRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.belaScoresRecycler.adapter = BelaScoreRecyclerAdapter(this, resultList)
        binding.belaScoresRecycler.setHasFixedSize(true)
    }
}