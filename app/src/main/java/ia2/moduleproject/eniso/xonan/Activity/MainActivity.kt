package ia2.moduleproject.eniso.xonan.Activity

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ia2.moduleproject.eniso.xonan.R
import ia2.moduleproject.eniso.xonan.Services.User
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import ia2.moduleproject.eniso.xonan.Services.getDataFeatured
import ia2.moduleproject.eniso.xonan.Services.getDataLoginFromApi


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var urlLogin = ""
        tv1.text= User.toString()
        var id = 0

        submit.setOnClickListener {
            var user = user.text

            var pass = pass.text

            urlLogin = "http://eniso.info/ws/login/$user?password=$pass"
            var urls = "http://eniso.info/ws/wscript?s=Return(bean(%27core%27).findFullArticlesByCategory(%27Featured%27))"
            getDataLoginFromApi(this,urlLogin).execute()
            getDataFeatured(this,urls,urlLogin).execute()
            tv1.text= User.toString()
            if (id >=1 && User!!.domain == "main"){
                Intent(this,EventActivity::class.java).apply {
                    startActivity(this)
                }
               println("Ok")
                val bread = Toast.makeText(applicationContext, "ok", Toast.LENGTH_LONG)
                bread.show()
            }
            id ++
        }

    }

}
