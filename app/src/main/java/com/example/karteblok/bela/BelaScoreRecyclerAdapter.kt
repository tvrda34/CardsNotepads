package com.example.karteblok.bela

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.karteblok.R
import com.example.karteblok.databinding.BelaScoreRowBinding
import com.example.karteblok.models.BelaModel

class BelaScoreRecyclerAdapter(private val context: Context, private val data: List<BelaModel>) :
    RecyclerView.Adapter<BelaScoreRecyclerAdapter.ScoreViewHolder>() {

    class ScoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = BelaScoreRowBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.bela_score_row, parent, false)
        return ScoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        val results = data[position]

        holder.binding.score1.text = results.score1.toString()
        holder.binding.score2.text = results.score2.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }
}