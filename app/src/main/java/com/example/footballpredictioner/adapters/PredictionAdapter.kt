package com.example.footballpredictioner.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footballpredictioner.R
import com.example.footballpredictioner.models.SinglePredictionRowModel

class PredictionAdapter(private val dataSet: Array<SinglePredictionRowModel>, var context: Context): RecyclerView.Adapter<PredictionAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dateTextView: TextView
        val teamsTextView: TextView
        val firstPredictionTextView: TextView
        val secondPredictionTextView: TextView
        val thirdPredictionTextView: TextView

        init {
            dateTextView = view.findViewById(R.id.date)
            teamsTextView = view.findViewById(R.id.teams)
            firstPredictionTextView = view.findViewById(R.id.firstPrediction)
            secondPredictionTextView = view.findViewById(R.id.secondPrediction)
            thirdPredictionTextView = view.findViewById(R.id.thirdPrediction)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.single_prediction, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val singlePredictionRow = dataSet[position]

        viewHolder.dateTextView.text = singlePredictionRow.date
        viewHolder.teamsTextView.text = "%s - %s".format(singlePredictionRow.team1, singlePredictionRow.team2)
        viewHolder.firstPredictionTextView.text = singlePredictionRow.prediction1
        viewHolder.secondPredictionTextView.text = singlePredictionRow.prediction2
        viewHolder.thirdPredictionTextView.text = singlePredictionRow.prediction3
    }

    override fun getItemCount() = dataSet.size
}