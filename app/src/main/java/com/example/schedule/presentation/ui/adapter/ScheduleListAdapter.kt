package com.example.schedule.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_api.models.ScheduleApiList
import com.example.schedule.databinding.ScheduleListItemBinding

/**
 * @author b.sabirzyanov
 */
class ScheduleListAdapter(
    private val onDeleteItem: (ScheduleApiList) -> Unit
) : ListAdapter<ScheduleApiList, ScheduleListAdapter.ScheduleViewHolder>(DiffCallback()) {

    private val itemTouchHelper: ItemTouchHelper

    init {
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                onDeleteItem(getItem(position))
            }
        }
        itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ScheduleListItemBinding.inflate(inflater, parent, false)
        return ScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ScheduleViewHolder(private val binding: ScheduleListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var currentItem: ScheduleApiList



        fun bind(item: ScheduleApiList) {
            currentItem = item
            with(binding) {
                tVTitleMainListItem.text = item.title
                tVCountMainListItemItems.text = item.scheduleItemsCount.toString()
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<ScheduleApiList>() {
        override fun areItemsTheSame(oldItem: ScheduleApiList, newItem: ScheduleApiList): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ScheduleApiList,
            newItem: ScheduleApiList
        ): Boolean {
            return oldItem == newItem
        }
    }
}

