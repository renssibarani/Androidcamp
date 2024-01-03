package com.mandiri.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mandiri.mandiriapps.databinding.ItemNotificationBinding
import com.mandiri.mandiriapps.model.NotificationModel

class NotificationAdapter(
    private val listNotification: List<NotificationModel>
) : Adapter<NotificationAdapter.NotificationViewHolder>() {
    inner class NotificationViewHolder(private val itemBinding: ItemNotificationBinding):
        ViewHolder(itemBinding.root){
            fun bind(data: NotificationModel){
                itemBinding.tvDate.text = data.date
                itemBinding.tvTitleNotif.text = data.title
                itemBinding.tvSubtitleNotif.text= data.subtitle
            }
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(
            ItemNotificationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(listNotification[position])
    }

    override fun getItemCount(): Int {
        return listNotification.size
    }
}