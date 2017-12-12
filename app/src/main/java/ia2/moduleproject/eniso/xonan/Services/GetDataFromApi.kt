package ia2.moduleproject.eniso.xonan.Services

import android.annotation.SuppressLint
import ia2.moduleproject.eniso.xonan.Activity.MainActivity
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import ia2.moduleproject.eniso.xonan.Model.UserInformation
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by Hamza on 12/12/2017.
 */
var User: UserInformation? = null

class getDataFromApi() : AsyncTask<Void, Void, String>() {


    var context: Context? = null
    var url: String? = null

    constructor(context: Context, url: String) : this() {
        this.context = context
        this.url = url
    }

    lateinit var progressDialog: ProgressDialog
    var hasInternet = false

    override fun onPreExecute() {
        super.onPreExecute()
        progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Downloading Data ...")
        progressDialog.setCancelable(false)
        progressDialog.show()
    }

    override fun doInBackground(vararg p0: Void?): String {
        if (isNetworkAvailable()) {
            hasInternet = true
            val client = OkHttpClient()

//                val url = "http://eniso.info/ws/login/toto?password=toto1243"
            val request = Request.Builder().url(url).build()
            val response = client.newCall(request).execute()
            return response.body()?.string().toString()
        } else {
            return ""
        }
    }

    @SuppressLint("NewApi")
    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        progressDialog.dismiss()

        if (hasInternet) {
            try {
                val resultArrays = JSONObject(result)
                var r = resultArrays.getJSONObject("$1")
                var id = r.getString("userId")
                var domain = r.getString("domain")
                var userLogin = r.getString("userLogin")
                var userFullName = r.getString("userFullName")
                var userFullTitle = r.getString("userFullTitle")
                var locale = r.getString("locale")
                var profileNames = r.getString("profileNames")
                User = UserInformation(id, domain, userLogin, userFullName, userFullTitle, locale, profileNames)
                println("User =$User")
                println("User to string= ${User.toString()}")


//                var profileNamesArr = JSONArray(profileNames)

                /*       str += "id : " + id.toString()
                       str +="\n domain : "+ domain.toString()
                       str +="\n userLogin : "+ userLogin.toString()
                       str +="\n userFullName : "+ userFullName.toString()
                       str +="\n userFullTitle : "+ userFullTitle.toString()
                       str +="\n locale : "+ locale.toString()
                       str +="\n profileNames : "+ profileNamesArr.toString()
                       tv1.text = str
                       println("----------------------- +\n $str")

                       tv1.text = str*/
            } catch (e: JSONException) {

            }
        }

    }

    fun getUser(): String {
        return User!!.toString()
    }

    fun isNetworkAvailable(): Boolean {
        val connectivityManager = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}


