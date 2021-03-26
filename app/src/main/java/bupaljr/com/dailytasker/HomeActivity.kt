package bupaljr.com.dailytasker

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // get reference
        val addNewTask = findViewById<FloatingActionButton>(R.id.add_task)
        val clickDone = findViewById<ImageView>(R.id.click_done_tasks)
        val clickMenu = findViewById<ImageView>(R.id.click_menu)

        addNewTask.setOnClickListener {
            val intent = Intent(this, ChooseMainTasks::class.java)
            startActivity(intent)
        }

        clickDone.setOnClickListener {
            val intent = Intent(this, DoneTasksActivity::class.java)
            startActivity(intent)
        }

        clickMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }


        }
}























