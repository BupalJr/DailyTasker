package bupaljr.com.dailytasker.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import bupaljr.com.dailytasker.R
import bupaljr.com.dailytasker.model.Task
import kotlinx.android.synthetic.main.task_row.view.*

class ListTaskAdapter: RecyclerView.Adapter<ListTaskAdapter.MyViewHolder>() {

    private var taskList = emptyList<Task>()

    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_row, parent, false))

    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTime = taskList[position]
        holder.itemView.id_txt.text = currentTime.id.toString()
        holder.itemView.taskDesc_txt.text = currentTime.taskDes

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListTaskFragmentDirections.actionListTaskFragmentToUpdateTaskFragment(currentTime)
            holder.itemView.findNavController().navigate(action)
        }

    }

    fun  setData(user:List<Task>) {
        this.taskList = user
        notifyDataSetChanged()
    }
}