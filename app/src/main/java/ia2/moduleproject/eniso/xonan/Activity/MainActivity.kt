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
import ia2.moduleproject.eniso.xonan.Constant.MyUserLoginAndPassword
import ia2.moduleproject.eniso.xonan.Services.getDataFeatured
import ia2.moduleproject.eniso.xonan.Services.getDataLoginFromApi


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var urlLogin = ""
//        tv1.text= User.toString()
        var id = 0
        getLoginUser()
        submit.setOnClickListener { // login button
            var user = user.text // login name
            var pass = pass.text
            urlLogin = "http://eniso.info/ws/login/$user?password=$pass"
//            var urls = "http://eniso.info/ws/wscript?s=Return(bean(%27core%27).findFullArticlesByCategory(%27Featured%27))"
            getDataLoginFromApi(this,urlLogin).execute()
//            getDataFeatured(this,urls,urlLogin).execute()
            tv1.text= User.toString()
            if (User != null){
            if (id >=1 && User!!.domain == "main") {
                Intent(this, EventActivity::class.java).apply {
                    startActivity(this)
                }
            }
//               Toast.makeText(applicationContext, "SUCCESFUL LOGIN", Toast.LENGTH_LONG).show()

            }else {
//                Toast.makeText(applicationContext, "Enter a valdie Login or Password", Toast.LENGTH_LONG).show()
            }
            id ++
            if (remember_me!!.isChecked == true) {
                saveLoginUser()
                getLoginUser()
            }
        }

    }




    fun saveLoginUser() {
        val infofile = getSharedPreferences(MyUserLoginAndPassword, Context.MODE_PRIVATE)
        val editor = infofile.edit()
        editor.putString("username", user!!.text.toString())
        editor.putString("pass", pass!!.text.toString())
        editor.apply()

    }

    fun getLoginUser() {

        val infofile = getSharedPreferences(MyUserLoginAndPassword, Context.MODE_PRIVATE)
        val name = infofile.getString("username", "")
        val paswword = infofile.getString("pass", "")
        user!!.setText(name)
        pass!!.setText(paswword)
    }

}
