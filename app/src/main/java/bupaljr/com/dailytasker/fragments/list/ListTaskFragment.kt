package bupaljr.com.dailytasker.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import bupaljr.com.dailytasker.R
import bupaljr.com.dailytasker.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_list_task.view.*

class ListTaskFragment : Fragment() {

    private lateinit var mTaskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_task, container, false)

        // RecyclerView
        val adapter = ListTaskAdapter()
        val recyclerView = view.recycler_view
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // ViewModel
        mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        mTaskViewModel.readAllData.observe(viewLifecycleOwner, Observer { task ->
            adapter.setData(task)
        })

        // FloatingPoint from list to add fragment
        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listTaskFragment_to_addTaskFragment)
        }

        view.click_menu.setOnClickListener {
            findNavController().navigate(R.id.action_listTaskFragment_to_menuFragment)
        }

        // Add Menu
        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteAllTasks()
        }
        return  super.onOptionsItemSelected(item)
    }

    private fun deleteAllTasks() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mTaskViewModel.deleteAllTasks()
        }
        builder.setNegativeButton("No") {_, _->}
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you you want to delete everything?")
        builder.create().show()
    }
}