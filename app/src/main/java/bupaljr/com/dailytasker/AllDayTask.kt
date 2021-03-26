package bupaljr.com.dailytasker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AllDayTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_day_task)

        // get reference
        val backArrow = findViewById<ImageView>(R.id.back_arrow)
        // set on-click listener
        backArrow.setOnClickListener {
            //Clicks to open the activity
            val intent = Intent(this, ChooseMainTasks::class.java)
            startActivity(intent)
        }
    }
}