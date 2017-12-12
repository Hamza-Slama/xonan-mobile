package ia2.moduleproject.eniso.xonan.Activity

import android.content.Context
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
        tv1.text= User.toString()
        submit.setOnClickListener {
            var user = user.text //hamza.slama
            var pass = pass.text //hamza0277
            url = "http://eniso.info/ws/login/$user?password=$pass"
            getDataFromApi(this,url).execute()
            tv1.text= User.toString()

        }

    }

}
