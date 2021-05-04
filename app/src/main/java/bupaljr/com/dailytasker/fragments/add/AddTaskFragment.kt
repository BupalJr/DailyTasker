package bupaljr.com.dailytasker.fragments.add

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import bupaljr.com.dailytasker.*
import bupaljr.com.dailytasker.model.Task
import bupaljr.com.dailytasker.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_add_task.*
import kotlinx.android.synthetic.main.fragment_add_task.view.*


class AddTaskFragment : Fragment() {

    private lateinit var mTaskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)

        mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)


        view.add_task_btn.setOnClickListener{
            insertDataToDatabase()
        }

        view.cardView_morning_routine.setOnClickListener {
            findNavController().navigate(R.id.action_addTaskFragment_to_morningRoutineFragment)

        }

        view.cardView_all_day_tasks.setOnClickListener {
            findNavController().navigate(R.id.action_addTaskFragment_to_allDayRoutineFragment)

        }

        view.cardView_evening_routine.setOnClickListener {
            findNavController().navigate(R.id.action_addTaskFragment_to_eveningRoutineFragment)

        }


        return view
    }

    private fun insertDataToDatabase() {
        val taskDesc = add_task_et.text.toString()


        if (inputCheck(taskDesc)) {
            // Create Task Object
            val task = Task(0, taskDesc)
            // Add data into the database
            mTaskViewModel.addTask(task)
            // Display a message
//            Toast.makeText(requireContext(), "Task Added", Toast.LENGTH_SHORT).show()
            // Navigate back to the main
            findNavController().navigate(R.id.action_addTaskFragment_to_listTaskFragment)
        }
        else {
            // Display a  message to prompt to add message
//            Toast.makeText(requireContext(), "Please Add a task", Toast.LENGTH_LONG).show()

        }

    }

    private fun inputCheck(taskDesc: String): Boolean {
        return  !(TextUtils.isEmpty(taskDesc))
    }
}