package com.ereyes.todoapp

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ereyes.todoapp.databinding.ItemCategoryBinding

/****
 * Project: TodoApp
 * From: com.ereyes.todoapp
 * Created by Edgar Reyes Gonzalez on 3/25/2023 at 9:24 AM
 * All rights reserved 2023.
 ****/
class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemCategoryBinding.bind(view)
    fun sender(category: Category){
        when(category){
            Category.Business -> {
                loadedData(R.string.text_business, R.color.todo_business_category)
            }
            Category.Personal -> {
                loadedData(R.string.text_personal, R.color.todo_personal_category)
            }
            Category.Other -> {
                loadedData(R.string.text_other, R.color.todo_other_category)
            }
        }
    }

    private fun loadedData(textId: Int, colorId: Int){
        with(binding){
            tvCategory.text = tvCategory.context.getString(textId)
            vDivider.setBackgroundColor(
                ContextCompat.getColor(vDivider.context, colorId)
            )
        }
    }
}