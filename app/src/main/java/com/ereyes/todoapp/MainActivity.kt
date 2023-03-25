package com.ereyes.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ereyes.todoapp.databinding.ActivityMainBinding
import com.ereyes.todoapp.Category.*
import com.ereyes.todoapp.databinding.DialogTaskBinding

class MainActivity : AppCompatActivity() {

    private val categories = listOf(
        Business,
        Personal,
        Other
    )

    private val tasks = mutableListOf(
        Task("Prueba", Business),
        Task("Prueba", Personal),
        Task("Prueba", Other)
    )

    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var dialogTask: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpAdapter()
        setUpFloating()
    }

    private fun setUpAdapter(){
        categoryAdapter = CategoryAdapter(categories)
        binding.rvCategories.adapter = categoryAdapter
        binding.rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        taskAdapter = TaskAdapter(tasks)
        binding.rvTasks.adapter = taskAdapter
        binding.rvTasks.layoutManager = LinearLayoutManager(this)
    }

    private fun setUpFloating(){
        binding.fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        dialogTask = Dialog(this)
        dialogTask.setContentView(R.layout.dialog_task)
        dialogTask.show()
        setUpButtonDialog()
    }

    private fun setUpButtonDialog(){
        val btnAddTask = dialogTask.findViewById<Button>(R.id.btnAddTask)
        btnAddTask.setOnClickListener { createTask() }
    }

    private fun createTask() {
        val rgCategories = dialogTask.findViewById<RadioGroup>(R.id.rgCategories)
        val etTask = dialogTask.findViewById<EditText>(R.id.etTask)

        val selectedId = rgCategories.checkedRadioButtonId
        val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
        val task = etTask.text.toString().trim()
        val currentCategory: Category = when(selectedRadioButton.text){
            getString(R.string.text_business) -> Business
            getString(R.string.text_personal) -> Personal
            else -> Other
        }
        addTask(Task(task, currentCategory))
    }

    private fun addTask(task: Task) {
        tasks.add(task)
        taskAdapter.notifyDataSetChanged()
        dialogTask.hide()
    }
}