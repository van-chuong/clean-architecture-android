package com.example.clean_chitecture.presentation.views.building.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.example.clean_chitecture.R
import com.example.clean_chitecture.model.Building

class BuildingAdapter(context: Context, buildings: List<Building>) : ArrayAdapter<Building>(context, android.R.layout.simple_dropdown_item_1line, buildings) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val building = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_dropdown, parent, false)
        val textView = view.findViewById<AppCompatTextView>(R.id.title)
        textView.text = building?.name ?: ""
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }
}