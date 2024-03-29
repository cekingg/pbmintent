package com.example.intent

import  androidx.recyclerview.widget.RecyclerView
import  android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.contact_list_item.view.*

class  ContactAdapter (val phoneItemList: List<PhoneData>, val clickListener: (PhoneData) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.contact_list_item, parent, false)
        return PartViewHolder(view)
        }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(phoneItemList[position], clickListener)
        }

    override fun getItemCount() = phoneItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun  bind(phoneData: PhoneData, clickListener: (PhoneData) -> Unit) {
            itemView.tv_part_item_name.text = phoneData.contactName
            itemView.tv_part_id.text = phoneData.phoneData.toString()
            itemView.setOnClickListener{clickListener(phoneData)}
        }
    }
}


