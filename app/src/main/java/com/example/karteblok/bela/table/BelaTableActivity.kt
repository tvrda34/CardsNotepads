package com.example.karteblok.bela.table

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.karteblok.R
import com.example.karteblok.bela.entry.BelaEntryActivity
import com.example.karteblok.databinding.ActivityBelaTableBinding
import com.example.karteblok.databinding.ClearGameBoxBinding
import com.example.karteblok.models.BelaModel
import com.example.karteblok.models.dealersList

class BelaTableActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBelaTableBinding
    private var tablePosition = 0


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

        //who's the dealer
        binding.toolbar.dealerButton.setOnClickListener {
            getDealer()
            tablePosition = ++tablePosition % 4
        }

        //clear the game
        binding.toolbar.clearButton.setOnClickListener {
            val clearBinding = ClearGameBoxBinding.inflate(layoutInflater)
            val dialog: AlertDialog = AlertDialog.Builder(this)
                .setView(clearBinding.root)
                .create()

            clearBinding.bttnClear.setOnClickListener {
                dialog.dismiss()

            }

            clearBinding.bttnCancel.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }

        //game result colors
        setColors()

        //mockana lista samo za prezentaciju
        val resultList = listOf(BelaModel(24, 138), BelaModel(162, 0), BelaModel(35, 127))

        binding.belaScoresRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.belaScoresRecycler.adapter = BelaScoreRecyclerAdapter(this, resultList)
        binding.belaScoresRecycler.setHasFixedSize(true)

        //new entry
        binding.buttonEntry.setOnClickListener {
            this.startActivity(Intent(this, BelaEntryActivity::class.java))
        }
    }

    private fun getDealer() {
        val dealer = dealersList[tablePosition]
        Toast.makeText(this, getString(dealer), Toast.LENGTH_SHORT).show()
    }

    private fun setColors() {
        if (binding.semaphore.team1Total.text.toString()
                .compareTo(binding.semaphore.team2Total.text.toString()) == 0
        ) {
            binding.semaphore.team1Total.backgroundTintList =
                ColorStateList.valueOf(getColor(R.color.bela_yellow))
            binding.semaphore.team2Total.backgroundTintList =
                ColorStateList.valueOf(getColor(R.color.bela_yellow))

        } else
            if (binding.semaphore.team1Total.text.toString() > binding.semaphore.team2Total.text.toString()
            ) {
                binding.semaphore.team1Total.backgroundTintList =
                    ColorStateList.valueOf(getColor(R.color.bela_green2))
                binding.semaphore.team2Total.backgroundTintList =
                    ColorStateList.valueOf(getColor(R.color.bela_red))
            } else {
                binding.semaphore.team1Total.backgroundTintList =
                    ColorStateList.valueOf(getColor(R.color.bela_red))
                binding.semaphore.team2Total.backgroundTintList =
                    ColorStateList.valueOf(getColor(R.color.bela_green2))
            }
    }
}