package bupaljr.com.dailytasker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        setupActionBarWithNavController(findNavController(R.id.fragment))

    }
        override fun onSupportNavigateUp(): Boolean {
            val navController = findNavController(R.id.fragment)
            return navController.navigateUp() || super.onSupportNavigateUp()
        }
}























