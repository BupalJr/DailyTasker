package bupaljr.com.dailytasker.repository

import androidx.lifecycle.LiveData
import bupaljr.com.dailytasker.data.TaskDao
import bupaljr.com.dailytasker.model.Task

class TaskRepository(private val taskDao: TaskDao) {

    val readAllData: LiveData<List<Task>> = taskDao.readAllData()

    suspend fun addTask(task: Task) {
        taskDao.addTask(task)
    }

    suspend fun updateTask (task: Task){
        taskDao.updateTask(task)
    }

    suspend fun deleteTask (task: Task){
        taskDao.deleteTask(task)
    }

    suspend fun deleteAllTasks (){
        taskDao.deleteAllTasks()
    }
}