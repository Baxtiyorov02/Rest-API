package com.example.useretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.useretrofit.databinding.ItemBinding
import com.example.useretrofit.models.MarvelModel

class Adapter : RecyclerView.Adapter<Adapter.VH>() {

    private val list= mutableListOf<MarvelModel>()

    fun load(newList: List<MarvelModel>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }



    inner class VH(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MarvelModel) {
            with(binding){
                tvname.text = item.name
                imv.load(item.imageurl)
                tvby.text=item.createdby
                tvreal.text=item.realname
                tvteam.text=item.team
                tvfirst.text=item.firstappearance
                tvpublisher.text=item.publisher
                bio.text=item.bio
            }

        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemBinding.inflate(LayoutInflater
            .from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(list[position])
    }
}

