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

class MainActivity : AppCompatActivity() {

    private val categories = listOf(
        Business,
        Personal,
        Other
    )

    private val tasks = mutableListOf(
        Task("Negocios", Business),
        Task("Negocios 02", Business),
        Task("Personal 01", Personal),
        Task("Otros ", Other),
        Task("Otros 01", Other)
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
        categoryAdapter = CategoryAdapter(categories) { position -> updateCategory(position) }
        binding.rvCategories.adapter = categoryAdapter
        binding.rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        taskAdapter = TaskAdapter(tasks){ position -> onTaskSelected(position)}
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

        if(task.isNotEmpty()){
            val currentCategory: Category = when(selectedRadioButton.text){
                getString(R.string.text_business) -> Business
                getString(R.string.text_personal) -> Personal
                else -> Other
            }
            addTask(Task(task, currentCategory))
        }
    }

    private fun addTask(task: Task) {
        tasks.add(task)
        updateAdapterTask()
        dialogTask.hide()
    }

    private fun updateAdapterTask(){
        val selectedCategories: List<Category> = categories.filter { it.isSelected }
        val newTask = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.tasks = newTask
        taskAdapter.notifyDataSetChanged()
    }

    private fun onTaskSelected(position: Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateAdapterTask()
    }

    private fun updateCategory(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoryAdapter.notifyItemChanged(position)
        updateAdapterTask()
    }

    private fun updateAdapterCategory() {
        categoryAdapter.notifyDataSetChanged()
    }
}