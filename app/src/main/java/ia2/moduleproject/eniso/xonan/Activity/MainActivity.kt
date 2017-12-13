package ia2.moduleproject.eniso.xonan.Activity

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ia2.moduleproject.eniso.xonan.R
import ia2.moduleproject.eniso.xonan.Services.User
import ia2.moduleproject.eniso.xonan.Services.getDataFromApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var url = ""
        tv1.text= User.toString()// for show the json file
        var id = 0
        submit.setOnClickListener { // login button
            var user = user.text // login name

            var pass = pass.text
            url = "http://eniso.info/ws/login/$user?password=$pass"
            getDataFromApi(this,url).execute()
            tv1.text= User.toString()
            if (id >=1 && User!!.domain == "main"){
                Intent(this,Inspection::class.java).apply {
                    startActivity(this)
                }
            }
            id ++
        }

    }

}
