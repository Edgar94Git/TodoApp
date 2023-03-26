package com.ereyes.todoapp

/****
 * Project: TodoApp
 * From: com.ereyes.todoapp
 * Created by Edgar Reyes Gonzalez on 3/25/2023 at 9:20 AM
 * All rights reserved 2023.
 ****/
sealed class Category(var isSelected: Boolean = true){
    object Personal : Category()
    object Business : Category()
    object Other : Category()
}
