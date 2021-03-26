package bupaljr.com.dailytasker

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Setting the animation of the name logo
        val nameLogo: ImageView = findViewById(R.id.splash_screen_name)
        val topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        nameLogo.startAnimation(topAnim)


        // Setting the splash screen delayed time
        Handler().postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000) // Delayed time in milliseconds
    }
}