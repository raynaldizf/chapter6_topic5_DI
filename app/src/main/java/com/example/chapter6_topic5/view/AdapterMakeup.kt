package com.example.chapter6_topic5.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter6_topic5.databinding.ItemMakeupBinding
import com.example.chapter6_topic5.model.ResponseDataMakeupItem

class AdapterMakeup (var dataMakeup : List<ResponseDataMakeupItem>?): RecyclerView.Adapter<AdapterMakeup.ViewHolder>() {
    class ViewHolder(var binding : ItemMakeupBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemMakeupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTitle.text = dataMakeup!![position].name
        holder.binding.tvPrice.text = dataMakeup!![position].price
        holder.binding.tvPriceSign.text = dataMakeup!![position].priceSign
    }

    override fun getItemCount(): Int {
        return dataMakeup!!.size
    }
}