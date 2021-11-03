package com.gui.antonio.suggesticchallenge.presentation.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.gui.antonio.suggesticchallenge.R
import com.gui.antonio.suggesticchallenge.data.model.DayModel
import com.gui.antonio.suggesticchallenge.databinding.ItemDayBinding
import com.gui.antonio.suggesticchallenge.helper.descriptionFromDay
import java.util.*

class MainViewHolder(
    private var itemDayView: ItemDayBinding,
    var itemDayClicked: (DayModel) -> Unit
) : RecyclerView.ViewHolder(itemDayView.root) {

    fun bind(dayModel: DayModel) {
        itemDayView.apply {
            numberOfDayTextView.text = dayModel.day.toString()
            descriptionOfDayTextView.text = itemDayView.root.context.getString(R.string.description_from_day, dayModel.day.descriptionFromDay())
            titleTextView.text = dayModel.title
            subtitleTextView.text = dayModel.subtitle
            root.setOnClickListener { itemDayClicked(dayModel) }
        }
    }
}
