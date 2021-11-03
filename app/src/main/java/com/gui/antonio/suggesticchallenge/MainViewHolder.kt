package com.gui.antonio.suggesticchallenge

import androidx.recyclerview.widget.RecyclerView
import com.gui.antonio.suggesticchallenge.databinding.ItemDayBinding

class MainViewHolder(
    private var itemDayView: ItemDayBinding,
    var itemDayClicked: (DayModel) -> Unit
) : RecyclerView.ViewHolder(itemDayView.root) {

    fun bind(dayModel: DayModel) {
        itemDayView.apply {
            numberOfDayTextView.text = dayModel.day.toString()
            descriptionOfDayTextView.text = dayModel.day.toString()
            titleTextView.text = dayModel.title
            subtitleTextView.text = dayModel.title
            root.setOnClickListener { itemDayClicked(dayModel) }
        }
    }
}
