package com.ereyes.todoapp

/****
 * Project: TodoApp
 * From: com.ereyes.todoapp
 * Created by Edgar Reyes Gonzalez on 3/25/2023 at 11:54 AM
 * All rights reserved 2023.
 ****/
data class Task(val name: String, val category: Category, var isSelected: Boolean = false)
