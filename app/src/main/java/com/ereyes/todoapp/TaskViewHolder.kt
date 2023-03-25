package com.ereyes.todoapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ereyes.todoapp.databinding.ItemTaskBinding

/****
 * Project: TodoApp
 * From: com.ereyes.todoapp
 * Created by Edgar Reyes Gonzalez on 3/25/2023 at 11:55 AM
 * All rights reserved 2023.
 ****/
class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemTaskBinding.bind(view)
    fun setListener(task: Task){

    }
}