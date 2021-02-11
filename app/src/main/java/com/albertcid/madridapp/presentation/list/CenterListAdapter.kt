package com.albertcid.madridapp.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.albertcid.madridapp.R
import com.albertcid.madridapp.domain.model.Center
import kotlinx.android.synthetic.main.item_list.view.*
import kotlin.properties.Delegates

class CenterListAdapter: RecyclerView.Adapter<CenterItemHolder>() {

    var list: List<Center> by Delegates.observable(emptyList()) { _, oldValue, newValue ->
        if (oldValue != newValue) {
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CenterItemHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_list, parent, false)
        return CenterItemHolder(view)
    }

    override fun onBindViewHolder(holder: CenterItemHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}

class CenterItemHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(center: Center) {
        with(itemView){
            title_tv.text = center.title
            locality_tv.text = center.locality
            postal_code_tv.text = center.postalCode.toString()
            address_tv.text = center.streetAddress
        }
    }
}