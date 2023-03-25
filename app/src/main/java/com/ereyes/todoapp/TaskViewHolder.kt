package com.ereyes.todoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ereyes.todoapp.databinding.ItemTaskBinding

/****
 * Project: TodoApp
 * From: com.ereyes.todoapp
 * Created by Edgar Reyes Gonzalez on 3/25/2023 at 11:55 AM
 * All rights reserved 2023.
 ****/
class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemTaskBinding.bind(view)
    fun sender(task: Task){
        with(binding){
            tvTask.text = task.name
            cbTask.isChecked = task.isSelected

            if(task.isSelected) {
                tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }
            else{
                tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }

            val color = when(task.category){
                Category.Business -> R.color.todo_business_category
                Category.Other -> R.color.todo_other_category
                Category.Personal -> R.color.todo_personal_category
            }

            cbTask.buttonTintList = ColorStateList.valueOf(
                ContextCompat.getColor(cbTask.context, color)
            )
        }
    }
}