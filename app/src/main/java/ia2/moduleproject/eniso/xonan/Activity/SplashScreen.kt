package ia2.moduleproject.eniso.xonan.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import ia2.moduleproject.eniso.xonan.R
import kotlinx.android.synthetic.main.activity_splash_screen.*
import org.apache.commons.io.IOUtils
import java.io.IOException

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        try{
            val inputStrem = assets.open("work.gif")
            val bytes = IOUtils.toByteArray(inputStrem)
            gifImageView.setBytes(bytes)
            gifImageView.startAnimation()

        }catch (ex: IOException){

        }
        Handler().postDelayed({
             Intent(this, MainActivity::class.java).apply {
            startActivity(this)

             }
        }, 3000)
    }
}
