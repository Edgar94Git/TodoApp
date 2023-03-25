package com.ereyes.todoapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ereyes.todoapp.databinding.ItemCategoryBinding

/****
 * Project: TodoApp
 * From: com.ereyes.todoapp
 * Created by Edgar Reyes Gonzalez on 3/25/2023 at 9:24 AM
 * All rights reserved 2023.
 ****/
class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemCategoryBinding.bind(view)
    fun setListener(category: Category){

    }
}