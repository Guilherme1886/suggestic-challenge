package com.gui.antonio.suggesticchallenge.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gui.antonio.suggesticchallenge.data.model.DayModel
import com.gui.antonio.suggesticchallenge.databinding.ItemDayBinding
import com.gui.antonio.suggesticchallenge.presentation.viewholder.MainViewHolder

class MainAdapter(
    var itemDayClicked: (DayModel) -> Unit
) : RecyclerView.Adapter<MainViewHolder>() {

    private val items = mutableListOf<DayModel>()

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

    fun updateData(items: List<DayModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

}