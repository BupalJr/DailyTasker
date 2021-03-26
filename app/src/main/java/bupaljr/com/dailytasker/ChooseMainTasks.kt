package bupaljr.com.dailytasker

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class ChooseMainTasks : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_main_tasks)

        // get reference
        val backArrow = findViewById<ImageView>(R.id.back_arrow)
        val morningTasks = findViewById<CardView>(R.id.cardView_morning_routine)
        val allDayTask = findViewById<CardView>(R.id.cardView_all_day_tasks)
        val eveningTasks = findViewById<CardView>(R.id.cardView_evening_routine)


        // set on-click listener
        backArrow.setOnClickListener {
            //Clicks to open the activity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // set on-click listener
        morningTasks.setOnClickListener {
            //Clicks on the floating Action To open the add
            val intent = Intent(this, MorningTasks::class.java)
            startActivity(intent)
        }

        // set on-click listener
        allDayTask.setOnClickListener {
            //Clicks on the floating Action To open the add
            val intent = Intent(this, AllDayTask::class.java)
            startActivity(intent)
        }

        // set on-click listener
        eveningTasks.setOnClickListener {
            //Clicks on the floating Action To open the add
            val intent = Intent(this, EveningTasks::class.java)
            startActivity(intent)
        }
    }
}