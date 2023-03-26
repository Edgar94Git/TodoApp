package com.ereyes.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

/****
 * Project: TodoApp
 * From: com.ereyes.todoapp
 * Created by Edgar Reyes Gonzalez on 3/25/2023 at 9:19 AM
 * All rights reserved 2023.
 ****/
class CategoryAdapter(private val categories: List<Category>, private val onCategorySelected: (Int) -> Unit):
    RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.sender(categories[position])
        holder.itemView.setOnClickListener {
            onCategorySelected(position)
        }
    }

    override fun getItemCount() = categories.size
}