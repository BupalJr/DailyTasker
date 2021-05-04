package bupaljr.com.dailytasker.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import bupaljr.com.dailytasker.R
import bupaljr.com.dailytasker.model.Task
import bupaljr.com.dailytasker.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_update_task.*
import kotlinx.android.synthetic.main.fragment_update_task.view.*


class UpdateTaskFragment : Fragment() {

    private val args by navArgs<UpdateTaskFragmentArgs>()
    private lateinit var mTaskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update_task, container, false)

        mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        view.update_task_et.setText(args.currentTask.taskDes)

        view.update_task_btn.setOnClickListener {
            updateTask()
        }

        // Add Menu
        setHasOptionsMenu(true)

        return view
    }

    private fun updateTask() {

        val taskDes = update_task_et.text.toString()

        if (inputCheck(taskDes)) {
            // Create Task Object
            val updateTask = Task(args.currentTask.id, taskDes)
            // Update Current Task
            mTaskViewModel.updateTask(updateTask)
            // Send a toast message
            Toast.makeText(requireContext(), "Successfully Updated", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_updateTaskFragment_to_listTaskFragment)
        } else {
            Toast.makeText(requireContext(), "Please update tasks", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(taskDesc: String): Boolean {
        return !(TextUtils.isEmpty(taskDesc))
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteTask()
        }
        return  super.onOptionsItemSelected(item)
    }

    private fun deleteTask() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mTaskViewModel.deleteTask(args.currentTask)
            //Navigate back
            findNavController().navigate(R.id.action_updateTaskFragment_to_listTaskFragment)
        }
        builder.setNegativeButton("No") {_, _->}
        builder.setTitle("Delete?")
        builder.setMessage("Are you you want to delete?")
        builder.create().show()
    }

}