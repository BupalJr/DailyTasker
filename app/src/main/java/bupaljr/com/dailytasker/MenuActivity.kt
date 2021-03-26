package bupaljr.com.dailytasker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // get reference
        val clickHome = findViewById<LinearLayout>(R.id.click_home)
        val clickDone = findViewById<LinearLayout>(R.id.click_done_tasks)
        val clickNotifications = findViewById<LinearLayout>(R.id.click_notifications)


        clickHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        clickDone.setOnClickListener {
            val intent = Intent(this, DoneTasksActivity::class.java)
            startActivity(intent)
        }

    }
}