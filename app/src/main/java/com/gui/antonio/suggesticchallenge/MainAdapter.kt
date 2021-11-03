package com.gui.antonio.suggesticchallenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gui.antonio.suggesticchallenge.databinding.ItemDayBinding

class MainAdapter(
    private val items: List<DayModel>,
    var itemDayClicked: (DayModel) -> Unit
) : RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemDayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) { day ->
            itemDayClicked(day)
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}