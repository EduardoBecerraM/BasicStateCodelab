package com.edebec.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTaskList().toMutableStateList()
    val tasks: List<WellnessTask> get() = _tasks

    fun changeTaskChecked(task: WellnessTask, checked: Boolean) {
        _tasks.find { it.id == task.id }?.let { taskItem ->
            taskItem.checked = checked
        }
    }

    fun remove(task: WellnessTask) {
        _tasks.remove(task)
    }
}

private fun getWellnessTaskList() = List(30) { i -> WellnessTask(id = i, label = "Task #$i") }