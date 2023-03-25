package com.ereyes.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/****
 * Project: TodoApp
 * From: com.ereyes.todoapp
 * Created by Edgar Reyes Gonzalez on 3/25/2023 at 11:54 AM
 * All rights reserved 2023.
 ****/
class TaskAdapter(private val tasks: List<Task>): RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        with(holder){
            setListener(task)
            with(binding){
                tvTask.text = task.name
                cbTask.isChecked = task.isSelected
            }
        }
    }

    override fun getItemCount() = tasks.size
}